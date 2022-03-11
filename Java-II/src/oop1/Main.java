package oop1;

public class Main {
    public static void main(String[] args) {
//        exercise4();
        exercise6();
    }

    private static void exercise4() {
        Person personWithAllAttr = new Person("Mateus", 18, "83123", 70.01, 1.95);
        System.out.println("Todos os parametros: " + personWithAllAttr.toString());

        Person personWithNoAttr = new Person();
        System.out.println("Sem parametros: " + personWithNoAttr);

        Person personWithSomeAttr = new Person("Mateus", 18, "17283");
        System.out.println("Nome, idade  e ID:" + personWithSomeAttr.toString());

//        Invalid
//        Person personWrongAttr = new Person("Mateus", "18");
    }

    public static void exercise6() {
        Person person = new Person("Mateus", 17, "83123", 70.01, 1.95);
        System.out.println(person.toString());
    }
}
