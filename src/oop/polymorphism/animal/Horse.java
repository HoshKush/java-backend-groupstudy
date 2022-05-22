package oop.polymorphism.animal;

public class Horse extends Mammal {
    Human rider;
    void giveRideTo(Human human) {
        rider = human;
    }

    @Override
    void eat(Food food) {
        if(food instanceof Meat) {
            System.out.println("말은 고기를 먹을 수 없습니다.");
            return;
        }
        super.eat(food);
    }
}
