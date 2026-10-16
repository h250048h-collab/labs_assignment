class Parent {
    String label = "Parent field";
    String who() { return "Parent method"; }
}

class Child extends Parent {
    String label = "Child field";                 // hides, does not override
    @Override String who() { return "Child method"; }
}

public class FieldVsMethod {
    public static void main(String[] args) {
        Parent p = new Child();         // declared type Parent, actual object Child
        System.out.println(p.who());    // Child method  (decided at run time)
        System.out.println(p.label);    // Parent field  (decided at compile time)
    }
}
