package br.com.meli.usingdtos.services;

import br.com.meli.usingdtos.dtos.PersonDTO;
import br.com.meli.usingdtos.models.Person;
import br.com.meli.usingdtos.models.Sport;

import java.util.ArrayList;
import java.util.List;

public class PersonManager implements CRUD<Person>{
    private static final PersonManager personManager = new PersonManager();
    private static final SportManager sportManager = SportManager.getInstance();
    private static List<Person> personList = new ArrayList<Person>();

    static {
        personList.add(new Person("Mateus", "Silva", 18, sportManager.create(new Sport("volei", "Amador"))));
        personList.add(new Person("Joice", "Santana", 23, sportManager.create(new Sport("futebol", "Profissional"))));
    }
    public static PersonManager getInstance() {
        return personManager;
    }

    public PersonManager(){}

    @Override
    public Person create(Person person) {
        personList.add(person);
        return person;
    }

    public List<PersonDTO> readAll() {
        return PersonDTO.convert(personList);
    }
}
