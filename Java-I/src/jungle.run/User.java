package jungle.run;

public class User{
    String rg, firstName, lastName, cellphone, emergencyNumber, bloodGroup, circuitType;
    int age, id;

    public User(String firstName, String lastName,String rg, String cellphone, String emergencyNumber, String bloodGroup,
                int age, int id, String circuitType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.rg = rg;
        this.cellphone = cellphone;
        this.emergencyNumber = emergencyNumber;
        this.bloodGroup = bloodGroup;
        this.age = age;
        this.id = id;
        this.circuitType = circuitType;
    }

    public void printData() {
        System.out.println("ID: " + this.id);
        System.out.println("Nome: " + this.firstName);
        System.out.println("RG: " + this.rg);
        System.out.println("Sobrenome: " + this.lastName);
        System.out.println("Telefone: " + this.cellphone);
        System.out.println("Numero de emergencia" + this.emergencyNumber);
        System.out.println("Grupo sanguineo: " + this.bloodGroup);
        System.out.println("Idade " + this.age);
    }
}
