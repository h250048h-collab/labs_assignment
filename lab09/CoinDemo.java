import java.util.EnumMap;
import java.util.Map;

enum Coin {
    QUARTER(25), DIME(10), NICKEL(5), PENNY(1);     // largest first for the greedy method

    private final int value;
    Coin(int value) { this.value = value; }
    int value() { return value; }

    // Fewest coins: greedy works for this coin system (25, 10, 5, 1)
    static Map<Coin, Integer> change(int cents) {
        if (cents < 0) throw new IllegalArgumentException("Negative amount");
        Map<Coin, Integer> result = new EnumMap<>(Coin.class);
        for (Coin c : Coin.values()) {
            int count = cents / c.value;
            if (count > 0) {
                result.put(c, count);
                cents %= c.value;
            }
        }
        return result;
    }
}

public class CoinDemo {
    public static void main(String[] args) {
        int amount = 68;
        Map<Coin, Integer> coins = Coin.change(amount);
        int total = coins.values().stream().mapToInt(Integer::intValue).sum();
        System.out.println(amount + " cents -> " + coins + " (" + total + " coins)");
    }
}
