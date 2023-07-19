package br.gama.itau.hospital.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gama.itau.hospital.dto.AtendimentoDTO;
import br.gama.itau.hospital.dto.MedicamentosDTO;
import br.gama.itau.hospital.dto.NovoAtendimentoDTO;
import br.gama.itau.hospital.service.AtendimentoService;

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

}
