package com.company.arraylist;

import java.util.Arrays;
import java.util.Collection;

public class MyArrayList<T> {
    private Object[] array;

    public MyArrayList(T[] array) {
        this.array = array;
    }


    public MyArrayList(Collection<T> collection){
        array = collection.toArray();
    }

    public MyArrayList(int sizeOfCollection){
        array = new Object[sizeOfCollection];
    }

    public MyArrayList() {
        array = new Object[]{};
    }

    public void add(T newElement){
        Object[] newArray = new Object[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = newElement;
        array = newArray;
    }

    public void insert(int index, T newElement){
        if(index > array.length) throw new IllegalArgumentException();
        Object[] newArray = new Object[array.length + 1];
        int innerIndex = 0;
        for(int i = 0; i < newArray.length; i++){
            if(i != index){
                newArray[i] = array[i - innerIndex];
            } else {
                newArray[i] = newElement;
                innerIndex++;
            }
        }
        array = newArray;
    }

    public void remove(T removeElement){
        if(contains(removeElement)){
            Object[] newArray = new Object[array.length - 1];
            int innerIndex = 0;
            for(int i = 0; i < array.length; i++){
                if(array[i] != removeElement){
                    newArray[i - innerIndex] = array[i];
                } else {
                    innerIndex++;
                }
            }
            array = newArray;
        }
    }

    public boolean contains(T element){
        boolean contains = false;
        for (Object o : array) {
            if (o == element) {
                contains = true;
                break;
            }
        }
        return contains;
    }

    public int size(){
        return array.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
