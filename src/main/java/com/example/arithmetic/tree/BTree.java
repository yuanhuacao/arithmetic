package com.example.arithmetic.tree;

import com.alibaba.fastjson.JSON;
import jdk.nashorn.internal.runtime.JSONFunctions;

/**
 * 二叉树
 * 二叉树性质:
 * 性质1：二叉树第i层上的结点数目最多为有2^(i-1)(i>=1)
 *
 * 性质2：深度为k的二叉树至多有2^k-1个结点（k>=1）
 *
 * 性质3：包含n个结点的二叉树的高度至少为(log2n)+1
 *
 * 性质4：在任意一棵二叉树中，若终端结点的个数为n0，度为2的结点数为n2，则n0=n2+1
 *
 * 证明：因为二叉树中所有结点的度数均不大于2，不妨设n0表示度为0的结点个数，
 * n1表示度为1的结点个数，n2表示度为2的结点个数。三类结点加起来为总结点个数，于是便可得到：n=n0+n1+n2 (1)
 * 由度之间的关系可得第二个等式：n=n0*0+n1*1+n2*2+1即n=n1+2n2+1 (2)
 * 将（1）（2）组合在一起可得到n0=n2+1
 * n0=n2+1;
 * n0*0+n1*1+n2*2=n
 *
 *
 *
 *
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

    public Node find(int key) {
        Node curNode = root;
        while (curNode.iData != key) {
            if (key < curNode.iData) {
                curNode = curNode.leftNode;
            } else {
                curNode = curNode.rightNode;
            }
        }
        return curNode;
    }

    public Node min() {
        Node curNode = root;
        while (curNode.leftNode != null) {
            curNode = curNode.leftNode;
        }
        return curNode;
    }

    public Node max() {
        Node curNode = root;
        while (curNode.rightNode != null) {
            curNode = curNode.rightNode;
        }
        return curNode;
    }

    public static void main(String[] args) {
        BTree b = new BTree();
        // 3, 2, 1, 4, 5, 6, 7, 10, 9, 8
        b.insert(3);
        b.insert(2);
        b.insert(1);
        b.insert(4);
        b.insert(5);
        b.insert(6);
        b.insert(7);
        b.insert(10);
        b.insert(9);
        b.insert(8);
        System.out.println(JSON.toJSONString(b.root));
        System.out.println(b.find(3).iData);
        System.out.println(b.min().iData);
        System.out.println(b.max().iData);

    }
}
