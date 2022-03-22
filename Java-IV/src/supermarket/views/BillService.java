package supermarket.views;

import supermarket.repositories.BillManager;
import supermarket.repositories.ClientManager;
import supermarket.repositories.ProductManager;
import supermarket.utils.Util;
import supermarket.models.*;

import java.math.BigDecimal;
import java.util.ArrayList;

public class BillService extends Util {
    private static BillManager billManager = BillManager.getInstance();
    private static BillService billService = new BillService();
    private static ClientManager clientManager = ClientManager.getInstance();
    private static ProductManager productManager = ProductManager.getInstance();

    public static BillService getInstance() {
        return billService;
    }

    public BillService(){
    }

    public static void execute(){
        boolean running = true;
        int option = 0, billId;

        while (running) {
            do {
                System.out.println("------------------------------ FATURA ------------------------------");
                System.out.println("1. Criar fatura");
                System.out.println("2. Exibir todas faturas");
                System.out.println("3. Exibir fatura atraves do ID");
                System.out.println("4. Deletar fatura atraves do ID");
                System.out.println("0. Voltar");

                option = inputInt("Opcao: ");
            } while (!(option >= 0 && option <= 4));

            switch (option){
                case 1:
                    Bill newBill = createBillFromConsole();
                    if (newBill == null) {
                        System.out.println("Nao foi encontrado cliente com o ID especificado! Crie um novo cliente.");
                        break;
                    }
                    System.out.println(newBill);
                    break;
                case 2:
                    billManager.readAll().forEach(System.out::println);
                    break;
                case 3:
                    billId = inputInt("ID da fatura ");
                    System.out.println(billManager.read(billId));
                    break;
                case 4:
                    billId = inputInt("ID do fatura: ");
                    billManager.delete(billId);
                    break;
                default:
                    running = false;
                    break;
            }
        }
    }

    private static Bill createBillFromConsole() {
        Integer clientId = inputInt("ID do cliente: ");
        Client client = clientManager.read(clientId);
        if (client == null)
            return null;

        Bill newBill = new Bill(
                client,
                readProductsFromConsole()
        );
        return billManager.create(newBill);
    }

    private static ArrayList<Product> readProductsFromConsole(){
        String name;
        Integer quantity;
        BigDecimal unitPrice;
        Integer productsQuantity = 1;
        Product newProduct;
        ArrayList<Product> products = new ArrayList<>();

        while (true){
            System.out.println("--------------------ITEM " + productsQuantity + "--------------------");
            System.out.println("DIGITE 0 EM QUALQUER CAMPO PARA FINALIZAR A COMPRA\n");
            name = input("Nome do produto: ");
            unitPrice = inputFloat("Valor unitario: ");
            quantity = inputInt("Quantidade: ");

            if (name.equals("0") || quantity == 0 || unitPrice.equals(BigDecimal.valueOf(0)))
                break;

            newProduct = productManager.create(new Product(name, quantity, unitPrice));
            products.add(newProduct);
            productsQuantity++;
        }
        return products;
    }
}
