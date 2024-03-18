abstract class Shape {
    public abstract double calculateArea();
}
class Circle extends Shape {
    private double radius;
    public Circle(double radius) {
        this.radius = radius;
    }
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}
interface Animal {
    void eat();
    void sleep(); 
}
class Dog implements Animal {
    @Override
    public void eat() {
        System.out.println("Dog is eating");
    }

    @Override
    public void sleep() {
        System.out.println("Dog is sleeping");
    }
}

public class AbstractionExample {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        System.out.println("Area of circle: " + circle.calculateArea());
        Dog dog = new Dog();
        dog.eat();
        dog.sleep();
    }
}
