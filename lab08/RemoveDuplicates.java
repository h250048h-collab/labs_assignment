import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        List<String> names = List.of("Tino", "Ada", "Tino", "Moyo", "Ada", "Zodwa");

        Set<String> unique = new LinkedHashSet<>(names);   // keeps first-seen order
        List<String> result = new ArrayList<>(unique);

        System.out.println(result);
    }
}
