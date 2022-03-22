package supermarket.repositories;

import supermarket.models.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProductManager implements CRUD<Product> {
    private static ProductManager productManager = new ProductManager();
    private HashMap<Integer, Product> products = new HashMap<Integer, Product>();
    private Integer lastId = 0;


    public static ProductManager getInstance() {
        return productManager;
    }

    public ProductManager() {
    }

    @Override
    public Product create(Product product) {
        product.setCode(lastId+1);
        products.put(lastId+1, product);
        lastId += 1;
        return product;
    }

    @Override
    public List<Product> readAll() {
        ArrayList<Product> productsList = new ArrayList<Product>();
        for (Integer key : products.keySet())
            productsList.add(products.get(key));
        return productsList;
    }

    @Override
    public Product read(Integer id) {
        if (products.containsKey(id))
            return products.get(id);
        return null;
    }

    @Override
    public void delete(Integer id) {
        if (products.containsKey(id)) {
            products.remove(id);
            System.out.println("Produto Codigo=" + id + " deletado.");
        }
        else
            System.out.println("Nao foi encontrado produto com o codigo especificado.");
    }
}
