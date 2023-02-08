package array;

public interface Array <E> {
    void add(Object e);

    void remove(Object e);

    void removeByIndex(int i);

    int indexOf(Object e);

    boolean contains(Object e);

    int size();

    void print();
}
