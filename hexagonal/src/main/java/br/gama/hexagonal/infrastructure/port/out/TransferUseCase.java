package br.gama.hexagonal.infrastructure.port.out;

import java.time.LocalDate;
import java.util.List;

import br.gama.hexagonal.domain.model.Transfer;
import br.gama.hexagonal.infrastructure.jpa.TransferEntity;

public interface TransferUseCase {
    Transfer save(TransferEntity transferEntity);
    Transfer load(long idTransfer);
    List<TransferEntity> loadByDate(long idAccount, LocalDate dateFrom, LocalDate dateTo);
}
