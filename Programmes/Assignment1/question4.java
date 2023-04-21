class Animal {
    public void move() {
        System.out.println("Animals can move");
    }
}

class Dog extends Animal {
    public void move() {
        System.out.println("Dogs can walk and run");
    }

    public void bark() {
        System.out.println("Dogs can bark");
    }
}

class Cat extends Animal {
    public void move() {
        System.out.println("Cats can walk and run");
    }

    public void meow() {
        System.out.println("Cats can meow");
    }
}

public class question4 {
    public static void main(String[] args) {
        Animal a = new Animal();
        Animal b = new Dog();
        Animal c = new Cat();
        a.move();
        b.move();
        c.move();
    }
}
