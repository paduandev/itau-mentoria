package br.gama.hexagonal.domain.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.stereotype.Service;

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
                        .dateTime(LocalDate.now())
                        .build();

                accountRepo.save(accountSource.get());
                accountRepo.save(accountTarged.get());
                Transfer transferDone = transferRepo.save(transferEntity);

                return Optional.of(transferDone);
            }
        }

        return Optional.empty();
    }


}
