import array.Array;
import array.MyArray;

public class Main {
    public static void main(String[] args){
        Array myArray = new MyArray(12);
        myArray.add(2);
        myArray.add(4);
        myArray.add(6);
        System.out.println(myArray.size());
        myArray.remove(2);
        myArray.remove(6);
        System.out.println(myArray.size());



    }
}