package br.gama.naorelacional.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.gama.naorelacional.model.Tutorial;
import br.gama.naorelacional.repository.TutorialRepo;

@RestController
@RequestMapping("/tutorial")
public class TutorialController {

    @Autowired
    private TutorialRepo repo;

    @PostMapping
    public ResponseEntity<Tutorial> create(@RequestBody Tutorial tutorial) {
        try {
            Tutorial newTutorial = repo.save(tutorial);
            return new ResponseEntity<>(newTutorial, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Tutorial>> listAll(@RequestParam(required = false) String titulo) {
        List<Tutorial> list;

        if (titulo == null) {
            list = repo.findAll();
        } else {
            list = repo.findByTitleContaining(titulo);
        }

        if (list.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tutorial> getTutorialById(@PathVariable("id") String id) {
        Optional<Tutorial> tutorialData = repo.findById(id);

        if (tutorialData.isPresent()) {
            return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") String id) {
        try {
            repo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tutorial> updateTutorial(@PathVariable("id") String id, @RequestBody Tutorial tutorial) {
        Optional<Tutorial> tutorialData = repo.findById(id);

        if (tutorialData.isPresent()) {
            Tutorial newTutorial = tutorialData.get();
            newTutorial.setTitle(tutorial.getTitle());
            newTutorial.setDescription(tutorial.getDescription());
            newTutorial.setPublished(tutorial.isPublished());
            return new ResponseEntity<>(repo.save(newTutorial), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
