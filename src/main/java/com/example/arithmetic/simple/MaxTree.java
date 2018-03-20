package com.example.arithmetic.simple;


import java.util.*;

/**
 * 数组最大二叉树问题
 * 父节点取左边第一个比自己大的值和右边第一个比自己大的值中的教小的那个
 */

public class MaxTree {
    public Node getMaxTree(int[] arr) {
        Node[] nArr = new Node[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nArr[i] = new Node(arr[i]);
        }
        Stack<Node> stack = new Stack<>();
        HashMap<Node, Node> lBigMap = new HashMap<>();
        HashMap<Node, Node> rBigMap = new HashMap<>();
        for (int i = 0; i < nArr.length; i++) {
            Node curNode = nArr[i];
            while (!stack.isEmpty() && (stack.peek().value < curNode.value)) {
                popStackSetMap(stack, lBigMap);
            }
            stack.push(curNode);
        }
        while (!stack.isEmpty()) {
            popStackSetMap(stack, lBigMap);
        }
        for (int i = nArr.length - 1; i < -1; i--) {
            Node curNode = nArr[i];
            while (!stack.isEmpty() && (stack.peek().value < curNode.value)) {
                popStackSetMap(stack, rBigMap);
            }
            stack.push(curNode);
        }
        while (!stack.isEmpty()) {
            popStackSetMap(stack, rBigMap);
        }
        Node head = null;
        for (int i = 0; i < nArr.length; i++) {
            Node curNode = nArr[i];
            Node left = lBigMap.get(curNode);
            Node right = rBigMap.get(curNode);
            if (left == null && right == null) {
                head = curNode;
            } else if (left == null) {
                if (right.left == null) {
                    right.left = curNode;
                } else {
                    right.right = curNode;
                }
            } else  if(right==null){
                if (left.left==null){
                    left.left=curNode;
                }else {
                    left.right=curNode;
                }
            }
            else {
                Node parent = left.value < right.value ? left : right;
                if (parent.left == null) {
                    parent.left = curNode;
                } else {
                    parent.right = curNode;
                }
            }
        }
        return head;
    }

    public void popStackSetMap(Stack<Node> stack, HashMap<Node, Node> map) {
        Node popNode = stack.pop();
        if (stack.isEmpty()) {
            map.put(popNode, null);
        } else {
            map.put(popNode, stack.peek());
        }
    }

    public static void main(String[] args) {
        int arr[] = {3,4,5,1,2};
        MaxTree maxTree = new MaxTree();
        Node head = maxTree.getMaxTree(arr);
        System.out.println(head.toString());
    }


}
