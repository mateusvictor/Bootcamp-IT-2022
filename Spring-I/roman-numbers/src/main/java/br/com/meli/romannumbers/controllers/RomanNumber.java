package br.com.meli.romannumbers.controllers;

public class RomanNumber {
    public static String toRoman(int decimalNumber){
        String[] roman = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] dec = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        int repeat = 0;
        String result = "";
        int i = 12;
        while (decimalNumber != 0){
            repeat = decimalNumber / dec[i];
            decimalNumber %= dec[i];
            result += roman[i].repeat(repeat);
            i--;
        }
        return result;
    }
}
