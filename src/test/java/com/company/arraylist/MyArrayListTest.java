package com.company.arraylist;

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
        myIntegerArrayList.addAll(intArray);
        myStringArrayList.addAll(stringArray);
        myIntegerArrayList.insert(2, 1);
        myStringArrayList.insert(1, "Plume");
        Assertions.assertEquals("[3, 1, 1, 8, 2]", myIntegerArrayList.toString());
        Assertions.assertEquals("[Pear, Plume, Cherry]", myStringArrayList.toString());
    }

    @Test
    void removeById() {
        myIntegerArrayList.addAll(intList);
        myStringArrayList.addAll(stringList);
        myIntegerArrayList.remove(0);
        myStringArrayList.remove(1);
        Assertions.assertEquals("[61]", myIntegerArrayList.toString());
        Assertions.assertEquals("[Peach]", myStringArrayList.toString());
    }

    @Test
    void removeByElement() {
        myIntegerArrayList.addAll(intArray);
        myStringArrayList.addAll(stringArray);
        myIntegerArrayList.remove((Integer) 2);
        myStringArrayList.remove("Pear");
        Assertions.assertEquals("[3, 1, 8]", myIntegerArrayList.toString());
        Assertions.assertEquals("[Cherry]", myStringArrayList.toString());
    }

    @Test
    void contains() {
        myIntegerArrayList.addAll(intArray);
        myStringArrayList.addAll(stringArray);
        myIntegerArrayList.addAll(intList);
        myStringArrayList.addAll(stringList);
        Assertions.assertFalse(myIntegerArrayList.contains(44));
        Assertions.assertTrue(myStringArrayList.contains("Cherry"));
    }

    @Test
    void isEmpty() {
        myStringArrayList.add("Alma");
        Assertions.assertFalse(myStringArrayList.isEmpty());
        Assertions.assertTrue(myIntegerArrayList.isEmpty());
    }

    @Test
    void size() {
        myIntegerArrayList.add(5);
        myIntegerArrayList.add(1);
        myStringArrayList.add("Alma");
        Assertions.assertEquals(2, myIntegerArrayList.size());
        Assertions.assertEquals(1, myStringArrayList.size());
    }

    @Test
    void clear() {
        myIntegerArrayList.add(5);
        myIntegerArrayList.add(1);
        myStringArrayList.add("Alma");
        myIntegerArrayList.clear();
        myStringArrayList.clear();
        Assertions.assertEquals("[]", myStringArrayList.toString());
        Assertions.assertEquals("[]", myIntegerArrayList.toString());
    }

    @Test
    void toArray() {
        myIntegerArrayList.add(5);
        myIntegerArrayList.add(1);
        myStringArrayList.add("Alma");
        Assertions.assertArrayEquals(new Integer[]{5, 1}, myIntegerArrayList.toArray());
        Assertions.assertArrayEquals(new String[]{"Alma"}, myStringArrayList.toArray());
    }

    @Test
    void getFirst() {
        myIntegerArrayList.addAll(intList);
        myStringArrayList.addAll(stringList);
        myIntegerArrayList.addAll(intArray);
        myStringArrayList.addAll(stringArray);
        Assertions.assertEquals("Peach", myStringArrayList.getFirst());
        Assertions.assertEquals(45, myIntegerArrayList.getFirst());
    }

    @Test
    void get() {
        myIntegerArrayList.addAll(intArray);
        myStringArrayList.addAll(stringArray);
        myIntegerArrayList.addAll(intList);
        myStringArrayList.addAll(stringList);
        Assertions.assertEquals(45, myIntegerArrayList.get(4));
        Assertions.assertEquals("Peach", myStringArrayList.get(2));
    }

    @Test
    void sort() {
        myIntegerArrayList.addAll(intList);
        myIntegerArrayList.addAll(intArray);
        myIntegerArrayList.sort();
        Assertions.assertEquals("[1, 2, 3, 8, 45, 61]", myIntegerArrayList.toString());
    }
}