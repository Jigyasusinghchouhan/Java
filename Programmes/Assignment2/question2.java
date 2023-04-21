
//Multilevel inheritance and method overriding.
import java.util.Scanner;

// Base class A 
class A {
    int a;
    Scanner sc = new Scanner(System.in);

    void variablea() {
        System.out.println("Please enter first number for addition");
        a = sc.nextInt();
    }

    void overmessage() {
        System.out.println(" Welcome to the base class A");
    }
}

// Derived class B
class B extends A {
    int b;

    void getvariable() {
        System.out.println("Please enter the second number for addition");
        b = sc.nextInt();
    }

    void overmessage() {
        System.out.println("Welcome to the derived class B that extends A");
    }
}

// Derived class C
class C extends B {

    void addition() {
        System.out.println("Addition of the variables you entered is " + (a + b));
    }

    void overmessage() {
        System.out.println("Welcome to the derived class C that extends B which extends A");
        System.out.println("Hence,  Method overridden");
    }
}

// Main class
class question2 {
    public static void main(String args[]) {
        System.out.println("Method overridding and multi level inheritance");
        C c = new C();
        c.variablea();
        c.getvariable();
        c.addition();
        c.overmessage();
    }
}