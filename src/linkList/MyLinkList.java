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

    public void deleteLast() {
        if (isEmpty()) throw new NoSuchElementException();
        if (first == last) {
            first = last = null;
            size--;
            return;
        }
        var prevLastNode = first;

        for (; prevLastNode != null; prevLastNode = prevLastNode.next) {
            if (prevLastNode.next == last) break;
        }

        assert prevLastNode != null;
        prevLastNode.next = null;
        last = prevLastNode;

        size--;
    }
    private boolean isEmpty() {
        return first == null;
    }
    @Override
    public void add(T t) {
        addLast(t);
    }

    @Override
    public void remove(T t) {
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last) {
            deleteFirst();
            return;
        }
        var selectedNode = first;
        var prevNode = first;
        while (!selectedNode.contain(t)) {
            if (selectedNode.next == null){
                return;}

            prevNode = selectedNode;
            selectedNode = selectedNode.next;
        }
        prevNode.next = selectedNode.next;
        size--;
    }
    @Override
    public void removeByIndex(int i) {
        if (isEmpty())
            throw new NoSuchElementException();

        if (i < 0 || i>= size)
            throw new ArrayIndexOutOfBoundsException();

        if (first == last) {
            deleteFirst();
            return;
        }
        //i dont no
        var steps = 0;
        var selectedNode = first;
        var prevNode = first;

        while (i!= steps) {
            if (selectedNode.next == null)
                return;

            prevNode = selectedNode;
            selectedNode = selectedNode.next;
            steps++;
        }
        prevNode.next = selectedNode.next;
        size--;
    }


    @Override
    public int indexOf(T t) {

        var index = 0;
        for (var s = first; s != null; s = s.next) {
            if (s.contain(t)){
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public boolean contains(T t) {
        return indexOf(t) > -1;
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
