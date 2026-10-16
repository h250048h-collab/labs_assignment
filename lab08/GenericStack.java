import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class GenericStack<T> {
    private final List<T> items = new ArrayList<>();

    public void push(T item) { items.add(item); }

    public T pop() {
        if (items.isEmpty()) throw new EmptyStackException();
        return items.remove(items.size() - 1);
    }

    public T peek() {
        if (items.isEmpty()) throw new EmptyStackException();
        return items.get(items.size() - 1);
    }

    public boolean isEmpty() { return items.isEmpty(); }

    public static void main(String[] args) {
        GenericStack<Integer> ints = new GenericStack<>();
        ints.push(1); ints.push(2); ints.push(3);
        System.out.println(ints.pop());     // 3
        System.out.println(ints.peek());    // 2

        GenericStack<String> words = new GenericStack<>();
        words.push("a"); words.push("b");
        System.out.println(words.pop());    // b
        System.out.println(words.isEmpty());// false
    }
}
