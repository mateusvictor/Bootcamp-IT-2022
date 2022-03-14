package interfaces.exercise1;

import interfaces.exercise1.clients.Collector;
import interfaces.exercise1.clients.Executive;
import interfaces.exercise1.clients.Basic;

import java.math.BigDecimal;

public class Bank {
    public static void main(String[] args) {
        System.out.println("Banco do Mateus!");

        Executive executive1 = new Executive("130132", "Mateus", BigDecimal.valueOf(10000.00));
        executive1.performDeposit("132190", BigDecimal.valueOf(123.00));
        executive1.performTransference("132190", BigDecimal.valueOf(13.00));

        System.out.println();

        Basic basic1 = new Basic("132190", "Jorge", BigDecimal.valueOf(132.23));
        basic1.performBalanceConsult();
        basic1.performCashWithdraw(BigDecimal.valueOf(132.0));
        basic1.performServicePayment("18123812");

        System.out.println();

        Collector collector1 = new Collector("381231", "Giuliana", BigDecimal.valueOf(8312.23));
        collector1.performBalanceConsult();
        collector1.performCashWithdraw(BigDecimal.valueOf(8311.12));
    }
}
