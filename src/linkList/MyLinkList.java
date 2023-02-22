package linkList;

import array.Array;

import java.util.NoSuchElementException;

public class MyLinkList<T> implements Array<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;
    public MyLinkList() {
    }
    public void addFirst(T element) {
        var node = new Node<>(element);

        if (isEmpty()) {
            first = last = node;
        } else {
            node.next = first;
            first = node;
        }
        size++;
    }
    public void deleteFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        if (first == last) {
            first = last = null;
            size--;
            return;
        }
        var second = first.next;
        first.next = null;
        first = second;
        size--;
    }
    public void deleteLast() {
        if (isEmpty()) throw new NoSuchElementException();
        if (first == last) {
            first = last = null;
            size--;
            return;
        }
    }
    public void addLast(T element) {
        var node = new Node<>(element);

        if (isEmpty()) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
        size++;
    }
    private boolean isEmpty() {
        return first == null;
    }
    @Override
    public void add(T t) {

    }

    @Override
    public void remove(T t) {

    }

    @Override
    public void removeByIndex(int i) {

    }

    @Override
    public int indexOf(T t) {
        return 0;
    }

    @Override
    public boolean contains(T t) {
        return false;
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public void print() {
        System.out.println(this);
    }
}
