package supermarket.utils;

import java.math.BigDecimal;
import java.util.Scanner;

public class Util {
    static Scanner console = new Scanner(System.in);

    public static String input(String text) {
        System.out.print(text);
        return console.next();
    }

    public static Integer inputInt(String text){
        return Integer.parseInt(input(text));
    }

    public static BigDecimal inputFloat(String text){
        BigDecimal temp = new BigDecimal(input(text));
        return temp;
    }
}
