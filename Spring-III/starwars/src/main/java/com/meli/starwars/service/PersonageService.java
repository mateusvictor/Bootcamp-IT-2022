package com.meli.starwars.service;

import com.meli.starwars.model.Personage;
import com.meli.starwars.repository.PersonageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonageService {
    private final PersonageRepository personageRepository;

    public PersonageService(PersonageRepository personageRepository) {
        this.personageRepository = personageRepository;
    }

    public List<Personage> getPersonages(){
        return personageRepository.findAll();
    }

    public List<Personage> getPersonagesByWord(String word) {
        return personageRepository.findByWord(word);
    }
}
