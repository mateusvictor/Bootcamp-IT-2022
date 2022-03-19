package br.com.meli.usingdtos.services;

import br.com.meli.usingdtos.dtos.PersonDTO;
import br.com.meli.usingdtos.models.Sport;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SportManager implements CRUD<Sport>{
    private static SportManager sportManager = new SportManager();
    private static HashMap<String, Sport> sportList = new HashMap<>();

    public static SportManager getInstance() {
        return sportManager;
    }

    public SportManager(){}

    @Override
    public Sport create(Sport sport) {
        sportList.put(sport.getName(), sport);
        return sport;
    }

    public List<Sport> readAll() {
        List<Sport> sports = new ArrayList<>();
        for (String key : sportList.keySet())
            sports.add(sportList.get(key));
        return sports;
    }

    public Sport findByName(String name){
        if (sportList.containsKey(name.toLowerCase()))
            return sportList.get(name.toLowerCase());
        return null;
    }
}
