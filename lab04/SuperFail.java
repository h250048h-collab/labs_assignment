class Animal {
    protected String name;
    Animal(String name) { this.name = name; }   // only constructor; no no-arg one
}

// class Dog extends Animal { }
// COMPILE ERROR: constructor Animal in class Animal cannot be applied to given types

class Dog extends Animal {
    Dog(String name) {
        super(name);          // FIX: explicitly call the existing superclass constructor
    }
}

public class SuperFail {
    public static void main(String[] args) {
        Dog d = new Dog("Rex");
        System.out.println(d.name);
    }
}
