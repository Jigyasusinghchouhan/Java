public class Person {
    private String name;
    private int age;
    private boolean married;

    public Person() {}

    public Person(String name, int age, boolean married) {
        this.name = name;
        this.age = age;
        this.married = married;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }
}

public class MyApp {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("Jigyasu");
        person.setAge(21);
        person.setMarried(false);
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
        System.out.println("Married: " + person.isMarried());
    }
}
