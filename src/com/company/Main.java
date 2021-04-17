package com.company;


import com.company.arraylist.MyArrayList;
import com.company.linkedlist.MyLinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.add("Hi!");
        myArrayList.add("Nice");
        myArrayList.add("to");
        myArrayList.add("see");
        myArrayList.add("you");
        System.out.println(myArrayList);
        myArrayList.addAll(new String[]{"Bye", "Bye", "Life"});
        System.out.println(myArrayList);
        List<String> al = new ArrayList<>();
        al.add("Hi!");
        al.add("nice");
        al.add("to");
        myArrayList.addAll(al);
        System.out.println(myArrayList);
        myArrayList.remove("Hi!");
        System.out.println(myArrayList);
        myArrayList.remove(2);
        System.out.println(myArrayList);
        System.out.println(myArrayList.get(3));
        System.out.println(myArrayList.getFirst());
    }
}
