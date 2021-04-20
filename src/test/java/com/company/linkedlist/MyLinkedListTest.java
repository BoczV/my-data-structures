package com.company.linkedlist;


import org.junit.jupiter.api.Assertions;

class MyLinkedListTest {

    private MyLinkedList<Integer> myIntegerLinkedList;
    private MyLinkedList<String> myStringLinkedList;
    private String[] stringArray;
    private Integer[] intArray;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        myIntegerLinkedList = new MyLinkedList<>();
        myStringLinkedList = new MyLinkedList<>();
        stringArray = new String[]{"Pear", "Cherry"};
        intArray = new Integer[]{3, 1, 8, 2};
    }

    @org.junit.jupiter.api.Test
    void add() {
        myIntegerLinkedList.add(5);
        myIntegerLinkedList.add(1);
        myStringLinkedList.add("Alma");
        Assertions.assertEquals(2, myIntegerLinkedList.size());
        Assertions.assertEquals(1, myStringLinkedList.size());
    }

    @org.junit.jupiter.api.Test
    void addAllArrayElement() {
        myIntegerLinkedList.addAll(intArray);
        myStringLinkedList.addAll(stringArray);
        Assertions.assertEquals("[3, 1, 8, 2]", myIntegerLinkedList.toString());
        Assertions.assertEquals("[Pear, Cherry]", myStringLinkedList.toString());
    }

    @org.junit.jupiter.api.Test
    void addAllCollectionElement() {
    }

    @org.junit.jupiter.api.Test
    void removeById() {
    }

    @org.junit.jupiter.api.Test
    void removeByElement() {
    }

    @org.junit.jupiter.api.Test
    void get() {
    }

    @org.junit.jupiter.api.Test
    void contains() {
    }

    @org.junit.jupiter.api.Test
    void insert() {
    }

    @org.junit.jupiter.api.Test
    void getFirst() {
    }

    @org.junit.jupiter.api.Test
    void size() {
    }

    @org.junit.jupiter.api.Test
    void clear() {
    }

    @org.junit.jupiter.api.Test
    void toArray() {
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
    }

    @org.junit.jupiter.api.Test
    void sort() {
    }
}