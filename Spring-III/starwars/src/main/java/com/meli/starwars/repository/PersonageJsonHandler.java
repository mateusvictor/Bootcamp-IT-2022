package com.meli.starwars.repository;

import com.meli.starwars.model.Personage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonageJsonHandler {
    public static List<Personage> getPersonages(String filename){
        List<Personage> personages = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();

        try {
            FileReader reader = new FileReader(filename);
            Object obj = jsonParser.parse(reader);
            JSONArray personageList = (JSONArray) obj;

            for (Object personageJson : personageList){
                personages.add(parsePersonageObject((JSONObject) personageJson));
            }

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return personages;
    }

    public static Personage parsePersonageObject(JSONObject personage){
        Personage personageObj = new Personage();
        personageObj.setName((String) personage.get("name"));

        personageObj.setHeight(String.valueOf(personage.get("height")));
        personageObj.setMass(String.valueOf(personage.get("mass")));

        personageObj.setHairColor((String) personage.get("hair_color"));
        personageObj.setSkinColor((String) personage.get("skin_color"));
        personageObj.setEyeColor((String) personage.get("eye_color"));
        personageObj.setBirthYear((String) personage.get("birth_year"));
        personageObj.setGender((String) personage.get("gender"));
        personageObj.setHomeWorld((String) personage.get("homeworld"));
        personageObj.setSpecies((String) personage.get("species"));

        return personageObj;
    }
}
