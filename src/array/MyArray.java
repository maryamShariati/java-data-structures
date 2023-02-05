package array;
import java.util.Arrays;


public class MyArray implements Array{
    private static final int[] emptyElementData = {};
    transient int[] elementData;

    private int numberIndex=0;

    public MyArray(int initialCapacity)
    {
        if (initialCapacity > 0)
        {
            this.elementData = new int[initialCapacity];
        }
        else if (initialCapacity == 0)
        {
            this.elementData = emptyElementData;
        }
        else
        {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
    }


    @Override
    public void add(int element) {

        ensureExplicitCapacity(numberIndex+1);
        elementData[numberIndex] = element;
        numberIndex++;

    }

    @Override
    public void remove(int element) {

        int index = indexOf(element);
        removeByIndex(index);

    }

    @Override
    public void removeByIndex(int index) {

        for (int i = index; i < numberIndex; i++) {

            elementData[i] = elementData[i+1];
        }
        numberIndex--;
    }

    @Override
    public int indexOf(int element) {

        int index = 0 ;

        for (int e:elementData) {
            if (element == e){

                return index;
            }
          index++;
        }

        throw new IllegalArgumentException(" invalid input");

    }

    @Override
    public boolean contains(int element) {

        for (int i = 0; i < numberIndex; i++) {

            if (element == elementData[i]){
                return true;
            }
        }

        return false;

    }

    @Override
    public int size() {
        return numberIndex;
    }

    @Override
    public void print() {

        for (int e: elementData) {
            System.out.println(e);
        }
    }

    private void ensureExplicitCapacity(int minCapacity) {
        if (minCapacity - elementData.length > 0)
            grow(minCapacity);
    }

    private void grow(int minCapacity)
    {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity > 0)
            newCapacity = minCapacity;

       elementData = Arrays.copyOf(elementData , newCapacity);

    }





}
