public class FinallyDemo {
    static int test() {
        try {
            System.out.println("in try");
            return 1;
        } finally {
            System.out.println("in finally");
        }
    }

    public static void main(String[] args) {
        int result = test();
        System.out.println("result = " + result);
    }
}
