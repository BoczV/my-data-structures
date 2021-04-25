package com.company.linkedlist;


import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MyLinkedListTest {

    private MyLinkedList<Integer> myIntegerLinkedList;
    private MyLinkedList<String> myStringLinkedList;
    private String[] stringArray;
    private Integer[] intArray;
    private List<String> stringList;
    private List<Integer> intList;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        myIntegerLinkedList = new MyLinkedList<>();
        myStringLinkedList = new MyLinkedList<>();
        stringArray = new String[]{"Pear", "Cherry"};
        intArray = new Integer[]{3, 1, 8, 2};
        intList = new ArrayList<>(Arrays.asList(45, 61));
        stringList = new ArrayList<>(Arrays.asList("Peach", "Banana"));
    }

    @org.junit.jupiter.api.Test
    void add() {
        myIntegerLinkedList.add(5);
        myIntegerLinkedList.add(1);
        myStringLinkedList.add("Alma");
        Assertions.assertEquals("[5, 1]", myIntegerLinkedList.toString());
        Assertions.assertEquals("[Alma]", myStringLinkedList.toString());
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
        myIntegerLinkedList.addAll(intList);
        myStringLinkedList.addAll(stringList);
        Assertions.assertEquals("[45, 61]", myIntegerLinkedList.toString());
        Assertions.assertEquals("[Peach, Banana]", myStringLinkedList.toString());
    }

    @org.junit.jupiter.api.Test
    void removeById() {
        myIntegerLinkedList.addAll(intList);
        myStringLinkedList.addAll(stringList);
        myIntegerLinkedList.remove(0);
        myStringLinkedList.remove(1);
        Assertions.assertEquals("[61]", myIntegerLinkedList.toString());
        Assertions.assertEquals("[Peach]", myStringLinkedList.toString());
    }

    @org.junit.jupiter.api.Test
    void removeByElement() {
        myIntegerLinkedList.addAll(intArray);
        myStringLinkedList.addAll(stringArray);
        myIntegerLinkedList.remove((Integer) 2);
        myStringLinkedList.remove("Pear");
        Assertions.assertEquals("[3, 1, 8]", myIntegerLinkedList.toString());
        Assertions.assertEquals("[Cherry]", myStringLinkedList.toString());
    }

    @org.junit.jupiter.api.Test
    void get() {
        myIntegerLinkedList.addAll(intArray);
        myStringLinkedList.addAll(stringArray);
        myIntegerLinkedList.addAll(intList);
        myStringLinkedList.addAll(stringList);
        Assertions.assertEquals(45, myIntegerLinkedList.get(4));
        Assertions.assertEquals("Peach", myStringLinkedList.get(2));
    }

    @org.junit.jupiter.api.Test
    void contains() {
        myIntegerLinkedList.addAll(intArray);
        myStringLinkedList.addAll(stringArray);
        myIntegerLinkedList.addAll(intList);
        myStringLinkedList.addAll(stringList);
        Assertions.assertFalse(myIntegerLinkedList.contains(44));
        Assertions.assertTrue(myStringLinkedList.contains("Cherry"));
    }

    @org.junit.jupiter.api.Test
    void insert() {
        myIntegerLinkedList.addAll(intArray);
        myStringLinkedList.addAll(stringArray);
        myIntegerLinkedList.insert(2, 1);
        myStringLinkedList.insert(1, "Plume");
        Assertions.assertEquals("[3, 1, 1, 8, 2]", myIntegerLinkedList.toString());
        Assertions.assertEquals("[Pear, Plume, Cherry]", myStringLinkedList.toString());
    }

    @org.junit.jupiter.api.Test
    void getFirst() {
        myIntegerLinkedList.addAll(intList);
        myStringLinkedList.addAll(stringList);
        myIntegerLinkedList.addAll(intArray);
        myStringLinkedList.addAll(stringArray);
        Assertions.assertEquals("Peach", myStringLinkedList.getFirst());
        Assertions.assertEquals(45, myIntegerLinkedList.getFirst());
    }

    @org.junit.jupiter.api.Test
    void size() {
        myIntegerLinkedList.add(5);
        myIntegerLinkedList.add(1);
        myStringLinkedList.add("Alma");
        Assertions.assertEquals(2, myIntegerLinkedList.size());
        Assertions.assertEquals(1, myStringLinkedList.size());
    }

    @org.junit.jupiter.api.Test
    void clear() {
        myIntegerLinkedList.add(5);
        myIntegerLinkedList.add(1);
        myStringLinkedList.add("Alma");
        myIntegerLinkedList.clear();
        myStringLinkedList.clear();
        Assertions.assertEquals("[]", myStringLinkedList.toString());
        Assertions.assertEquals("[]", myIntegerLinkedList.toString());
    }

    @org.junit.jupiter.api.Test
    void toArray() {
        myIntegerLinkedList.add(5);
        myIntegerLinkedList.add(1);
        myStringLinkedList.add("Alma");
        Assertions.assertArrayEquals(new Integer[]{5, 1}, myIntegerLinkedList.toArray());
        Assertions.assertArrayEquals(new String[]{"Alma"}, myStringLinkedList.toArray());
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        myStringLinkedList.add("Alma");
        Assertions.assertFalse(myStringLinkedList.isEmpty());
        Assertions.assertTrue(myIntegerLinkedList.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void sort() {
        myIntegerLinkedList.addAll(intList);
        myIntegerLinkedList.add(7);
        myIntegerLinkedList.addAll(intArray);
        myIntegerLinkedList.sort();
        Assertions.assertEquals("[1, 2, 3, 7, 8, 45, 61]", myIntegerLinkedList.toString());
    }
}