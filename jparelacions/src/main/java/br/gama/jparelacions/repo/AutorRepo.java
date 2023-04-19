package br.gama.jparelacions.repo;

import org.springframework.data.repository.CrudRepository;

import br.gama.jparelacions.model.Autor;

public interface AutorRepo extends CrudRepository<Autor, Long> {
    
}
