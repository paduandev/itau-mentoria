package br.gama.itau.hospital.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.gama.itau.hospital.model.Atendimento;
import br.gama.itau.hospital.model.Paciente;


public interface AtendimentoRepo extends CrudRepository<Atendimento, Long> {
    List<Atendimento> findByPaciente(Paciente paciente);
}
