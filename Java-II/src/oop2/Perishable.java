package oop2;

public class Perishable extends Product {
    private int remainingDays;

    public Perishable(String name, double price, int remainingDays) {
        super(name, price);
        this.remainingDays = remainingDays;
    }

    public int getRemainingDays() {
        return remainingDays;
    }

    public void setRemainingDays(int remainingDays) {
        this.remainingDays = remainingDays;
    }

    @Override
    public double calculate(int productsQuantity) {
        double finalPrice = super.calculate(productsQuantity);
        switch (remainingDays){
            case 1:
                finalPrice /= 4;
                break;
            case 2:
                finalPrice /= 3;
                break;
            case 3:
                finalPrice /= 2;
                break;
        }
        return finalPrice;
    }

    @Override
    public String toString() {
        return "Perishable{" +
                "remainingDays=" + remainingDays +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
