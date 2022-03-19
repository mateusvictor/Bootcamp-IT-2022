package br.com.meli.personage.controllers;

import br.com.meli.personage.services.PersonAgeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonAgeController {
    private final PersonAgeService service = PersonAgeService.getInstance();

    @GetMapping("/{day}/{month}/{year}")
    public String getAge(@PathVariable Integer day,
                         @PathVariable Integer month,
                         @PathVariable Integer year) {
        return service.calculateAge(day, month, year);
    }

}
