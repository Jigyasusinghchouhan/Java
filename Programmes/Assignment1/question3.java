interface Shape {
    double area();
}

abstract class Polygon implements Shape {
    protected int numSides;

    Polygon(int numSides) {
        this.numSides = numSides;
    }
}

class Rectangle extends Polygon {
    private double width;
    private double height;

    Rectangle(double width, double height) {
        super(4);
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }
}

class Square extends Polygon {
    private double side;

    Square(double side) {
        super(4);
        this.side = side;
    }

    @Override
    public double area() {
        return side * side;
    }
}

class question3 {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(5, 10);
        Square square = new Square(5);
        System.out.println("Area of rectangle: " + rectangle.area());
        System.out.println("Area of square: " + square.area());
    }
}
