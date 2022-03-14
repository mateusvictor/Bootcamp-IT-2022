package interfaces.exercise3;

public class Cat extends Animal implements Carnivore {
    @Override
    public void sound() {
        System.out.println("Miauu...");
    }

    @Override
    public void eatMeat() {
        System.out.println("Sou gato e estou comendo carne...");
    }
}
