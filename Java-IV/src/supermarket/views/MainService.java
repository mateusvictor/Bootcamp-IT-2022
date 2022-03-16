package supermarket.views;

import supermarket.utils.Util;

public class MainService extends Util  {
    private static MainService mainService = new MainService();

    public static MainService getInstance() {
        return mainService;
    }

    public MainService(){ }

    public void execute() {
        int option = 0;
        boolean running = true;

        while (running) {
            do {
                System.out.println("------------------------------ Mercadinho ------------------------------");
                System.out.println("1. Clientes");
                System.out.println("2. Produtos");
                System.out.println("3. Faturas");
                System.out.println("0. Sair");

                option = inputInt("Opcao: ");
            } while (!(option >= 0 && option <= 3));

            switch (option){
                case 1:
                    ClientService clientService = ClientService.getInstance();
                    clientService.execute();
                    break;
                case 2:
                    ProductService productService = ProductService.getInstance();
                    productService.execute();
                    break;
                case 3:
                    BillService billService = BillService.getInstance();
                    billService.execute();
                    break;
                case 0:
                    running = false;
                    break;
            }
        }
    }
}
