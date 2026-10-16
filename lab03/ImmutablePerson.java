import java.util.ArrayList;
import java.util.List;

public final class ImmutablePerson {          // (1) final class: cannot be subclassed
    private final String name;                // (2) final fields: assigned once
    private final int age;
    private final List<String> hobbies;       // mutable type, so extra care below

    public ImmutablePerson(String name, int age, List<String> hobbies) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name required");
        if (age < 0) throw new IllegalArgumentException("Age cannot be negative");
        this.name = name;
        this.age = age;
        this.hobbies = List.copyOf(hobbies);  // (3) defensive copy in
    }

    public String getName()          { return name; }   // (4) getters only, no setters
    public int getAge()              { return age; }
    public List<String> getHobbies() { return hobbies; } // already immutable, safe to return

    public ImmutablePerson withAge(int newAge) {          // (5) "change" = make a new object
        return new ImmutablePerson(name, newAge, hobbies);
    }

    public static void main(String[] args) {
        List<String> hobbies = new ArrayList<>(List.of("chess", "reading"));
        ImmutablePerson p = new ImmutablePerson("Rudo", 20, hobbies);
        hobbies.add("gaming");                       // does not affect p
        System.out.println(p.getName() + " " + p.getAge() + " " + p.getHobbies());

        ImmutablePerson older = p.withAge(21);
        System.out.println(older.getAge() + " (original still " + p.getAge() + ")");
    }
}
