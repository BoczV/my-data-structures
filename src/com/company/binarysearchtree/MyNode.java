package com.company.binarysearchtree;

public class MyNode {
    private int nodeValue;
    private String nodeName;
    private MyNode leftNode;
    private MyNode rightNode;

    public MyNode(int nodeValue, String nodeName, MyNode leftNode, MyNode rightNode) {
        this.nodeValue = nodeValue;
        this.nodeName = nodeName;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public MyNode(int nodeValue, String nodeName, MyNode neighborNode) {
        this.nodeValue = nodeValue;
        this.nodeName = nodeName;
        if(neighborNode.getNodeValue() > nodeValue) rightNode = neighborNode;
        else leftNode = neighborNode;
    }

    public MyNode(int nodeValue, String nodeName) {
        this.nodeValue = nodeValue;
        this.nodeName = nodeName;
    }

    public int getNodeValue() {
        return nodeValue;
    }

    public String getNodeName() {
        return nodeName;
    }

    public MyNode getLeftNode() {
        return leftNode;
    }

    public MyNode getRightNode() {
        return rightNode;
    }
}
