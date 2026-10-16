public class ArrayAccess {
    static int getElement(int[] arr, int index) {
        try {
            return arr[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index " + index + ": " + e.getMessage());
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] data = {10, 20, 30};
        System.out.println(getElement(data, 1));   // 20
        System.out.println(getElement(data, 7));   // message, then -1
    }
}
