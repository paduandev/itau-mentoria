package br.gama.relacional.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.gama.relacional.model.Tutorial;

public interface TutorialRepo extends CrudRepository<Tutorial, Long> {
    List<Tutorial> findByTitleContaining(String title);
}
