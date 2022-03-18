package br.com.meli.morsecode.controllers;

import java.util.Arrays;
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

    public static String toAlphaNum(String text){
        String result = "";
        String[] words = text.split("   ");
        String[] letters;

        for (String word : words){
            letters = word.split(" ");
            for (String letter : letters){
                result += morseCodeToChar(letter);
            }
            result += " ";
        }
        return result;
    }

    public static String toMorseCode(String text){
        text = text.toLowerCase();
        String result = "";
        for (int i=0; i<text.length(); i++){
            result += charToMorseCode(text.charAt(i)) + ' ';
        }
        return result;
    }

    public static char morseCodeToChar(String morseLetter){
        int index, asciiCode;

        if (morseIsNumber(morseLetter)){
            index = Arrays.asList(numbersMorseCode).indexOf(morseLetter);
            asciiCode = index + 48;
        }
        else if (morseIsLetter(morseLetter)){
            index = Arrays.asList(alphaMorseCode).indexOf(morseLetter);
            asciiCode = index + 97;
        }
        else {
            asciiCode = 0; // Null
        }
        return (char) asciiCode;
    }

    public static boolean morseIsLetter(String morseChar){
        return Arrays.asList(alphaMorseCode).contains(morseChar);
    }

    public static boolean morseIsNumber(String morseChar){
        return Arrays.asList(numbersMorseCode).contains(morseChar);
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
