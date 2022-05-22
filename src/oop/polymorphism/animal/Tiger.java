package oop.polymorphism.animal;

public class Tiger extends Mammal {
    @Override
    void eat(Food food) {
        if(food.getClass().getName().endsWith("Grass")) {
            System.out.println("호랑이는 풀을 뜯을 수 없습니다.");
            return;
        }
        super.eat(food);
    }

    static Meat hunt(Animal animal) {
        return new Meat(animal.nutrition);
    }
}
