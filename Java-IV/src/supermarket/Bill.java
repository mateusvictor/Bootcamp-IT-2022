package supermarket;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Bill {
    private Client client;
    private ArrayList<Item> items;

    public Bill(Client client, ArrayList items) {
        this.client = client;
        this.items = items;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ArrayList getItems() {
        return items;
    }

    public void setItems(ArrayList items) {
        this.items = items;
    }

    public BigDecimal getTotalPrice() {
        double totalPrice = items.stream()
                .map(x -> x.getUnitPrice())
                .mapToDouble(x -> x.doubleValue())
                .sum();
        BigDecimal total = BigDecimal.valueOf(totalPrice);
        total.setScale(2, RoundingMode.HALF_EVEN);
        return total;
    }

}
