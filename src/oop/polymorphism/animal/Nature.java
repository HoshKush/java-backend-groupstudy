package oop.polymorphism.animal;

public class Nature {
    public static void main(String[] args) {
        Animal tiger = new Tiger();
        Animal horse = new Horse();
        Human hosik = new Human();

        System.out.println(tiger.getNutrition());
        Food food = Tiger.hunt(horse);
        Food food2 = new Grass(10);

        System.out.println("tiger");
        tiger.eat(food);
        System.out.println("tiger - grass : " + tiger.getNutrition());

        tiger.eat(food2);
        System.out.println("tiger - meat : " + tiger.getNutrition());

        System.out.println();
        System.out.println("horse");
        horse.eat(food);
        System.out.println("horse - grass : " + horse.getNutrition());

        horse.eat(food2);
        System.out.println("horse - meat : " + horse.getNutrition());

        hosik.adopt(new Cat());
    }
}
