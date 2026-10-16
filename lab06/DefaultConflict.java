interface English {
    default void hello() { System.out.println("Hello"); }
}

interface Shona {
    default void hello() { System.out.println("Mhoro"); }
}

class Greeter implements English, Shona {
    // Without this override the class does not compile (ambiguous default methods).
    @Override
    public void hello() {
        English.super.hello();      // choose one explicitly
        Shona.super.hello();        // or call both
    }
}

public class DefaultConflict {
    public static void main(String[] args) {
        new Greeter().hello();
    }
}
