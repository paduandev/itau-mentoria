package br.gama.hexagonal.infrastructure.adapter;

import org.springframework.stereotype.Repository;

import br.gama.hexagonal.domain.model.Transfer;
import br.gama.hexagonal.infrastructure.jpa.TransferEntity;
import br.gama.hexagonal.infrastructure.jpa.TransferRepoJPA;
import br.gama.hexagonal.infrastructure.port.out.TransferUseCase;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class TransferRepository implements TransferUseCase {
    
    private final TransferRepoJPA repo;

    @Override
    public Transfer save(TransferEntity transferEntity) {
        return repo.save(transferEntity).toTransfer();
    }

    @Override
    public Transfer load(long idTransfer) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'load'");
    }

}
