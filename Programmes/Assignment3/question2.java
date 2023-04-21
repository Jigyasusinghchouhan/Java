abstract class Shape {
    public abstract double getArea();
}

interface Drawable {
    public void draw();
}

class Circle extends Shape implements Drawable {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public void draw() {
        System.out.println("Drawing a circle with radius " + radius);
    }
}

public class question2 {
    public static void main(String[] args) {
        Circle c = new Circle(5);
        System.out.println("Area of circle: " + c.getArea());
        c.draw();
    }
}
