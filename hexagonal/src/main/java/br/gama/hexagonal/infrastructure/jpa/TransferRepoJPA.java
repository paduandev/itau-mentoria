package br.gama.hexagonal.infrastructure.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepoJPA extends JpaRepository<TransferEntity, Long>{
    List<TransferEntity> findByAccountSourceNumberOrAccountTargetNumber(
        long accountSourceNumber, long accountTargetNumber);
}
