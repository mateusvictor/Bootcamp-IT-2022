package br.com.meli.personage.services;


import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;

public class PersonAgeService {
    private static PersonAgeService personAgeService = new PersonAgeService();
    
    public PersonAgeService(){

    }

    public static PersonAgeService getInstance() {
        return personAgeService;
    }

    public String calculateAge(Integer day, Integer month, Integer year) {
        LocalDate birthDate;
        try {
            birthDate = LocalDate.of(year, month, day);
        } catch (DateTimeException e) {
            return "Data inválida!";
        }
        LocalDate dateNow = LocalDate.now();
        Period age = Period.between(birthDate, dateNow);

        return String.valueOf(age.getYears());

    }
}
