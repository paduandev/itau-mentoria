package br.gama.pacienteservice.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.gama.pacienteservice.model.Paciente;

public interface PacienteRepo extends CrudRepository<Paciente, Long> {
    Optional<Paciente> findByCpf(String cpf);
}
