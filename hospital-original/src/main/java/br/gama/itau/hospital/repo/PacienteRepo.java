package br.gama.itau.hospital.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.gama.itau.hospital.model.Paciente;

public interface PacienteRepo extends CrudRepository<Paciente, Long> {
    Optional<Paciente> findByCpf(String cpf);
}
