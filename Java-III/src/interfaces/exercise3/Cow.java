package interfaces.exercise3;

public class Cow extends Animal implements Herbivore {
    @Override
    public void sound() {
        System.out.println("Muuuuu...");
    }

    @Override
    public void eatVegetable() {
        System.out.println("Sou vaca e estou comendo vegetais...");
    }
}
