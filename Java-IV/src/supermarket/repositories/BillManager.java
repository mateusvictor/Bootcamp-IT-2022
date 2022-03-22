package supermarket.repositories;

import supermarket.models.Bill;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BillManager implements CRUD<Bill> {
    private static BillManager productManager = new BillManager();
    private HashMap<Integer, Bill> products = new HashMap<Integer, Bill>();
    private Integer lastId = 0;


    public static BillManager getInstance() {
        return productManager;
    }

    public BillManager() {
    }

    @Override
    public Bill create(Bill product) {
        product.setId(lastId+1);
        products.put(lastId+1, product);
        lastId += 1;
        return product;
    }

    @Override
    public List<Bill> readAll() {
        ArrayList<Bill> productsList = new ArrayList<Bill>();
        for (Integer key : products.keySet())
            productsList.add(products.get(key));
        return productsList;
    }

    @Override
    public Bill read(Integer id) {
        if (products.containsKey(id))
            return products.get(id);
        return null;
    }

    @Override
    public void delete(Integer id) {
        if (products.containsKey(id)) {
            products.remove(id);
            System.out.println("Fatura ID=" + id + " deletado.");
        }
        else
            System.out.println("Nao foi encontrada fatura com o ID especificado.");
    }
}
