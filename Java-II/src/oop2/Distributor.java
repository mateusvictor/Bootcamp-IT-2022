package oop2;

import java.util.ArrayList;

public class Distributor {
    public static void main(String[] args) {
        ArrayList<Perishable> perishables = new ArrayList<Perishable>();
        ArrayList<NoPerishable> noPerishables = new ArrayList<NoPerishable>();

        perishables.add(new Perishable("Abacaxi", 5.30, 3));
        perishables.add(new Perishable("Cenoura", 2.30, 1));
        perishables.add(new Perishable("Peito de Frango", 13.30, 2));
        perishables.add(new Perishable("Sardinha", 11.30, 2));
        perishables.add(new Perishable("Ervilha", 11.30, 2));

        noPerishables.add(new NoPerishable("Bolacha Trakinas", 2.10, "Bolacha"));
        noPerishables.add(new NoPerishable("Macarrao ", 4.10, "Massa"));
        noPerishables.add(new NoPerishable("Refrigerante", 5.10, "Bebida"));
        noPerishables.add(new NoPerishable("Papel Higienico", 5.10, "Higiene"));
        noPerishables.add(new NoPerishable("Camiseta preta", 30.10, "Roupa"));

        perishablesTotalPrice(perishables);
        noPerishablesTotalPrice(noPerishables);
    }

    static void perishablesTotalPrice(ArrayList<Perishable> products) {
        double totalPrice = 0.0;
        for (Perishable product : products)
            totalPrice += product.getPrice();
        System.out.println("Preco total dos produtos pereciveis: " + totalPrice);

    }

    static void noPerishablesTotalPrice(ArrayList<NoPerishable> products) {
        double totalPrice = 0.0;
        for (NoPerishable product : products)
            totalPrice += product.getPrice();
        System.out.println("Preco total dos produtos nao-pereciveis: " + totalPrice);
    }
}
