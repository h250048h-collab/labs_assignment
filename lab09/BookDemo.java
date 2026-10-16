import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Book {
    private final String isbn;
    private final String title;

    Book(String isbn, String title) { this.isbn = isbn; this.title = title; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book other)) return false;
        return isbn.equals(other.isbn);             // identity of a book = its ISBN
    }

    @Override
    public int hashCode() { return Objects.hash(isbn); }   // uses the same field as equals

    @Override
    public String toString() { return title + " [" + isbn + "]"; }
}

public class BookDemo {
    public static void main(String[] args) {
        Set<Book> shelf = new HashSet<>();
        System.out.println(shelf.add(new Book("978-0132350884", "Clean Code")));          // true
        System.out.println(shelf.add(new Book("978-0134685991", "Effective Java")));      // true
        System.out.println(shelf.add(new Book("978-0132350884", "Clean Code (copy)")));   // false

        System.out.println("Size: " + shelf.size());       // 2
    }
}
