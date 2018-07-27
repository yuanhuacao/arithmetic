package com.example.arithmetic.tree;

public class Node {
    public int iData;

    public Node leftNode;

    public Node rightNode;

    public Node(int iData) {
        this.iData = iData;
    }

    public int getiData() {
        return iData;
    }

    public void setiData(int iData) {
        this.iData = iData;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }
//
    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    @Override
    public String toString() {
        return "Node{" +
                "iData=" + iData +
                ", leftNode=" + leftNode +
                ", rightNode=" + rightNode +
                '}';
    }
}
