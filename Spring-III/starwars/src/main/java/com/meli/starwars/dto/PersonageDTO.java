package com.meli.starwars.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.meli.starwars.model.Personage;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PersonageDTO {
    private String name;
    private String height;
    private String mass;
    private String gender;
    private String homeWorld;
    private String species;

    public static PersonageDTO convert(Personage personage){
        return new PersonageDTO(personage.getName(), personage.getHeight(), personage.getMass(),
                personage.getGender(), personage.getHomeWorld(), personage.getSpecies());
    }

    public static List<PersonageDTO> convert(List<Personage> personages){
        return personages.stream().map(personage -> PersonageDTO.convert(personage)).collect(Collectors.toList());
    }
}
