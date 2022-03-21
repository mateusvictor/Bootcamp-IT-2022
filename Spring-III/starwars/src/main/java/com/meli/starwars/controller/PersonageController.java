package com.meli.starwars.controller;

import com.meli.starwars.dto.PersonageDTO;
import com.meli.starwars.model.Personage;
import com.meli.starwars.service.PersonageService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonageController {
    private final PersonageService personageService;

    public PersonageController(PersonageService personageService) {
        this.personageService = personageService;
    }

    @GetMapping("/personages/{word}/")
    public List<PersonageDTO> getPersonages(@PathVariable String word){
        return PersonageDTO.convert(personageService.getPersonagesByWord(word));
    }

    @GetMapping("/personages/")
    public List<PersonageDTO> getPersonages(){
        return PersonageDTO.convert(personageService.getPersonages());
    }
}
