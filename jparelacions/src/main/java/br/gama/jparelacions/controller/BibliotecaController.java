package br.gama.jparelacions.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gama.jparelacions.model.Biblioteca;
import br.gama.jparelacions.service.BibliotecaService;

@RestController
@RequestMapping("/biblioteca")
public class BibliotecaController {
    
    @Autowired
    private BibliotecaService service;

    @GetMapping("/{id}")
    public ResponseEntity<Biblioteca> getBiblioteca(@PathVariable long id) {
        Biblioteca biblioteca = service.getBiblioteca(id);

        if(biblioteca == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(biblioteca);
    }

}
