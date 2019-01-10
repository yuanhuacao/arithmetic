package com.example.arithmetic.geektime.wangzheng;

import java.security.Signature;

/**
 * 单链表反转
 */
public class ReverseLinkedList {


    /**
     * 递归反转
     *
     * @param head
     */
    public static SingleNode reverse(SingleNode head) {
       if (head==null||head.getNext()==null){
           return  head;
       }
       SingleNode reHead=reverse(head.getNext());
       head.getNext().setNext(head);
       head.setNext(null);
       return  reHead;

    }

    /**
     * 循环反转
     *
     * @param head
     */
    public static SingleNode reverse2(SingleNode head) {
        if (head==null){
            return  head;
        }
        SingleNode pre=head;
        SingleNode cur=head.getNext();
        SingleNode temp;
        while (cur!=null){
            temp=cur.getNext();
            cur.setNext(pre);
            pre=cur;
            cur=temp;
        }
        head.setNext(null);
        return  pre;

    }

    public static void main(String[] args) {
        SingleNode head = new SingleNode(0);
        SingleNode node1 = new SingleNode(1);
        SingleNode node2 = new SingleNode(2);
        SingleNode node3 = new SingleNode(3);
        SingleNode node4 = new SingleNode(4);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        SingleNode h = head;
        while (h != null) {
            System.out.println(h.getData());
            h = h.getNext();

        }
        System.out.println("*****************");
        SingleNode reHead = reverse2(head);
        while (reHead != null) {
            System.out.println(reHead.getData());
            reHead = reHead.getNext();

        }
    }

}
