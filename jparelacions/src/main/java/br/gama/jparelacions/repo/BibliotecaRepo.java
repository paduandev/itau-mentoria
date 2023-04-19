package br.gama.jparelacions.repo;

import org.springframework.data.repository.CrudRepository;

import br.gama.jparelacions.model.Biblioteca;

public interface BibliotecaRepo extends CrudRepository <Biblioteca, Long> {
    
}
