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
    public void insert(int iData,double dData )
    {
        //创建node节点
        Node newNode=new Node();
        newNode.iData=iData;
        newNode.dData=dData;
        //判断root node是否为null
        if(root==null)
        {
            root=newNode;
        }
        //不为null
        else
        {
            Node current=root;
            Node parent;
            while(true)
            {
                parent=current;//保存当current变为null之前的那一个父节点
                if(iData<current.iData)//插入左节点
                {
                    current=current.leftNode;//不断向左node寻找是否为null
                    if(current==null)
                    {
                        parent.leftNode=newNode;
                        return;
                    }

                }
                //插入右节点
                else
                {
                    current=current.rightNode;
                    if(current==null)
                    {
                        parent.rightNode=newNode;
                        return;
                    }
                }

            }

        }
    }

    public static void main(String[] args) {
        BTree b=new BTree();
        b.insert(3,3.1);
        b.insert(1,1.1);
        b.insert(2,1.1);
        b.insert(4,1.1);
        b.insert(5,1.1);
        b.insert(6,1.1);
        System.out.println(JSON.toJSONString(b.root));

    }
}
