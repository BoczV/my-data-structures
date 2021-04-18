package com.company;


import com.company.arraylist.MyArrayList;

public class Main {

    public static void main(String[] args) {
        /* MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(3);
        myLinkedList.add(1);
        myLinkedList.add(210);
        myLinkedList.add(111);
        myLinkedList.add(5);
        System.out.println(myLinkedList);
        myLinkedList.sort();
        System.out.println(myLinkedList);
        myLinkedList.insert(3, 1);
        System.out.println(myLinkedList);
        myLinkedList.sort();
        System.out.println(myLinkedList);*/
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(3);
        myArrayList.add(2);
        myArrayList.add(1);
        myArrayList.add(5);
        myArrayList.add(4);
        myArrayList.sort();
        System.out.println(myArrayList);
    }
}
