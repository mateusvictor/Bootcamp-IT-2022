package interfaces.exercise3;

public class Main {
    public static void main(String[] args) {
        Cow cow = new Cow();
        cow.sound();
        cow.eatVegetable();

        Cat cat = new Cat();
        cat.sound();
        cat.eatMeat();

        Dog dog = new Dog();
        dog.sound();
        dog.eatMeat();

        System.out.println("---------------");
        sound(cow);
    }

    public static void sound(Animal animal) {
        animal.sound();
    }
}
