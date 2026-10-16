import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class BandReports {

    static String band(Learner l) {
        if (l.gpa() >= 3.5) return "A";
        if (l.gpa() >= 3.0) return "B";
        return "C";
    }

    public static void main(String[] args) throws IOException {
        StudentRepository repo = new StudentRepository("learners.csv");

        // make sure there is something to load on the first run
        if (repo.loadAll().isEmpty()) {
            repo.saveAll(List.of(
                new Learner("Ada", 1, 3.9), new Learner("Kuda", 2, 3.2),
                new Learner("Tariro", 3, 3.8), new Learner("Farai", 4, 2.6),
                new Learner("Rudo", 5, 3.1)));
        }

        Map<String, List<Learner>> byBand = repo.loadAll().stream()
            .collect(Collectors.groupingBy(BandReports::band, TreeMap::new, Collectors.toList()));

        for (Map.Entry<String, List<Learner>> entry : byBand.entrySet()) {
            List<String> lines = new ArrayList<>();
            lines.add("Band " + entry.getKey() + " (" + entry.getValue().size() + " learners)");
            for (Learner l : entry.getValue()) {
                lines.add(String.format("%-8s roll=%d gpa=%.1f", l.name(), l.roll(), l.gpa()));
            }
            Path out = Path.of("band-" + entry.getKey() + ".txt");
            Files.write(out, lines);
            System.out.println("Wrote " + out + " (" + entry.getValue().size() + " learners)");
        }
    }
}
