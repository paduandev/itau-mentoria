package br.gama.naorelacional.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.gama.naorelacional.model.Tutorial;

public interface TutorialRepo extends MongoRepository<Tutorial, String> {
    List<Tutorial> findByTitleContaining(String title);
}
