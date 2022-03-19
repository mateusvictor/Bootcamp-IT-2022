package br.com.meli.usingdtos.controllers;

import br.com.meli.usingdtos.models.Sport;
import br.com.meli.usingdtos.services.SportManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SportController {
    private final SportManager sportManager = SportManager.getInstance();

    @GetMapping("/findSports/")
    public ResponseEntity<List<Sport>> getSports() {
        return new ResponseEntity<>(sportManager.readAll(), HttpStatus.OK);
    }

    @GetMapping("/findSports/{name}/")
    public ResponseEntity<Sport> findSportByName(@PathVariable String name){
        return new ResponseEntity<>(sportManager.findByName(name), HttpStatus.OK);
    }
}
