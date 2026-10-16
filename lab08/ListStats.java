import java.util.*;

public class ListStats {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(List.of(14, 3, 27, 8, 19, 42, 5, 31, 11, 22));

        int sum = 0;
        for (int n : nums) sum += n;
        int max = Collections.max(nums);

        System.out.println("Sum: " + sum);
        System.out.println("Max: " + max);

        List<Integer> reversed = new ArrayList<>(nums);
        Collections.reverse(reversed);
        System.out.println("Reversed: " + reversed);
    }
}
