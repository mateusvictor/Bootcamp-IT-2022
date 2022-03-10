package jungle.run;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class JungleRun {
    static int lastUserId = 0;
    static Scanner console = new Scanner(System.in);
    static HashMap<String, ArrayList<User>> usersByCircuit = new HashMap<String, ArrayList<User>>();
    static HashMap<Integer, User> userById = new HashMap<Integer, User>();

    public static void main(String[] args) {
        int mainMenuOption = 0;
        boolean running = true;

        usersByCircuit.put("pequeno", new ArrayList<User>());
        usersByCircuit.put("medio", new ArrayList<User>());
        usersByCircuit.put("avancado", new ArrayList<User>());

        while (running) {
            do {
                printMainMenu();
                mainMenuOption = Integer.parseInt(input("Opcao: "));
            } while (validMainMenuOption(mainMenuOption));

            switch (mainMenuOption) {
                case 1:
                    User newUser = createUser();
                    if (validUser(newUser)) {
                        usersByCircuit.get(newUser.circuitType).add(newUser);
                        userById.put(newUser.id, newUser);

                        System.out.println("ID: " + newUser.id);
                        System.out.println("Valor a pagar: " + priceToPay(newUser));
                    } else {
                        System.out.println("Participante nao pode se inscrever nesta modalidade!");
                    }
                    break;

                case 2:
                    printUsersByCircuit("pequeno");
                    printUsersByCircuit("medio");
                    printUsersByCircuit("avancado");
                    break;

                case 3:
                    int userId = Integer.parseInt(input("ID do participante: "));
                    if (userById.containsKey(userId)) {
                        User user = userById.get(userId);
                        String userCircuit = user.circuitType;

                        removeUserFromCircuit(user);
                        System.out.println("Participante removido da categoria: " + userCircuit);
                    }
                    System.out.println("");
                    break;

                case 4:
                    running = false;
                    break;
            }
            System.out.println();
        }

    }

    static User createUser() {
        Scanner console = new Scanner(System.in);
        String firstName = input("Primeiro nome: ");
        String lastName = input("Sobrenome: ");
        String rg = input("RG: ");
        String cellphone = input("Telefone: ");
        String emergencyNumber = input("Telefone de emergencia: ");
        String bloodGroup = input("Tipo sanguineo: ");
        String circuitType = input( "Tipo do circuito: ");
        int age = Integer.parseInt(input("Idade: "));
        int id = lastUserId + 1;
        lastUserId++;

        User user = new User(
                firstName,
                lastName,
                rg,
                cellphone,
                emergencyNumber,
                bloodGroup,
                age,
                id,
                circuitType
        );
        return user;
    }

    static void printUsersByCircuit(String circuitType) {
        System.out.println();
        ArrayList<User> userList = usersByCircuit.get(circuitType);
        System.out.println("CATEGORIA: circuito " + circuitType);

        if (userList.size() == 0) {
            System.out.println("Sem participantes para essa categoria!");
            return;
        }

        for (User user : userList) {
            user.printData();
        }
        System.out.println();
    }

    static void removeUserFromCircuit(User user) {
        ArrayList<User> userslist = usersByCircuit.get(user.circuitType);
        for (int i=0; i<userslist.size(); i++){
            if (userslist.get(i).id == user.id){
                userslist.remove(i);
                return;
            }
        }
    }

    static String input(String text) {
        System.out.print(text);
        return console.next();
    }

    static void printMainMenu() {
        System.out.println("------------------------ Corrida na Selva ------------------------");
        System.out.println("1) Inscrever novo participante;");
        System.out.println("2) Exibir participantes;");
        System.out.println("3) Cancelar registro de um participante;");
        System.out.println("4) Sair");

    }

    static boolean validMainMenuOption(int mainMenuOption) {
        return !(mainMenuOption > 0 && mainMenuOption < 5);
    }

    static boolean validUser(User user) {
        if (user.circuitType.equals("avancado")){
            return user.age >= 18;
        }
        return true;
    }

    static double priceToPay(User user){
        String circuitType = user.circuitType;
        switch (circuitType){
            case "pequeno":
                return ((user.age < 18) ? 1300.00 : 1500.00);
            case "medio":
                return ((user.age < 18) ? 2000.00 : 2300.00);
            case "avancado":
                return 2800.00;
        }
        return 0;
    }
}