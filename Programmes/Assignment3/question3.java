class Parent {
    public void display() {
        System.out.println("Parent display method");
    }
}

class Child extends Parent {
    @Override
    public void display() {
        System.out.println("Child display method");
    }
}

class Overload {
    public void display(int num) {
        System.out.println("display(int) method: " + num);
    }

    public void display(String message) {
        System.out.println("display(String) method: " + message);
    }

    public void display(double num) {
        System.out.println("display(double) method: " + num);
    }
}

public class question3 {
    public static void main(String[] args) {
        Parent p = new Child();
        p.display();
        Child c = new Child();
        c.display();
        Overload o = new Overload();
        o.display(5);
        o.display("Hello, World!");
        o.display(3.14);
    }
}
