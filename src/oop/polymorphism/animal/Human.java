package oop.polymorphism.animal;

import javax.tools.Tool;

public class Human extends Mammal {
    String country;
    Animal pet;
    void useTool(Tool tool){
        System.out.println("도구를 사용합니다.");
    }
    void adopt(Animal animal) {
        if(animal.getClass() == new Tiger().getClass()) {
            System.out.println("호랑이는 위험해서 키울 수 없어요.");
        }
        this.pet = animal;
    }



}
