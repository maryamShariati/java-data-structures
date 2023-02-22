package array;

public interface Array <E> {
    void add(E e);

    void remove(E e);

    void removeByIndex(int i);

    int indexOf(E e);

    boolean contains(E e);

    int size();

    void print();
}
