package supermarket.views;

import supermarket.utils.Util;
import supermarket.models.Product;
import supermarket.models.ProductManager;

import java.math.BigDecimal;

public class ProductService extends Util {
    private static ProductManager productManager = ProductManager.getInstance();
    private static ProductService productService = new ProductService();



    public static ProductService getInstance() {
        return productService;
    }

    public ProductService(){
    }

    public static void execute(){

        int option = 0, productId;
        boolean running = true;

        while (running) {
            do {
                System.out.println("------------------------------ Produto ------------------------------");
                System.out.println("1. Criar produto");
                System.out.println("2. Exibir todos produtos");
                System.out.println("3. Exibir produto atraves do ID");
                System.out.println("4. Deletar produto atraves do ID");
                System.out.println("0. Voltar");

                option = inputInt("Opcao: ");
            } while (!(option >= 0 && option <= 4));

            switch (option){
                case 1:
                    Product newProduct = createProductFromConsole();
                    System.out.println(newProduct);
                    break;
                case 2:
                    productManager.readAll().forEach(System.out::println);
                    break;
                case 3:
                    productId = inputInt("ID do producte: ");
                    System.out.println(productManager.read(productId));
                    break;
                case 4:
                    productId = inputInt("ID do producte: ");
                    productManager.delete(productId);
                    break;
                default:
                    running = false;
                    break;
            }
        }
    }

    private static Product createProductFromConsole() {
        String name = input("Nome: ");
        Integer quantity = inputInt("Quantidade");
        BigDecimal unitPrice = inputFloat("Preco unitario: ");
        Product newProduct = new Product(
                name,
                quantity,
                unitPrice
        );
        return productManager.create(newProduct);
    }

    public static void createDefaultProducts(){
        productManager.create(new Product("Refrigerante", 2, BigDecimal.valueOf(10)));
        productManager.create(new Product("Travesseiro", 2, BigDecimal.valueOf(19)));
        productManager.create(new Product("Feijao", 2, BigDecimal.valueOf(30)));
    }

}
