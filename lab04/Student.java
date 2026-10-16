public class Student extends Person {
    private final String course;

    public Student(String name, int age, String course) {
        super(name, age);
        this.course = course;
    }

    public static void main(String[] args) {
        Person p = new Person("Kudzai", 40);
        Student s = new Student("Tariro", 19, "Computer Science");
        p.display();
        s.display();       // inherited; shows only name and age
    }
}
