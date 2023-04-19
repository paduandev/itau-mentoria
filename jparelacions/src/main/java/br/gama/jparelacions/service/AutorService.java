package br.gama.jparelacions.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gama.jparelacions.model.Autor;
import br.gama.jparelacions.repo.AutorRepo;

@Service
public class AutorService {
    
    @Autowired
    private AutorRepo repo;

    public Autor getAutor(long id) {
        return repo.findById(id).orElse(null);
    }

    public void deleteAutor(long id) {
        repo.deleteById(id);
    }
}
