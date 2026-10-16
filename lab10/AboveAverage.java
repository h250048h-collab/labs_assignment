import java.util.*;
import java.util.stream.Collectors;

record Student(String name, double mark) { }

public class AboveAverage {
    public static void main(String[] args) {
        List<Student> students = List.of(
            new Student("Tino", 70), new Student("Ada", 91),
            new Student("Moyo", 55), new Student("Zodwa", 82),
            new Student("Ben", 64));

        double average = students.stream()
            .mapToDouble(Student::mark)
            .average()
            .orElse(0);
        System.out.printf("Class average: %.1f%n", average);

        List<String> names = students.stream()
            .filter(s -> s.mark() > average)
            .map(Student::name)
            .sorted()
            .collect(Collectors.toList());

        names.forEach(System.out::println);
    }
}
