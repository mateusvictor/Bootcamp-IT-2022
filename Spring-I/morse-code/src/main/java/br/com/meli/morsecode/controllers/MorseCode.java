package br.com.meli.morsecode.controllers;

import java.util.HashMap;

public class MorseCode {
    static String[] alphaMorseCode = {
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
            "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."
    };
    static String[] numbersMorseCode = {
            "-----", ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----."
    };
    static HashMap<Character, String> symbols;

    static {
        symbols = new HashMap<>();
        symbols.put('.', ".-.-.-");
        symbols.put(',', "--..--");
        symbols.put('?', "..--..");
        symbols.put('!', "-.-.--");
    }

    public static String toMorseCode(String text){
        text = text.toLowerCase();
        String result = "";
        for (int i=0; i<text.length(); i++){
            result += charToMorseCode(text.charAt(i)) + ' ';
        }
        return result;
    }

    public static String charToMorseCode(char letter){
        int charPosition ; // ASCII code
        String charMorseCode;

        if (Character.isDigit(letter)) {
            charPosition = letter - 48;
            charMorseCode = numbersMorseCode[charPosition];
        }
        else if (Character.isLetter(letter)){
            charPosition = letter - 97;
            charMorseCode = alphaMorseCode[charPosition];
        }
        else if (Character.isSpaceChar(letter)){
            charMorseCode = " ";
        }
        else {
            charMorseCode = symbols.get(letter);
        }
        return charMorseCode;
    }
}
