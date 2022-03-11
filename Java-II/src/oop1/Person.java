package oop1;

public class Person {
    private String name;
    private int age;
    private String id;
    private double weight;
    private double height;

    public Person() {
    }

    public Person(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public Person(String name, int age, String id, double weight, double height) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.weight = weight;
        this.height = height;
    }

    public int calculateIMC(){
        double imcValue = weight / (height * height);

        if (imcValue < 20.0)
            return -1;
        if (imcValue < 25.0)
            return 0;
        else
            return 1;
    }

    public String imcLevel() {
        switch (calculateIMC()){
            case -1:
                return "Abaixo do peso";
            case 0:
                return "Peso saudavel";
            case 1:
                return "Sobre peso";
            default:
                return null;
        }
    }

    public boolean isOfAge() {
        return age >= 18;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id='" + id + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                ", IMC=" + calculateIMC() +
                ", IMC nivel=" + imcLevel() +
                ", isOfAge=" + isOfAge() +
                '}';
    }
}
