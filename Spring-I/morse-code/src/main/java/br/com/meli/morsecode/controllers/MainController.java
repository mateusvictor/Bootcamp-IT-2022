package br.com.meli.morsecode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @PostMapping("/to-morse-code/")
    @ResponseBody
    public String convertToMorseCode(@RequestBody String text){
        return MorseCode.toMorseCode(text);
    }

    @PostMapping("/to-alpha-num/")
    @ResponseBody
    public String convertToAlphaNum(@RequestBody String text){
        return MorseCode.toAlphaNum(text);
    }
}
