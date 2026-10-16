import java.util.*;

class Student implements Comparable<Student> {
    private final String name;
    private final int marks;

    Student(String name, int marks) { this.name = name; this.marks = marks; }
    String getName() { return name; }
    int getMarks()   { return marks; }

    @Override
    public int compareTo(Student other) {            // natural order: by name
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() { return name + "(" + marks + ")"; }
}

public class StudentSort {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>(List.of(
            new Student("Tino", 70), new Student("Ada", 91), new Student("Moyo", 55)));

        Collections.sort(list);                           // uses compareTo
        System.out.println("By name: " + list);

        Comparator<Student> byMarks = (a, b) -> Integer.compare(b.getMarks(), a.getMarks());
        list.sort(byMarks);                               // marks, highest first
        System.out.println("By marks: " + list);
    }
}
