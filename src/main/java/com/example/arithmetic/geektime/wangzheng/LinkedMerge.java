package com.example.arithmetic.geektime.wangzheng;

import java.sql.SQLOutput;

/**
 * 两个有序链表的合并
 * 单链表
 * <p>
 * <p>
 * 判断是否有链表为空：如果l1为空，则不用比较直接返回l2，如果l1为空，则直接返回l2；
 * 比较l1和l2节点，选出最小的那个节点，将该节点设为合并后的链表的head(头)节点，同时将指向该节点的l1或l2后移，方便接下来的比较；
 * 设置一个变量temp指向head节点，用于之后连接其它节点；
 * 再比较l1和l2节点，同样选出小的那个节点，将该节点设为合并后的链表的第二个节点，用temp.next表示该节点，同时将指向该节点的l1或l2后移；
 * 重复比较l1和l2节点，直到l1或l2节点为null；
 * 此时，必定有一个链表中的所有节点都放入了新链表中，只要将另一个链表中的剩余的所有节点都接到新链表之后就可以了。
 * ---------------------
 * 作者：zhuminChosen
 * 来源：CSDN
 * 原文：https://blog.csdn.net/zm13007310400/article/details/78317821?utm_source=copy
 * 版权声明：本文为博主原创文章，转载请附上博文链接！
 */
public class LinkedMerge {

    public static SingleNode merge(SingleNode head1, SingleNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        SingleNode head;
        if (head1.getData() <= head2.getData()) {
            head = head1;
            head1 = head1.getNext();
        } else {
            head = head2;
            head2 = head2.getNext();
        }
        SingleNode temp = head;
        while (head1 != null && head2 != null) {
            if (head1.getData() <= head2.getData()) {
                temp.setNext(head1);
                head1 = head1.getNext();
            } else {
                temp.setNext(head2);
                head2 = head2.getNext();
            }
            temp = temp.getNext();
        }
        if (head1 == null) {
            temp.setNext(head2);
        }
        if (head2 == null) {
            temp.setNext(head1);
        }


        return head;
    }

    public static void main(String[] args) {
        SingleNode head1 = new SingleNode(1);
        SingleNode head2 = new SingleNode(2);
        SingleNode node3 = new SingleNode(3);
        SingleNode node4 = new SingleNode(4);
        head1.setNext(node3);
        head2.setNext(node4);

        SingleNode node5 = new SingleNode(5);
        SingleNode node6 = new SingleNode(6);
        node3.setNext(node5);
        node4.setNext(node6);
        SingleNode node7 = new SingleNode(7);
        node5.setNext(node7);

        SingleNode temp1 = head1;
        System.out.println("******111111********");
        while (temp1 != null) {
            System.out.println(temp1.getData());
            temp1 = temp1.getNext();
        }

        SingleNode temp2 = head2;
        System.out.println("******222222********");
        while (temp2 != null) {
            System.out.println(temp2.getData());
            temp2 = temp2.getNext();
        }

        System.out.println("******mmmmm********");
        SingleNode merge = merge(head1, head2);
        SingleNode temp = merge;
        while (temp != null) {
            System.out.println(temp.getData());
            temp = temp.getNext();
        }

        System.out.println("-------------------");
        SingleNode singleNode = new SingleNode(5);
        SingleNode test = singleNode;
        test.setData(1);
        System.out.println(singleNode.getData());
        System.out.println(test.getData());


    }

}
