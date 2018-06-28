package com.example.arithmetic.tree;

import com.alibaba.fastjson.JSON;
import jdk.nashorn.internal.runtime.JSONFunctions;

/**
 * 二叉树
 */
public class BTree {

    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    //插入Node
    //插入之前需要判断是否为null
    //为null需要比较大小直到currentNode为null就插入
    public void insert(int iData) {
        Node newNode = new Node(iData);
        if (root == null) {
            root = newNode;
        } else {
            Node curentNode = root;
            Node parentNode;
            while (true) {
                parentNode = curentNode;
                if (iData < curentNode.iData) {
                    curentNode = curentNode.leftNode;
                    if (curentNode == null) {
                        parentNode.leftNode = newNode;
                        return;
                    }
                } else {
                    curentNode = curentNode.rightNode;
                    if (curentNode == null) {
                        parentNode.rightNode = newNode;
                        return;
                    }
                }
            }

        }
    }
    public Node find(int key){
        Node curNode=root;
        while (curNode.iData!=key){
            if (key<curNode.iData){
                curNode=curNode.leftNode;
            }else {
                curNode=curNode.rightNode;
            }
        }
        return  curNode;

    }

    public static void main(String[] args) {
        BTree b = new BTree();
        b.insert(6);
        b.insert(5);
        b.insert(4);
        b.insert(3);
        b.insert(2);
        b.insert(1);
        System.out.println(JSON.toJSONString(b.root));
        System.out.println(b.find(3).iData);

    }
}
