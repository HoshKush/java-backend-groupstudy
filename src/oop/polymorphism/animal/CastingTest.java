package oop.polymorphism.animal;

public class CastingTest {
    public static void main(String[] args) {
        Animal animal = new Bird();

        System.out.println(animal.getClass().getName());

    }

}
