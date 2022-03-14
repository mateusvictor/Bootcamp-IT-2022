package interfaces.exercise2;

public class Person {
    private String name;
    private int age;
    private String cpf;
    private String cellphone;

    public Person(String name, int age, String cpf, String cellphone) {
        this.name = name;
        this.age = age;
        this.cpf = cpf;
        this.cellphone = cellphone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", cpf='" + cpf + '\'' +
                ", cellphone='" + cellphone + '\'' +
                '}';
    }
}
