public class Teacher extends Person {
    private final String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    public static void main(String[] args) {
        Person[] people = {
            new Student("Tariro", 19, "Computer Science"),
            new Teacher("Mr Moyo", 45, "Mathematics")
        };
        for (Person p : people) p.display();   // same inherited code for both
    }
}
