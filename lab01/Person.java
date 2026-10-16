class Address {
    String street;
    String city;
}

public class Person {
    String name;
    Address address;      // a field that refers to another object

    public static void main(String[] args) {
        Address a = new Address();
        a.street = "12 Samora Machel Ave";
        a.city = "Harare";

        Person p1 = new Person();
        p1.name = "Tariro";
        p1.address = a;
        System.out.println(p1.name + " lives in " + p1.address.city);   // chained dot

        Person p2 = new Person();       // address was never set -> null
        p2.name = "Farai";

        // System.out.println(p2.address.city);   // would throw NullPointerException

        if (p2.address == null) {
            System.out.println(p2.name + " has no address recorded");
        } else {
            System.out.println(p2.address.city);
        }
    }
}
