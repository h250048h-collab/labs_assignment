public class Circle {
    private static int count = 0;      // one copy shared by all circles
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
        count++;
    }

    public Circle() { this(1.0); }     // default radius 1.0

    public double area() { return Math.PI * radius * radius; }

    public static int getCount() { return count; }

    public static void main(String[] args) {
        Circle c1 = new Circle(3.5);
        Circle c2 = new Circle();
        System.out.printf("c1 area = %.2f%n", c1.area());
        System.out.printf("c2 area = %.2f%n", c2.area());
        new Circle(5);
        System.out.println("Circles created: " + Circle.getCount());   // 3
    }
}
