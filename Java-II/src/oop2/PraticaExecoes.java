package oop2;

public class PraticaExecoes {
    static int a = 0;
    static int b = 300;

    public static void main(String[] args) {
        try {
            int div = b / a;
        } catch (ArithmeticException e) {
//            System.out.println("Ocorreu um erro");
            throw new IllegalArgumentException("Nao pode ser divido por 0");
        }
    }
}
