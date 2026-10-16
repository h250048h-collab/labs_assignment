enum Level { LOW, MEDIUM, HIGH }

public class LevelDemo {
    static String advice(Level level) {
        return switch (level) {
            case LOW    -> "Relax; no action needed.";
            case MEDIUM -> "Keep an eye on it.";
            case HIGH   -> "Act immediately!";
        };
    }

    public static void main(String[] args) {
        for (Level l : Level.values()) {
            System.out.println(l + ": " + advice(l));
        }
    }
}
