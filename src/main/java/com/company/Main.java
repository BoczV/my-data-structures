package com.company;


import com.company.arraylist.MyArrayList;
import com.company.linkedlist.MyLinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(45);
        myLinkedList.add(2);
        myLinkedList.add(1);
        myLinkedList.add(3);
        myLinkedList.add(61);
        myLinkedList.add(8);
        myLinkedList.sort();
        System.out.println(myLinkedList);

    }
}
