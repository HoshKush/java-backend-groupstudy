package oop.polymorphism.animal;

public class Animal {
    boolean alive;          //생존 여부
    int age;                //나이
    int nutrition;          //영양상태
    int energy;             //생명력

    Animal() {
        this.age = 1;
        this.nutrition = 100;
        this.energy = 100;
    }

    void move(){
        System.out.println("다리로 걷는다");
    };
    void breath(Air air) {
        System.out.println("숨을 쉬어서 생명력 증가");
        energy++;
    };

    void eat(Food food) {
        System.out.println("음식을 먹어서 영양상태 증가했지롱");
        nutrition += food.nutrition;
    };

    void increaseAge() {
        System.out.println("나이 증가");
        age++;
    }

    public int getNutrition() {
        return nutrition;
    }

    public int getEnergy() {
        return energy;
    }
}
