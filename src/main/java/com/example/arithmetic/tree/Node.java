package com.example.arithmetic.tree;

public class Node {
    public  int iData;

    public  double dData;

    public  Node leftNode;

    public  Node rightNode;

    public void show(){
        System.out.println(
                "{"+iData+","+dData+"}"
        );
    }

}
