package br.com.meli.usingdtos.dtos;

import br.com.meli.usingdtos.models.Person;
import br.com.meli.usingdtos.models.Sport;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PersonDTO {
    private String firstName;
    private String lastName;
    private SportDTO sport;

    public PersonDTO(String firstName, String lastName, Sport sport) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sport = SportDTO.convert(sport);
    }

    public static List<PersonDTO> convert(List<Person> people){
        return people.stream()
                .map(p -> new PersonDTO(p.getFirstName(), p.getLastName(), p.getSport()))
                .collect(Collectors.toList());
    }

}
