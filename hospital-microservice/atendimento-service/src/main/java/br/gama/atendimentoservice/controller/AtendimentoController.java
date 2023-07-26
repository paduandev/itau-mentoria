package br.gama.atendimentoservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gama.atendimentoservice.dto.AtendimentoDTO;
import br.gama.atendimentoservice.dto.MedicamentosDTO;
import br.gama.atendimentoservice.dto.NovoAtendimentoDTO;
import br.gama.atendimentoservice.service.AtendimentoService;

@RestController
@RequestMapping("/atendimento")
public class AtendimentoController {

    @Autowired
    private AtendimentoService service;

    @PostMapping
    public ResponseEntity<AtendimentoDTO> inserir(@RequestBody NovoAtendimentoDTO novoAtendimentoDTO) {
        return new ResponseEntity<AtendimentoDTO>(service.create(novoAtendimentoDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtendimentoDTO> getById(@PathVariable long id) {
        Optional<AtendimentoDTO> optional = service.getById(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        }
        return ResponseEntity.notFound().build();
    }

    // Conclui o atendimento
    @PostMapping("/{id}")
    public ResponseEntity<Void> close(@PathVariable long id, @RequestBody MedicamentosDTO medicamentos) {
        if (service.close(id, medicamentos.getMedicamentos())) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/paciente/{id}")
    public ResponseEntity<List<AtendimentoDTO>> getByPaciente(@PathVariable long id){
        return ResponseEntity.ok(service.getByPaciente(id));
    }

    @DeleteMapping("/paciente/{idPaciente}")
    public ResponseEntity<Void> deleteByPaciente(@PathVariable long idPaciente) {
        service.deleteByPaciente(idPaciente);
        return ResponseEntity.noContent().build();
    }


}
