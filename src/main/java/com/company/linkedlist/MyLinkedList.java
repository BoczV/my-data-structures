package com.company.linkedlist;


import com.company.interfaces.MyList;

import java.util.Collection;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements MyList<T> {
    private MyNode<T> head;

    private static class MyNode<T> {

        private T value;
        private MyNode<T> neighbor;

        private MyNode(T value) {
            this.value = value;
        }

    }

    public void add(T value){
        MyNode<T> newMyNode = new MyNode<>(value);
        if(head == null) head = newMyNode;
        else {
            MyNode<T> actualMyNode = head;
            while (actualMyNode.neighbor != null) actualMyNode = actualMyNode.neighbor;
            actualMyNode.neighbor = newMyNode;
        }
    }

    public void addAll(Collection<T> list){
        Object[] newElements = list.toArray();
        boolean headIsnull = head == null;
        head = headIsnull? new MyNode<>((T) newElements[0]) : head;
        MyNode<T> actualMyNode = head;
        while (actualMyNode.neighbor != null) actualMyNode = actualMyNode.neighbor;
        for (int i = headIsnull? 1:0; i < list.size(); i++) {
            MyNode<T> newMyNode = new MyNode<>((T) newElements[i]);
            actualMyNode.neighbor = newMyNode;
            actualMyNode = newMyNode;
        }
    }

    public void addAll(T[] array){
        boolean headIsnull = head == null;
        head = headIsnull? new MyNode<>(array[0]) : head;
        MyNode<T> actualMyNode = head;
        while (actualMyNode.neighbor != null) actualMyNode = actualMyNode.neighbor;
        for (int i = headIsnull? 1:0; i < array.length; i++) {
            MyNode<T> newMyNode = new MyNode<>(array[i]);
            actualMyNode.neighbor = newMyNode;
            actualMyNode = newMyNode;
        }
    }

    public Object remove(T value){
        T result;
        if(head == null) return null;
        else {
            MyNode<T> actualMyNode = head;
            MyNode<T> previousMyNode;
            MyNode<T> nextMyNode = actualMyNode.neighbor;
            if(value.getClass().equals(String.class)) result = actualMyNode.value.equals(value)? actualMyNode.value: null;
            else result = actualMyNode.value == value? actualMyNode.value: null;
            if(result != null) {
                head = nextMyNode;
            } else {
                while (actualMyNode.neighbor != null){
                    previousMyNode = actualMyNode;
                    actualMyNode = actualMyNode.neighbor;
                    nextMyNode = actualMyNode.neighbor;
                    if(value.getClass().equals(String.class)) result = actualMyNode.value.equals(value)? actualMyNode.value: null;
                    else result = actualMyNode.value == value? actualMyNode.value: null;
                    if(result != null){
                        previousMyNode.neighbor = nextMyNode;
                        break;
                    }
                }
            }
        }
        return result;
    }

    public Object remove(int index){
        T result = null;
        if(head == null) return null;
        else {
            int counter = 0;
            MyNode<T> actualMyNode = head;
            MyNode<T> previousMyNode;
            MyNode<T> nextMyNode = actualMyNode.neighbor;
            if(counter == index) {
                result = head.value;
                head = nextMyNode;
            } else {
                while (actualMyNode.neighbor != null){
                    counter++;
                    previousMyNode = actualMyNode;
                    actualMyNode = actualMyNode.neighbor;
                    nextMyNode = actualMyNode.neighbor;
                    result = counter == index? actualMyNode.value: null;
                    if(result != null){
                        previousMyNode.neighbor = nextMyNode;
                        break;
                    }
                }
            }
        }
        return result;
    }


    public Object get(int index){

      T result;
      int counter = 0;
      MyNode<T> actualMyNode = head;
      result = counter == index? actualMyNode.value: null;
      if(result == null){
          while (actualMyNode.neighbor != null){
              counter++;
              actualMyNode = actualMyNode.neighbor;
              result = counter == index? actualMyNode.value: null;
              if(result != null) break;
          }
          if(counter < index){
              throw new IndexOutOfBoundsException();
          }
      }
      return result;
    };

    public boolean contains(T value){
        boolean result;
        MyNode<T> actualMyNode = head;
        result = actualMyNode.value == value;
        while (actualMyNode.neighbor != null){
            actualMyNode = actualMyNode.neighbor;
            result = actualMyNode.value == value;
            if(result) break;
        }
        return result;
    }

    public void insert(int index, T value){
        boolean change = false;
        int counter = 0;
        MyNode<T> newMyNode = new MyNode<>(value);
        MyNode<T> previousMyNode;
        if(counter == index){
            previousMyNode = head;
            newMyNode.neighbor = previousMyNode;
            head = newMyNode;
        } else {
            MyNode<T> actualMyNode = head;
            while (actualMyNode.neighbor != null){
                previousMyNode = actualMyNode;
                actualMyNode = actualMyNode.neighbor;
                counter++;
                if(counter == index){
                    previousMyNode.neighbor = newMyNode;
                    newMyNode.neighbor = actualMyNode;
                    change = true;
                    break;
                }
            }
            if(++counter == index && !change){
                actualMyNode.neighbor = newMyNode;
                change = true;
            }
            if(!change) throw new IndexOutOfBoundsException();
        }
    }

    public Object getFirst(){
        if(head == null) throw new NoSuchElementException();
        return head.value;
    }

    public int size(){
        int counter = 0;
        if(head != null) {
            MyNode<T> actualMyNode = head;
            counter++;
            while (actualMyNode.neighbor != null) {
                counter++;
                actualMyNode = actualMyNode.neighbor;
            }
        }
        return counter;
    }

    public void clear(){
        head = null;
    }

    public Object[] toArray()  {
        Object[] array = new Object[size()];
        if(head != null) {
            int counter = 0;
            MyNode<T> actualMyNode = head;
            while (actualMyNode != null) {
                array[counter] = actualMyNode.value;
                actualMyNode = actualMyNode.neighbor;
                counter++;
            }
        }
        return array;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void sort(){
        int size = this.size();
        if (size > 1) {
            for (int i = 0; i < size; i++) {
                MyNode<T> currentMyNode = head;
                MyNode<T> next = head.neighbor;
                for (int j = 0; j < size - 1 - i; j++) {
                    if ((int) currentMyNode.value > (int)next.value) {
                        T temp = currentMyNode.value;
                        currentMyNode.value = next.value;
                        next.value = temp;
                    }
                    currentMyNode = next;
                    next = next.neighbor;
                }
            }
        }
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        if(head == null){
            result = new StringBuilder("[]");
        } else {
            result.append("[");
            MyNode<T> actualMyNode = head;
            result.append(actualMyNode.value).append(", ");

            while (actualMyNode.neighbor != null){
                actualMyNode = actualMyNode.neighbor;
                result.append(actualMyNode.value).append(", ");
            }

            result = new StringBuilder(result.substring(0, result.length() - 2));
            result.append("]");
        }
        return result.toString();
    }
}