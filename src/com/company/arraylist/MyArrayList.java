package com.company.arraylist;

import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;

public class MyArrayList<T> {
    private Object[] array;

    public MyArrayList(T[] array) {
        this.array = array;
    }


    public MyArrayList(Collection<T> collection){
        array = collection.toArray();
    }

    public MyArrayList(int sizeOfCollection){
        if(sizeOfCollection < 0) throw new IllegalArgumentException();
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

    public void addAll(T[] arrayToBeAdded){
        int defaultArrayLength = array.length;
        int arrayToBeAddedLength = arrayToBeAdded.length;
        Object[] newArray = new Object[defaultArrayLength + arrayToBeAddedLength];
        System.arraycopy(array, 0, newArray, 0, defaultArrayLength);
        for(int i = 0; i < arrayToBeAddedLength; i++){
            newArray[defaultArrayLength + i] = arrayToBeAdded[i];
        }
        array = newArray;
    }

    public void addAll(Collection<T> collection)
    {
        addAll((T[]) collection.toArray());
    }

    public void insert(int index, T newElement){
        if(index > array.length || index < 0) throw new IllegalArgumentException();
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
            boolean removed = false;
            Object[] newArray = new Object[array.length - 1];
            int innerIndex = 0;
            for(int i = 0; i < array.length; i++){
                if(array[i] == removeElement && !removed){
                    innerIndex++;
                    removed = true;
                } else {
                    newArray[i - innerIndex] = array[i];
                }
            }
            array = newArray;
        }
    }

    public void remove(int index){
        if(index > array.length - 1 || index < 0) throw new IllegalArgumentException();
        remove((T) array[index]);
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

    public boolean isEmpty(){
        return array.length == 0;
    }

    public int size(){
        return array.length;
    }

    public void clear(){
        array = new Object[]{};
    }

    public Object[] toArray(){
        Object[] resultArray = new Object[array.length];
        System.arraycopy(array, 0, resultArray, 0, array.length);
        return resultArray;
    }

    public Object getFirst(){
        if(array.length < 1) throw new NoSuchElementException();
        return array[0];
    }

    public Object get(int index){
        if(index > array.length - 1 || index < 0) throw new IllegalArgumentException();
        return array[index];
    }

    public void sort(){
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length - 1; j++){
                if((int) array[i] < (int) array[j]){
                    Object helperElement = array[i];
                    array[i] = array[j];
                    array[j] = helperElement;
                }
            }
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
