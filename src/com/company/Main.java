package com.company;



public class Main {

    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
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
        System.out.println(myLinkedList);
    }
}
