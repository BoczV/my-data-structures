package com.company.binarysearchtree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class MyTree {
    private MyNode root;
    private List<Integer> numberList;
    private List<Integer> usedNumbers;


    public MyTree(List<Integer> numberList) {
        this.numberList = new ArrayList<>();
        this.numberList.addAll(numberList);
        usedNumbers = new ArrayList<>();
        setTree();
    }

    public MyNode searchInTree(){
        return root;
    }

    private void setTree(){
        Collections.sort(numberList);
        int index = numberList.size() / 2;
        root = setNodeInTree(index);
    }

    private MyNode setNodeInTree(int index){
        String nodeName = String.valueOf(UUID.randomUUID());
        int nodeValue = numberList.get(index);
        usedNumbers.add(index);
        Integer nextLeftIndex = null;
        Integer nextRightIndex = null;

        if(numberList.subList(0, index).size() > 1){
            nextLeftIndex = index / 2;
        } else if(numberList.subList(0, index).size() > 0){
            nextLeftIndex = 0;
        }

        if(numberList.subList(index + 1, numberList.size()).size() > 1){
            nextRightIndex = numberList.size() - 1 - index / 2;
        } else if (numberList.subList(index + 1, numberList.size()).size() > 0){
            nextRightIndex = numberList.size() - 1;
        }

        if(nextLeftIndex != null && nextRightIndex != null && !usedNumbers.contains(nextLeftIndex) && !usedNumbers.contains(nextRightIndex)){
            return new MyNode(nodeValue, nodeName, setNodeInTree(nextLeftIndex), setNodeInTree(nextRightIndex));
        } else if (nextLeftIndex != null && !usedNumbers.contains(nextLeftIndex)){
            return new MyNode(nodeValue, nodeName, setNodeInTree(nextLeftIndex));
        } else if (nextRightIndex != null && !usedNumbers.contains(nextRightIndex)){
            return new MyNode(nodeValue, nodeName, setNodeInTree(nextRightIndex));
        } else {
            return new MyNode(nodeValue, nodeName);
        }
    }

    public MyNode getRoot() {
        return root;
    }

    public List<Integer> getNumberList() {
        return numberList;
    }
}
