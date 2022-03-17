package br.com.meli.romannumbers.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @GetMapping("/decimal-to-roman/{decimalNumber}")
    @ResponseBody
    public String toRoman(@PathVariable Integer decimalNumber){
        String response = "{\"decimalNumber\": " + decimalNumber +
                ", \"romanNumber\": " + "\"" + RomanNumber.toRoman(decimalNumber) + "\"}";
        return response;
    }
}
