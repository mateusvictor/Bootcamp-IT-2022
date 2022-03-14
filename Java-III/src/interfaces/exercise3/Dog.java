package interfaces.exercise3;

public class Dog extends Animal implements Carnivore {
    @Override
    public void sound() {
        System.out.println("Auau...");
    }

    @Override
    public void eatMeat() {
        System.out.println("Sou cachorro e estou comendo carne...");
    }
}
