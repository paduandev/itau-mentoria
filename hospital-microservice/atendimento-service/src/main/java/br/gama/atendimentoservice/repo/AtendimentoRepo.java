package br.gama.atendimentoservice.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.gama.atendimentoservice.model.Atendimento;

public interface AtendimentoRepo extends CrudRepository<Atendimento, Long> {
    List<Atendimento> findByIdPaciente(long idPaciente);
    void deleteByIdPaciente(long idPaciente);
}
