public class AgeValidator {
    static void validateAge(int age) throws InvalidAgeException {
        if (age < 0 || age > 120) {
            throw new InvalidAgeException("Age must be between 0 and 120", age);
        }
        System.out.println("Valid age: " + age);
    }

    public static void main(String[] args) {
        int[] tests = {25, -5, 150};
        for (int t : tests) {
            try {
                validateAge(t);
            } catch (InvalidAgeException e) {
                System.out.println("Rejected " + e.getAge() + ": " + e.getMessage());
            }
        }
    }
}
