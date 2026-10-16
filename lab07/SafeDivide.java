import java.util.InputMismatchException;
import java.util.Scanner;

public class SafeDivide {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            System.out.print("Enter first integer: ");
            int a = in.nextInt();
            System.out.print("Enter second integer: ");
            int b = in.nextInt();
            System.out.println(a + " / " + b + " = " + (a / b));
        } catch (InputMismatchException e) {
            System.out.println("Error: please enter whole numbers only.");
        } catch (ArithmeticException e) {
            System.out.println("Error: cannot divide by zero.");
        } finally {
            in.close();
        }
    }
}
