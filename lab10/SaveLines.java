import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaveLines {
    public static void main(String[] args) {
        Path path = Path.of("notes.txt");
        List<String> lines = new ArrayList<>();

        Scanner in = new Scanner(System.in);
        for (int i = 1; i <= 5; i++) {
            System.out.print("Line " + i + ": ");
            lines.add(in.nextLine());
        }

        try {
            Files.write(path, lines);                       // save
            System.out.println("--- file contents ---");
            for (String line : Files.readAllLines(path)) {  // read back
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}
