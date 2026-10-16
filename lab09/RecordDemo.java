record Student(String name, int age) { }

public class RecordDemo {
    public static void main(String[] args) {
        Student s1 = new Student("Tariro", 19);
        Student s2 = new Student("Tariro", 19);
        Student s3 = new Student("Farai", 20);

        System.out.println(s1);                       // generated toString
        System.out.println(s1.equals(s2));            // true: same component values
        System.out.println(s1.equals(s3));            // false
        System.out.println(s1 == s2);                 // false: different objects
        System.out.println(s1.name() + " is " + s1.age());   // accessors
    }
}
