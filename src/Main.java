import array.Array;
import array.MyArray;

public class Main {
    public static void main(String[] args){

        Array<String> myArray = new MyArray<>(4);
        myArray.add("a");
        myArray.add("b");
        myArray.add("c");
        myArray.add("d");
        System.out.println(myArray.size());
        myArray.print();
        myArray.add("w");
        myArray.print();
        System.out.println(myArray.size());
        myArray.removeByIndex(3);
        myArray.print();
        System.out.println(myArray.size());
        System.out.println(myArray.contains("n"));
        myArray.remove("w");
        myArray.print();
        System.out.println(myArray.size());



    }
}