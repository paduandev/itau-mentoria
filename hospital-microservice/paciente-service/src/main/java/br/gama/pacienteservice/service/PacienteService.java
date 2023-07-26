package br.gama.pacienteservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.gama.pacienteservice.dto.AtendimentoDTO;
import br.gama.pacienteservice.dto.PacienteDTO;
import br.gama.pacienteservice.model.Paciente;
import br.gama.pacienteservice.repository.PacienteRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PacienteService {

    private final PacienteRepo repo;

    public Paciente create(PacienteDTO pacienteDTO) {
        return repo.save(new Paciente(pacienteDTO));
    }

    public Optional<PacienteDTO> getById(long id) {
        Optional<Paciente> optional = repo.findById(id);
        if (optional.isPresent()) {
            return Optional.of(new PacienteDTO(optional.get()));
        }
        return Optional.empty();
    }

    public Optional<PacienteDTO> getByCpf(String cpf) {
        Optional<Paciente> pacienteOptional = repo.findByCpf(cpf);
        if (pacienteOptional.isPresent()) {
            return Optional.of(new PacienteDTO(pacienteOptional.get()));
        }
        return Optional.empty();
    }

    public Optional<PacienteDTO> update(PacienteDTO pacienteDTO) {
        Optional<Paciente> pacienteOptional = repo.findById(pacienteDTO.getId());
        if (pacienteOptional.isPresent()) {
            pacienteOptional.get().setTelefone(pacienteDTO.getTelefone());
            return Optional.of(new PacienteDTO(repo.save(pacienteOptional.get())));
        }
        return Optional.empty();
    }

    public List<AtendimentoDTO> listAtendimento(long id) {
        Optional<Paciente> pacienteOptional = repo.findById(id);
        if (pacienteOptional.isPresent()) {

            // Solicita os dados de Atendimento para outro serviço

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<List<AtendimentoDTO>> response = restTemplate.exchange(
                    "http://localhost:8080/hospital/atendimento/paciente/" + id,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<AtendimentoDTO>>() {
                    });

            if (response.getStatusCode() == HttpStatus.OK) {
                return response.getBody();
            }

        }
        return new ArrayList<AtendimentoDTO>();
    }

    @Transactional
    public boolean delete(long id) {
        Optional<Paciente> pacienteOptional = repo.findById(id);
        if (pacienteOptional.isPresent()) {

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<Void> response = restTemplate.exchange(
                    "http://localhost:8080/hospital/atendimento/paciente/" + id,
                    HttpMethod.DELETE,
                    null,
                    new ParameterizedTypeReference<Void>() {
                    });

            if (response.getStatusCode() == HttpStatus.NO_CONTENT) {
                repo.deleteById(id);
            }

            return true;
        }
        return false;
    }

    public List<AtendimentoDTO> listAtendimentoByCpf(String cpf) {
        Optional<Paciente> pacienteOptional = repo.findByCpf(cpf);
        if (pacienteOptional.isPresent()) {

            long id = pacienteOptional.get().getId();

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<List<AtendimentoDTO>> response = restTemplate.exchange(
                    "http://localhost:8080/hospital/atendimento/paciente/" + id,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<AtendimentoDTO>>() {
                    });

            if (response.getStatusCode() == HttpStatus.OK) {
                return response.getBody();
            }
        }
        return new ArrayList<AtendimentoDTO>();
    }

}
