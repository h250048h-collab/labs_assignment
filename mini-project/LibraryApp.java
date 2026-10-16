import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class LibraryApp {
    private static final Path DATA_DIR = Path.of("library-data");

    public static void main(String[] args) {
        Library library = new Library();
        try {
            library.load(DATA_DIR);
            System.out.println("Data loaded.");
        } catch (IOException e) {
            System.out.println("Could not load data: " + e.getMessage());
        }

        Scanner in = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n1 Add item  2 Register member  3 Borrow  4 Return");
            System.out.println("5 List overdue  6 Search by title  0 Save and exit");
            System.out.print("Choice: ");
            String choice = in.nextLine().trim();

            try {
                switch (choice) {
                    case "1" -> {
                        System.out.print("Type (book/dvd): ");   String type  = in.nextLine().trim();
                        System.out.print("Item id: ");           String id    = in.nextLine();
                        System.out.print("Title: ");             String title = in.nextLine();
                        LibraryItem item = type.equalsIgnoreCase("dvd")
                                ? new Dvd(id, title) : new Book(id, title);
                        library.addItem(item);
                        System.out.println("Added: " + item);
                    }
                    case "2" -> {
                        System.out.print("Member id: "); String id   = in.nextLine();
                        System.out.print("Name: ");      String name = in.nextLine();
                        library.registerMember(new Member(id, name));
                        System.out.println("Member registered.");
                    }
                    case "3" -> {
                        System.out.print("Member id: "); String m = in.nextLine().trim();
                        System.out.print("Item id: ");   String i = in.nextLine().trim();
                        library.borrow(m, i);
                        System.out.println("Borrowed.");
                    }
                    case "4" -> {
                        System.out.print("Member id: "); String m = in.nextLine().trim();
                        System.out.print("Item id: ");   String i = in.nextLine().trim();
                        library.giveBack(m, i);
                        System.out.println("Returned.");
                    }
                    case "5" -> {
                        var overdue = library.overdueLoans();
                        if (overdue.isEmpty()) System.out.println("No overdue items.");
                        else overdue.forEach(System.out::println);
                    }
                    case "6" -> {
                        System.out.print("Search text: ");
                        var found = library.searchByTitle(in.nextLine());
                        if (found.isEmpty()) System.out.println("No matches.");
                        else found.forEach(System.out::println);
                    }
                    case "0" -> {
                        library.save(DATA_DIR);
                        System.out.println("Saved. Goodbye.");
                        running = false;
                    }
                    default -> System.out.println("Unknown option.");
                }
            } catch (ItemNotAvailableException | MemberLimitExceededException e) {
                System.out.println("Cannot borrow: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("File error: " + e.getMessage());
            }
        }
    }
}
