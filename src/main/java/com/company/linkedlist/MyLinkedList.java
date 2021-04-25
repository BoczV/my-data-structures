package com.company.linkedlist;


import com.company.interfaces.MyList;

import java.util.Collection;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements MyList<T> {
    private Node<T> head;

    private static class Node<T> {

        private T value;
        private Node<T> neighbor;

        private Node(T value) {
            this.value = value;
        }

    }

    public void add(T value){
        Node<T> newNode = new Node<>(value);
        if(head == null) head = newNode;
        else {
            Node<T> actualNode = head;
            while (actualNode.neighbor != null) actualNode = actualNode.neighbor;
            actualNode.neighbor = newNode;
        }
    }

    public void addAll(Collection<T> list){
        Object[] newElements = list.toArray();
        boolean headIsnull = head == null;
        head = headIsnull? new Node<>((T)newElements[0]): head;
        Node<T> actualNode = head;
        while (actualNode.neighbor != null) actualNode = actualNode.neighbor;
        for (int i = headIsnull? 1:0; i < list.size(); i++) {
            Node<T> newNode = new Node<>((T)newElements[i]);
            actualNode.neighbor = newNode;
            actualNode = newNode;
        }
    }

    public void addAll(T[] array){
        boolean headIsnull = head == null;
        head = headIsnull? new Node<>(array[0]): head;
        Node<T> actualNode = head;
        while (actualNode.neighbor != null) actualNode = actualNode.neighbor;
        for (int i = headIsnull? 1:0; i < array.length; i++) {
            Node<T> newNode = new Node<>(array[i]);
            actualNode.neighbor = newNode;
            actualNode = newNode;
        }
    }

    public Object remove(T value){
        T result;
        if(head == null) return null;
        else {
            Node<T> actualNode = head;
            Node<T> previousNode;
            Node<T> nextNode = actualNode.neighbor;
            if(value.getClass().equals(String.class)) result = actualNode.value.equals(value)? actualNode.value: null;
            else result = actualNode.value == value? actualNode.value: null;
            if(result != null) {
                head = nextNode;
            } else {
                while (actualNode.neighbor != null){
                    previousNode = actualNode;
                    actualNode = actualNode.neighbor;
                    nextNode = actualNode.neighbor;
                    if(value.getClass().equals(String.class)) result = actualNode.value.equals(value)? actualNode.value: null;
                    else result = actualNode.value == value? actualNode.value: null;
                    if(result != null){
                        previousNode.neighbor = nextNode;
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
            Node<T> actualNode = head;
            Node<T> previousNode;
            Node<T> nextNode = actualNode.neighbor;
            if(counter == index) {
                result = head.value;
                head = nextNode;
            } else {
                while (actualNode.neighbor != null){
                    counter++;
                    previousNode = actualNode;
                    actualNode = actualNode.neighbor;
                    nextNode = actualNode.neighbor;
                    result = counter == index? actualNode.value: null;
                    if(result != null){
                        previousNode.neighbor = nextNode;
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
      Node<T> actualNode = head;
      result = counter == index? actualNode.value: null;
      if(result == null){
          while (actualNode.neighbor != null){
              counter++;
              actualNode = actualNode.neighbor;
              result = counter == index? actualNode.value: null;
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
        Node<T> actualNode = head;
        result = actualNode.value == value;
        while (actualNode.neighbor != null){
            actualNode = actualNode.neighbor;
            result = actualNode.value == value;
            if(result) break;
        }
        return result;
    }

    public void insert(int index, T value){
        boolean change = false;
        int counter = 0;
        Node<T> newNode = new Node<>(value);
        Node<T> previousNode;
        if(counter == index){
            previousNode = head;
            newNode.neighbor = previousNode;
            head = newNode;
        } else {
            Node<T> actualNode = head;
            while (actualNode.neighbor != null){
                previousNode = actualNode;
                actualNode = actualNode.neighbor;
                counter++;
                if(counter == index){
                    previousNode.neighbor = newNode;
                    newNode.neighbor = actualNode;
                    change = true;
                    break;
                }
            }
            if(++counter == index && !change){
                actualNode.neighbor = newNode;
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
            Node<T> actualNode = head;
            counter++;
            while (actualNode.neighbor != null) {
                counter++;
                actualNode = actualNode.neighbor;
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
            Node<T> actualNode = head;
            while (actualNode != null) {
                array[counter] = actualNode.value;
                actualNode = actualNode.neighbor;
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
                Node<T> currentNode = head;
                Node<T> next = head.neighbor;
                for (int j = 0; j < size - 1 - i; j++) {
                    if ((int)currentNode.value > (int)next.value) {
                        T temp = currentNode.value;
                        currentNode.value = next.value;
                        next.value = temp;
                    }
                    currentNode = next;
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
            Node<T> actualNode = head;
            result.append(actualNode.value).append(", ");

            while (actualNode.neighbor != null){
                actualNode = actualNode.neighbor;
                result.append(actualNode.value).append(", ");
            }

            result = new StringBuilder(result.substring(0, result.length() - 2));
            result.append("]");
        }
        return result.toString();
    }
}