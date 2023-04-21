abstract class shape {
    abstract void area();

    abstract void perimeter();
}

class square extends shape {
    void area() {
        System.out.println("Area of Square= Side * Side");

    }

    void perimeter() {
        System.out.println("Perimeter of Square= 4 * Side");
    }
}

class rectangle extends shape {

    void area() {
        System.out.println("Area of Rectangle= Length * Breadth");

    }

    void perimeter() {
        System.out.println("Perimeter of rectangle= 2 * (Length + Breadth)");

    }
}

class question3 {
    public static void main(String args[]) {
        square sq = new square();
        sq.area();
        sq.perimeter();
        rectangle r = new rectangle();
        r.area();
        r.perimeter();
    }
}