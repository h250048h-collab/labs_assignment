public class Employee {
    private static int nextId = 1;

    private final int employeeId;
    private String name;
    private String department;
    private double salary;

    // Constructor 1: full
    public Employee(String name, String department, double salary) {
        this.employeeId = nextId++;       // auto-increment
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Constructor 2: name and department
    public Employee(String name, String department) {
        this(name, department, 0.0);
    }

    // Constructor 3: name only
    public Employee(String name) {
        this(name, "Unassigned");
    }

    // Copy constructor: a new employee (new id) with the same details
    public Employee(Employee other) {
        this(other.name, other.department, other.salary);
    }

    @Override
    public String toString() {
        return "#" + employeeId + " " + name + ", " + department + ", " + salary;
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("Tendai", "IT", 2500);
        Employee e2 = new Employee("Rudo", "HR");
        Employee e3 = new Employee("Farai");
        Employee e4 = new Employee(e1);

        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e3);
        System.out.println(e4);
    }
}
