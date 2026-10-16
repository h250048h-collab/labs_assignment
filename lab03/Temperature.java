public class Temperature {
    private static final double ABSOLUTE_ZERO_K = 0.0;
    private double kelvin;                         // internal unit, hidden from callers

    public Temperature(double celsius) {
        setCelsius(celsius);
    }

    public double getCelsius()    { return kelvin - 273.15; }
    public double getFahrenheit() { return getCelsius() * 9.0 / 5.0 + 32; }

    public void setCelsius(double celsius) {
        double k = celsius + 273.15;
        if (k < ABSOLUTE_ZERO_K)
            throw new IllegalArgumentException("Below absolute zero: " + celsius + " C");
        this.kelvin = k;
    }

    public static void main(String[] args) {
        Temperature t = new Temperature(25);
        System.out.printf("%.2f C, %.2f F%n", t.getCelsius(), t.getFahrenheit());

        try {
            new Temperature(-300);
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }
    }
}
