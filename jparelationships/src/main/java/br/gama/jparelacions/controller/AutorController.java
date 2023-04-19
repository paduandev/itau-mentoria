package br.gama.jparelacions.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gama.jparelacions.model.Autor;
import br.gama.jparelacions.service.AutorService;

@RestController
@RequestMapping("/autor")
public class AutorController {
    
    @Autowired
    private AutorService service;

    @GetMapping("/{id}")
    public ResponseEntity<Autor> getAutor(@PathVariable long id) {
        Autor autor = service.getAutor(id);

        if(autor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(autor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAutor(@PathVariable long id) {
        service.deleteAutor(id);
        return ResponseEntity.noContent().build();
    }
}
