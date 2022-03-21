package com.meli.starwars.repository;


import com.meli.starwars.model.Personage;
import org.springframework.expression.spel.ast.Literal;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;


@Repository
public class PersonageRepository {
    private List<Personage> personageList;

    public PersonageRepository(){
        this.personageList = PersonageJsonHandler.getPersonages("starwars.json");
    }

    public List<Personage> findAll(){
        return personageList;
    }

    public List<Personage> findByWord(String word){
        return personageList.stream()
                .filter(personage -> personage.getName().toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }
}
