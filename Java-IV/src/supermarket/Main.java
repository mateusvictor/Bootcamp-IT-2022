package supermarket;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static Scanner console = new Scanner(System.in);
    static final int MENU_OPTIONS = 5;
    static int lastClientId = 3;
    public static HashMap<Integer, Client> clients = new HashMap<Integer, Client>();


    static String input(String text) {
        System.out.print(text);
        return console.next();
    }
    static void printMainMenu() {
        System.out.println("1. Criar cliente");
        System.out.println("2. Exibir todos clientes");
        System.out.println("3. Exibir cliente atraves do ID");
        System.out.println("4. Deletar cliente atraves do ID");
        System.out.println("5. Exit");
    }

    public static void main(String[] args) {


        createDefaultClients();
//        displayClients();
//        removeClientById(1);
//        System.out.println("---------------");
//        displayClients();
//        System.out.println("---------------");
//        displayUserById(1);
        int option = 0;
        boolean running = true;
        Integer clientId = 0;

        System.out.println("------------------2------------------------------");
        while (running) {
            do {
                printMainMenu();
                option = Integer.parseInt(input("Opcao: "));
            } while (!(option > 0 && option <= MENU_OPTIONS));

            switch (option){
                case 1:
                    Client newClient = createClientFromConsole();
                    clients.put(newClient.getId(), newClient);
                    break;
                case 2:
                    displayClients();
                    break;
                case 3:
                    clientId = Integer.parseInt(input("ID do cliente: "));
                    displayUserById(clientId);
                    break;
                case 4:
                    clientId = Integer.parseInt(input("ID do cliente: "));
                    removeClientById(clientId);
                    break;
                default:
                    running = false;
                    break;
            }

            System.out.println("------------------------------------------------");
        }


    }

    public static void displayUserById(Integer id){
        if (clients.containsKey(id))
            System.out.println(clients.get(id));
        else
            System.out.println("Nao foi encontrado cliente com o ID especificado.");
    }

    public static void removeClientById(Integer id) {
        if (clients.containsKey(id))
            clients.remove(id);
        else
            System.out.println("Nao foi encontrado cliente com o ID especificado.");
    };

    public static void displayClients(){
        for (Integer id : clients.keySet())
            System.out.println(clients.get(id));
    }

    public static Client createClientFromConsole() {
        String firstName = input("Primeiro nome: ");
        String lastName = input("Sobrenome: ");
        Client newClient = new Client(
                lastClientId + 1,
                firstName,
                lastName
        );

        lastClientId = newClient.getId();
        return newClient;
    }
    public static void createDefaultClients(){
        clients.put(1, new Client(1, "Mateus", "Silva"));
        clients.put(2, new Client(2, "Jorge", "Santos"));
        clients.put(3, new Client(3, "Maria", "Rocha"));
    }
}
