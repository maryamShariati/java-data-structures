package array;



public class MyArray<E> implements Array<E> {
    private static final int initialCapacity = 10;
    private Object[] elementData;
    private int numberIndex;

    public MyArray() {
        this.elementData = new Object[initialCapacity];
    }

    public MyArray(int initialCapacity) {
        if (initialCapacity < 1)
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);

        this.elementData = new Object[initialCapacity];
    }


    @Override
    public void add(Object element) {

        var mainCapacity = numberIndex + 1;
        if (mainCapacity - elementData.length > 0) {
            grow();
        }
        elementData[numberIndex] = element;
        numberIndex++;

    }

    @Override
    public void remove(Object element) {
        int index = indexOf(element);
        removeByIndex(index);
    }

    @Override
    public void removeByIndex(int index) {
        if( index >= 0 && index < numberIndex){
            for (int i = index; i < numberIndex; i++) {

                elementData[i] = elementData[i + 1];
            }
            elementData[numberIndex-1] = null;
            numberIndex--;
        }else {
            throw new IndexOutOfBoundsException("input index is out of range !");
        }
    }

    @Override
    public int indexOf(Object element) {
        for (int i = 0; i <=numberIndex; i++) {
            if (element.equals(elementData[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(Object element) {
        return indexOf(element) > -1;
    }

    @Override
    public int size() {
        return numberIndex;
    }

    @Override
    public void print() {
        for (int i = 0; i < numberIndex; i++) {
            System.out.print(elementData[i] + "|");
        }
        System.out.println();
    }

    private void grow() {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);

        Object[] newArray = new Object[newCapacity];
        for (int i = 0; i < numberIndex; i++) {
            newArray[i] = elementData[i];
        }
        elementData = newArray;
    }
}

