public class question5 {
    String studentName;
    int studentAge;

    // constructor
    question5(String name, int age) {
        studentName = name;
        studentAge = age;
    }

    void display() {
        System.out.println(studentName + " " + studentAge);
    }

    public static void main(String args[]) {
        question5 myObj = new question5("Chinmaya", 22);
        myObj.display();
    }
}