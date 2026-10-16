import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements Iterable<T> {

    // STATIC NESTED: a node does not need an outer list instance
    private static class Node<T> {
        T value;
        Node<T> next;
        Node(T value) { this.value = value; }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void add(T value) {
        Node<T> node = new Node<>(value);
        if (head == null) { head = tail = node; }
        else              { tail.next = node; tail = node; }
        size++;
    }

    public int size() { return size; }

    // INNER CLASS: walks the outer list's nodes (uses the outer 'head')
    private class ListIterator implements Iterator<T> {
        private Node<T> current = head;

        @Override public boolean hasNext() { return current != null; }

        @Override public T next() {
            if (current == null) throw new NoSuchElementException();
            T value = current.value;
            current = current.next;
            return value;
        }
    }

    @Override
    public Iterator<T> iterator() { return new ListIterator(); }

    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("red");
        list.add("green");
        list.add("blue");

        for (String colour : list) {           // works because the class is Iterable
            System.out.println(colour);
        }
        System.out.println("Size: " + list.size());
    }
}
