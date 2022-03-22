package supermarket.views;

import supermarket.utils.Util;
import supermarket.models.Client;
import supermarket.repositories.ClientManager;


public class ClientService extends Util {
    private static ClientManager clientManager = ClientManager.getInstance();
    private static ClientService clientService = new ClientService();

    public static ClientService getInstance() {
        return clientService;
    }

    public ClientService(){}

    public static void execute(){

        int option = 0, clientId;
        boolean running = true;

        while (running) {
            do {
                System.out.println("------------------------------ CLIENTES ------------------------------");
                System.out.println("1. Criar cliente");
                System.out.println("2. Exibir todos clientes");
                System.out.println("3. Exibir cliente atraves do ID");
                System.out.println("4. Deletar cliente atraves do ID");
                System.out.println("0. Voltar");

                option = inputInt("Opcao: ");
            } while (!(option >= 0 && option <= 4));

            switch (option){
                case 1:
                    Client newClient = createClientFromConsole();
                    System.out.println(newClient);
                    break;
                case 2:
                    clientManager.readAll().forEach(System.out::println);
                    break;
                case 3:
                    clientId = inputInt("ID do cliente: ");
                    System.out.println(clientManager.read(clientId));
                    break;
                case 4:
                    clientId = inputInt("ID do cliente: ");
                    clientManager.delete(clientId);
                    break;
                default:
                    running = false;
                    break;
            }
        }
    }

    private static Client createClientFromConsole() {
        String firstName = input("Primeiro nome: ");
        String lastName = input("Sobrenome: ");
        Client newClient = new Client(
                firstName,
                lastName
        );
        return clientManager.create(newClient);
    }

    public static void createDefaultClients(){
        clientManager.create(new Client("Mateus", "Silva"));
        clientManager.create(new Client("Jorge", "Santos"));
        clientManager.create(new Client("Maria", "Rocha"));
    }

}
