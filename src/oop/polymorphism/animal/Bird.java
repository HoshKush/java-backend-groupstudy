package oop.polymorphism.animal;

public class Bird extends Animal{
    int wings;
    long energy;
    Bird() {
        super();
        wings = 2;
        energy = 50;
    }

    void move() {
        fly();
    }

    void fly() {
        System.out.println("날아갑니다");
    };

    Egg spawn() {
        System.out.println("알을 낳다");
        return new Egg();
    }
}
