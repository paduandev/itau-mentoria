package br.gama.hexagonal.domain.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.gama.hexagonal.application.adapter.rest.dto.Historic;
import br.gama.hexagonal.application.port.in.TransferOperation;
import br.gama.hexagonal.domain.model.Account;
import br.gama.hexagonal.domain.model.Transfer;
import br.gama.hexagonal.infrastructure.jpa.TransferEntity;
import br.gama.hexagonal.infrastructure.port.out.AccountUseCase;
import br.gama.hexagonal.infrastructure.port.out.TransferUseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransferService implements TransferOperation {

    private final AccountUseCase accountRepo;
    private final TransferUseCase transferRepo;

    @Transactional
    @Override
    public Optional<Transfer> tranfer(long idAccountSource, long idAccountTarged, BigDecimal value) {
        Optional<Account> accountSource = accountRepo.load(idAccountSource);
        Optional<Account> accountTarged = accountRepo.load(idAccountTarged);

        if (accountSource.isEmpty() || accountTarged.isEmpty()) {
            return Optional.empty();
        }

        boolean withdrawSuccess = accountSource.get().withdraw(value);
        if (withdrawSuccess) {
            boolean depositSuccess = accountTarged.get().deposit(value);
            if (depositSuccess) {
                TransferEntity transferEntity = TransferEntity.builder()
                        .accountSourceNumber(idAccountSource)
                        .accountTargetNumber(idAccountTarged)
                        .value(value)
                        .dateTime(LocalDateTime.now())
                        .build();

                accountRepo.save(accountSource.get());
                accountRepo.save(accountTarged.get());
                Transfer transferDone = transferRepo.save(transferEntity);

                return Optional.of(transferDone);
            }
        }

        return Optional.empty();
    }

    public List<Historic> historic(long idAccount, LocalDate dateFrom, LocalDate dateTo) {
        List<TransferEntity> transferencias = transferRepo.loadByDate(idAccount, dateFrom, dateTo);

        return transferencias.stream()
                .filter(transf -> transf.getDateTime().toLocalDate().isAfter(dateFrom.minusDays(1))
                        && transf.getDateTime().toLocalDate().isBefore(dateTo.plusDays(1)))
                .map(t -> t.toTransfer())
                .map(transf -> {
                    String data = transf.getDateTime().format(DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm"));
                    if(transf.getAccountSourceNumber() == idAccount) {
                        return new Historic(transf.getValue().negate(), data);
                    }
                    return new Historic(transf.getValue(), data);
                })
                .toList();
    }

}
