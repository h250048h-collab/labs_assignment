import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class FileStats {
    public static void main(String[] args) {
        Path path = Path.of(args.length > 0 ? args[0] : "notes.txt");

        try {
            List<String> lines = Files.readAllLines(path);

            int lineCount = lines.size();
            int wordCount = 0;
            int charCount = 0;

            for (String line : lines) {
                charCount += line.length();
                if (!line.isBlank()) {
                    wordCount += line.trim().split("\\s+").length;
                }
            }

            System.out.println("Lines: " + lineCount);
            System.out.println("Words: " + wordCount);
            System.out.println("Characters (excluding line breaks): " + charCount);

        } catch (NoSuchFileException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Read error: " + e.getMessage());
        }
    }
}
