package com.example.arithmetic.geektime.wangzheng;

/**
 * 删除链表倒数第N个节点
 * 单链表
 */
public class RemoveNthLiknedNode {

    public static SingleNode removeNthNode(SingleNode head, int n) {

        SingleNode dummy = new SingleNode(-1);
        if (head == null) {
            return head;
        }
        dummy.setNext(head);
        SingleNode front = dummy;
        SingleNode tail = dummy;
        int num = 0;
        while (front != null && num <= n) {
            front = front.getNext();
            num++;
        }
        while (front != null) {
            front = front.getNext();
            tail = tail.getNext();
        }

        tail.setNext(tail.getNext().getNext());
        return dummy.getNext();
    }

    public static void main(String[] args) {


        {
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
            SingleNode reHead = removeNthNode(head, 1);
            while (reHead != null) {
                System.out.println(reHead.getData());
                reHead = reHead.getNext();

            }
        }
    }

}
