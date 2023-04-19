package br.gama.jparelacions.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gama.jparelacions.model.Biblioteca;
import br.gama.jparelacions.repo.BibliotecaRepo;

@Service
public class BibliotecaService {
    @Autowired
    private BibliotecaRepo repo;

    public Biblioteca getBiblioteca(long id) {
        return repo.findById(id).orElse(null);
    }
}
