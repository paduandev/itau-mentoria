package br.gama.itau.hospital.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gama.itau.hospital.dto.AtendimentoDTO;
import br.gama.itau.hospital.dto.PacienteDTO;
import br.gama.itau.hospital.model.Paciente;
import br.gama.itau.hospital.service.PacienteService;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteService service;

    @PostMapping
    public ResponseEntity<Paciente> newPaciente(@RequestBody PacienteDTO pacienteDTO) {
        return new ResponseEntity<Paciente>(service.create(pacienteDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> getById(@PathVariable long id) {
        Optional<PacienteDTO> optional = service.getById(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<PacienteDTO> getByCpf(@PathVariable String cpf) {
        Optional<PacienteDTO> optional = service.getByCpf(cpf);
        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PatchMapping
    public ResponseEntity<PacienteDTO> update(@RequestBody PacienteDTO pacienteDTO) {
        Optional<PacienteDTO> optional = service.update(pacienteDTO);
        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/atendimentos")
    public ResponseEntity<List<AtendimentoDTO>> listAtendimento(@PathVariable long id) {
        List<AtendimentoDTO> atendimentos = service.listAtendimento(id);
        if (atendimentos.size() > 0) {
            return ResponseEntity.ok(atendimentos);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/cpf/{cpf}/atendimentos")
    public ResponseEntity<List<AtendimentoDTO>> listAtendimentoByCpf(@PathVariable String cpf) {
        List<AtendimentoDTO> atendimentos = service.listAtendimentoByCpf(cpf);
        if (atendimentos.size() > 0) {
            return ResponseEntity.ok(atendimentos);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        boolean deleted = service.delete(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
