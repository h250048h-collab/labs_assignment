public class PayrollDemo {
    public static void main(String[] args) {
        Employee[] staff = {
            new Employee("Kudzai", 2000),
            new Manager("Nyasha", 3500, 800),
            new Developer("Tatenda", 3000, 10),
            new Intern("Chipo", 100)
        };

        System.out.println("----");
        double total = 0;
        for (Employee e : staff) {          // this loop never changes
            total += e.calculatePay();
        }
        System.out.printf("Total payroll: %.2f%n", total);
    }
}
