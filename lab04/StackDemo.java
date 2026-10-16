import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

// BAD design (for comparison): class BadStack<T> extends ArrayList<T> { ... }
// It would expose add(index, x), remove(index), get(i), set(i, x), clear() and so on.

// GOOD design: Stack HAS-A list and exposes only stack operations.
class Stack<T> {
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
    public int size()        { return items.size(); }
}

public class StackDemo {
    public static void main(String[] args) {
        Stack<String> s = new Stack<>();
        s.push("a"); s.push("b"); s.push("c");
        System.out.println(s.pop());    // c
        System.out.println(s.peek());   // b
        System.out.println(s.size());   // 2
    }
}
