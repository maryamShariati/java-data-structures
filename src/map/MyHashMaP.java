package map;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Optional;

public class MyHashMaP {

    private LinkedList<Person>[] persons;

    private MyHashMaP(){
        persons=new LinkedList[5];
    }
    public void put(int key ,Person value){
        var index=hash(key);
        if (persons[index]==null){
            persons[index]=new LinkedList<>();
            persons[index].addLast(value);
        }
        persons[index].addLast(value);
    }
    public Person get(int key){
       var index= hash(key);
       if (persons[index]==null){
           return null;
       }
       var bucket=persons[key];
      Optional<Person>person= bucket.stream().filter(p ->p.getCode().equals(key)).findFirst();
        return person.orElse(null);

    }
    private int hash(int code){
       return code% persons.length;
    }
    @Override
    public String toString(){
        return Arrays.toString(persons);
    }
}
