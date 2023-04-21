interface perimeter {

    float calculate(float x, float y);
}

class rectangle implements perimeter {
    public float calculate(float x, float y) {
        return (2 * (x + y));
    }
}

class square implements perimeter {
    public float calculate(float x, float y) {
        return 4 * x;
    }
}

class question4 {
    public static void main(String args[]) {
        square s = new square();
        rectangle rc = new rectangle();
        perimeter p;
        p = s;
        System.out.println("Area of square with side length of 4 is " + p.calculate(4, 0));
        p = rc;
        System.out.println("Area of rectangle with length 7 and breadth 3 is " + p.calculate(7, 3));
    }
}