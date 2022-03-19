package br.com.meli.usingdtos.controllers;

import br.com.meli.usingdtos.dtos.PersonDTO;
import br.com.meli.usingdtos.services.PersonManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {
    private final PersonManager personManager = PersonManager.getInstance();

    @GetMapping("/findSportsPeople/")
    public ResponseEntity<List<PersonDTO>> findPeople(){
        return new ResponseEntity<>(personManager.readAll(), HttpStatus.OK);
    }
}
