public class Intern extends Employee {
    private static final double STIPEND_PER_HOUR = 8.0;
    private final int hoursWorked;

    public Intern(String name, int hoursWorked) {
        super(name, 0);
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculatePay() {
        return hoursWorked * STIPEND_PER_HOUR;
    }
}
