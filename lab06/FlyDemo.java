interface Flyable {
    void fly();
}

class Bird implements Flyable {
    @Override public void fly() { System.out.println("Bird flaps its wings"); }
}

class Aeroplane implements Flyable {
    @Override public void fly() { System.out.println("Aeroplane uses its jet engines"); }
}

public class FlyDemo {
    public static void main(String[] args) {
        Flyable[] things = { new Bird(), new Aeroplane() };
        for (Flyable f : things) f.fly();
    }
}
