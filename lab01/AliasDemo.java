public class AliasDemo {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();
        r1.width = 5;

        Rectangle r2 = r1;      // copies the REFERENCE, not the object
        r2.width = 99;

        System.out.println(r1.width);   // prediction: 99.0
    }
}
