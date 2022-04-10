package br.meli.tutorials.controller;

import br.meli.tutorials.entity.Tutorial;
import br.meli.tutorials.service.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/tutorials")
public class TutorialController {
    @Autowired
    private TutorialService service;

    @GetMapping("")
    public ResponseEntity<List<Tutorial>> getTutorials(@RequestParam(required = false) String title) {
        if (title == null || title.isEmpty())
            return ResponseEntity.ok(service.findAll());
        return ResponseEntity.ok(service.findByTitle(title));
    }

    @GetMapping("/published")
    public ResponseEntity<List<Tutorial>> getPublishedTutorials(){
        return ResponseEntity.ok(service.findAllPublished());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tutorial> getTutorialById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping("")
    public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial){
        return ResponseEntity.ok(service.create(tutorial));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tutorial> updateTutorial(@PathVariable Long id, @RequestBody Tutorial tutorial){
        return ResponseEntity.ok(service.updateById(id, tutorial));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Tutorial> deleteTutorialById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("")
    public ResponseEntity<Tutorial> deleteAllTutorials(){
        service.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
