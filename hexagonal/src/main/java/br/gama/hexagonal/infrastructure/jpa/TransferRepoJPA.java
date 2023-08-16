package br.gama.hexagonal.infrastructure.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepoJPA extends JpaRepository<TransferEntity, Long>{
    
}
