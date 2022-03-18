package br.com.meli.personage.services;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;

public class PersonAgeService {
    public static String calculateAge(Integer day, Integer month, Integer year){
        LocalDate birthDate;
        try{
            birthDate = LocalDate.of(year, month, day);
        } catch (DateTimeException e) {
            return "Data inválida!";
        }
        LocalDate dateNow = LocalDate.now();
        Period age = Period.between(birthDate, dateNow);

        return String.valueOf(age.getYears());

    }
}
