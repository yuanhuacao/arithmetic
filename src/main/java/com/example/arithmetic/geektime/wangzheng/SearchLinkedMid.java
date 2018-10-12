package com.example.arithmetic.geektime.wangzheng;

/**
 * 寻找单链表的中间节点
 * <p>
 * 解决方法：设置两个指针，一个快指针，每次走两步，一个慢指针，每次走一步。
 */
public class SearchLinkedMid {

    public static SingleNode searchMid(SingleNode head) {
        if (head == null) {
            return null;
        }
        SingleNode slow = head;
        SingleNode fast = head;
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }

    public static void main(String[] args) {

        SingleNode head = new SingleNode(1);
        SingleNode node1 = new SingleNode(2);
        SingleNode node2 = new SingleNode(3);
        SingleNode node3 = new SingleNode(4);
        SingleNode node4 = new SingleNode(5);
        SingleNode node5 = new SingleNode(6);
        SingleNode node6 = new SingleNode(7);

        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        SingleNode h = head;
        while (h != null) {
            System.out.println(h.getData());
            h = h.getNext();

        }
        System.out.println("*****************");
        SingleNode reHead = searchMid(head);
        System.out.println(reHead.getData());

    }
}
