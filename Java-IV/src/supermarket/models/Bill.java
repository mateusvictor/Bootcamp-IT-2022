package supermarket.models;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Bill {
    private Integer id;
    private Client client;
    private ArrayList<Product> products;

    public Bill(Client client, ArrayList products) {
        this.client = client;
        this.products = products;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ArrayList getItems() {
        return products;
    }

    public void setItems(ArrayList items) {
        this.products = items;
    }

    public BigDecimal getTotalPrice() {
        double totalPrice = products.stream()
                .map(x -> x.getUnitPrice().multiply(BigDecimal.valueOf(x.getQuantity())))
                .mapToDouble(x -> x.doubleValue())
                .sum();
        BigDecimal total = BigDecimal.valueOf(totalPrice);
        total.setScale(2, RoundingMode.HALF_EVEN);
        return total;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", client=" + client +
                ", totalPrice= R$" + getTotalPrice() +
                '}';
    }
}
