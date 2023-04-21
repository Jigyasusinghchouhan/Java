class Student {
    public String name;
    public int Registration_Number;
    public float physics;
    public float chemistry;
    public float mathematics;
    public float percentage;

    // constructor
    public Student(
            String name,
            int Registration_Number,
            float physics,
            float chemistry,
            float mathematics) {
        this.name = name;
        this.Registration_Number = Registration_Number;
        this.physics = physics;
        this.chemistry = chemistry;
        this.mathematics = mathematics;
    }

    // method to calcluate the percentage
    public void calculateresult() {
        percentage = ((physics + chemistry + mathematics) / 3);
    }

    // method to display the student details
    public void detaildisplay() {
        System.out.println("Name = " + name);
        System.out.println("Registration Number = " + Registration_Number);
    }

    // method to display the Result
    public void resultdisplay() {
        System.out.println("Percentage received = " + percentage);
    }
}

class question1 {

    public static void main(String args[]) throws Exception {
        Student student = new Student("Chinamya", 112, 98, 90, 99);
        student.calculateresult();
        student.detaildisplay();
        student.resultdisplay();
    }
}
