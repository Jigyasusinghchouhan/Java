import cal_data.MathFunctions;

public class question5 {
    public static void main(String[] args) {
        MathFunctions mf = new MathFunctions();
        double squareArea = mf.squareArea(5);
        System.out.println("Square area: " + squareArea);
        double rectangleArea = mf.rectangleArea(5, 7);
        System.out.println("Rectangle area: " + rectangleArea);
        double triangleArea = mf.triangleArea(5, 7);
        System.out.println("Triangle area: " + triangleArea);
        double square = mf.square(5);
        System.out.println("Square: " + square);
        double cube = mf.cube(5);
        System.out.println("Cube: " + cube);
    }
}