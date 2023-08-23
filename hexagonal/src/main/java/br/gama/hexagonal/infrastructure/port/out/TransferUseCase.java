package br.gama.hexagonal.infrastructure.port.out;

import br.gama.hexagonal.domain.model.Transfer;
import br.gama.hexagonal.infrastructure.jpa.TransferEntity;

public interface TransferUseCase {
    Transfer save(TransferEntity transferEntity);
    Transfer load(long idTransfer);
}
