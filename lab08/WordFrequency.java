import java.util.*;

public class WordFrequency {
    public static void main(String[] args) {
        String paragraph = "the cat and the dog and the bird saw the cat";

        Map<String, Integer> freq = new HashMap<>();
        for (String w : paragraph.toLowerCase().split("\\W+")) {
            if (!w.isEmpty()) freq.merge(w, 1, Integer::sum);
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(freq.entrySet());
        entries.sort(
            Map.Entry.<String, Integer>comparingByValue().reversed()
                     .thenComparing(Map.Entry.comparingByKey())   // ties: alphabetical
        );

        for (Map.Entry<String, Integer> e : entries) {
            System.out.println(e.getKey() + ": " + e.getValue());
        }
    }
}
