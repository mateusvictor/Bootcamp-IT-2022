package generics;

public class Main {
    public static void main(String[] args) {
        PersonRepository repo = new PersonRepository();
        repo.write(new Person("Mateus", "Silva"));

        AddressRepository repo2 = new AddressRepository();
        repo2.write(new Address("Sao Paulo", "03681-139", "Avenida Brasil, 82"));
    }
}
