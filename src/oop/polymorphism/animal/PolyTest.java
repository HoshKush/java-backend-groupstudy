package oop.polymorphism.animal;

public class PolyTest {
    public static void main(String[] args) {
        Animal bird = new Bird();
        Bird bird1 = new Bird();

        System.out.println("참조변수가 조상 클래스(참조변수의 타입과 인스턴스의 타입이 불일치) : " + bird.energy);
        System.out.println("참조변수가 자손 클래스(참조변수의 타입과 인스턴스의 타입이 일치) : " + bird1.energy);
    }
}
