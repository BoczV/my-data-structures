package com.company.arraylist;

import com.company.linkedlist.MyLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class MyArrayListTest {
    private MyArrayList<Integer> myIntegerArrayList;
    private MyArrayList<String> myStringArrayList;
    private String[] stringArray;
    private Integer[] intArray;
    private List<String> stringList;
    private List<Integer> intList;

    @BeforeEach
    void setUp() {
        myIntegerArrayList = new MyArrayList<>();
        myStringArrayList = new MyArrayList<>();
        stringArray = new String[]{"Pear", "Cherry"};
        intArray = new Integer[]{3, 1, 8, 2};
        intList = new ArrayList<>(Arrays.asList(45, 61));
        stringList = new ArrayList<>(Arrays.asList("Peach", "Banana"));
    }

    @Test
    void add() {
        myIntegerArrayList.add(5);
        myIntegerArrayList.add(1);
        myStringArrayList.add("Alma");
        Assertions.assertEquals("[5, 1]", myIntegerArrayList.toString());
        Assertions.assertEquals("[Alma]", myStringArrayList.toString());
    }

    @Test
    void addAllArrayElement() {
        myIntegerArrayList.addAll(intArray);
        myStringArrayList.addAll(stringArray);
        Assertions.assertEquals("[3, 1, 8, 2]", myIntegerArrayList.toString());
        Assertions.assertEquals("[Pear, Cherry]", myStringArrayList.toString());
    }

    @Test
    void addAllCollectionElement() {
        myIntegerArrayList.addAll(intList);
        myStringArrayList.addAll(stringList);
        Assertions.assertEquals("[45, 61]", myIntegerArrayList.toString());
        Assertions.assertEquals("[Peach, Banana]", myStringArrayList.toString());
    }

    @Test
    void insert() {
    }

    @Test
    void removeById() {
    }

    @Test
    void removeByElement() {
    }

    @Test
    void contains() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void size() {
    }

    @Test
    void clear() {
    }

    @Test
    void toArray() {
    }

    @Test
    void getFirst() {
    }

    @Test
    void get() {
    }

    @Test
    void sort() {
    }
}