package br.meli.tutorials.service;

import br.meli.tutorials.entity.Tutorial;
import br.meli.tutorials.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TutorialService {
    @Autowired
    private TutorialRepository repository;

    @Transactional(readOnly = true)
    public List<Tutorial> findAll(){
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Tutorial findById(Long id){
        return repository.findById(id).orElse(new Tutorial());
    }

//    @Transactional(readOnly = true)
//    public List<Tutorial> findAllPublished(){
//        return this.findAll().stream()
//                .filter(Tutorial::getPublished)
//                .collect(Collectors.toList());
//    }

    @Transactional(readOnly = true)
    public List<Tutorial> findByPublished(Boolean published){
        return repository.findByPublished(published);
    }

    @Transactional(readOnly = true)
    public List<Tutorial> findByTitle(String title){
        return this.findAll().stream()
                .filter(tutorial -> tutorial.getTitle().contains(title))
                .collect(Collectors.toList());
    }

    @Transactional
    public Tutorial create(Tutorial tutorial){
        return repository.save(tutorial);
    }

    @Transactional
    public Tutorial updateById(Long id, Tutorial tutorialUpdated){
        Tutorial tutorial = this.findById(id);

        tutorial.setTitle(tutorialUpdated.getTitle());
        tutorial.setDescription(tutorialUpdated.getDescription());
        tutorial.setPublished(tutorialUpdated.getPublished());

        return repository.save(tutorial);
    }

    @Transactional
    public void deleteById(Long id){
        repository.deleteById(id);
    }

    @Transactional
    public void deleteAll(){
        repository.deleteAll();
    }
}
