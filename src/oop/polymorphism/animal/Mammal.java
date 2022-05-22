package oop.polymorphism.animal;

public class Mammal extends Animal{
    int legs;
    Mammal giveBirth() {
        System.out.println("새끼를 낳다");
        return new Mammal();
    };
}
