package linkList;

public class Node <T>{

    final T value;

    Node<T> next;

    Node(T value) {
        this(value, null);
    }

    Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }
    public boolean contain(T value) {
        return this.value == value;
    }
}
