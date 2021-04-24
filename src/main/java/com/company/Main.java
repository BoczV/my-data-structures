package com.company;


import com.company.arraylist.MyArrayList;
import com.company.linkedlist.MyLinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        MyLinkedList<Integer> myIntegerLinkedList = new MyLinkedList<>();
        myIntegerLinkedList.add(45);
        myIntegerLinkedList.add(61);
        myIntegerLinkedList.add(3);
        myIntegerLinkedList.add(1);
        myIntegerLinkedList.add(8);
        myIntegerLinkedList.add(2);
        myIntegerLinkedList.sort();
        System.out.println(myIntegerLinkedList);
    }
}
