package com.example.arithmetic.geektime.wangzheng;

import com.example.arithmetic.simple.Node;

/**
 * 检测单链表中是否存在环
 * 返回环的入口
 * <p>
 * 1）选择快慢指针，让快指针每次走两步，慢指针每次走一步，若是单链表中有环的话，那么两个指针会相遇，即指向的相同的节点的值相等来判断。
 * 2）当相遇的时候，慢指针在环中走了k步，设环之外的部分长为x,环的长度为n,则快指针一共走了 x+m*n步，（m为快指针在环中走的圈数），
 * 慢指针一共走了x+k步，因为快指针的速度是慢指针的两倍。那么可以得到2(x+k)=x+m*n+k;得到x为m*n-k
 * ,慢指针在圈中还剩下的步数n-k;
 * 二、
 * 让快指针从头开始，两个指针每次都走一步，当快指针走了x(m*n-k)步的时候，到达环的入口，慢指针在圈中走m-1圈加k步的时候，
 * 也到达环入口那个节点，两个指针再次相遇，此刻的节点就是环的入口的节点。
 * <p>
 * （1）环的长度、（2）整个链表的长度、（3）两个无环链表第一次相交的公共节点
 * （1）环的长度，当快慢指针第一次相遇的时候，把该节点保存下来，让慢指针接着走，当再次到达刚才相遇的节点时所走过的步数就是环的长度。
 * （2）利用第二步求出环以外的长度再加上环的长度，就是整个链表的长度
 * （3）先分别求出两个链表的长度，让长的链表先走两个链表长度差的步数，再让两个链表一起走，当走到节点值相同的那个节点时，
 * 就是相交的第一个公共节点。
 * <p>
 * <p>
 * ---------------------
 * 作者：snow_7
 * 来源：CSDN
 * 原文：https://blog.csdn.net/snow_7/article/details/52181049?utm_source=copy
 * 版权声明：本文为博主原创文章，转载请附上博文链接！
 */
public class Solution {

    public static SingleNode loop(SingleNode pHead) {
        if (pHead == null || pHead.getNext() == null) {
            return null;
        }
        SingleNode fast = pHead;//快指针每次走两步
        SingleNode slow = pHead;//每次走一步
        while (fast != null && fast.getNext() != null)//因为fast每次要走两步，所有需要判断fast的下一个是否为空
        {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            //判断是否相遇 相遇后让快指针从头开始走，每次都是走一步，第二次相遇的节点就是环的入口
            if (fast.getData() == slow.getData()) {
                fast = pHead;
                while (fast.getData() != slow.getData()) {
                    fast = fast.getNext();
                    slow = slow.getNext();
                }
                return slow;
            }
        }
        return null;//要是没有相遇，此链表没有环返回空
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
        node4.setNext(node4);
        SingleNode loopHead = loop(head);
        if (loopHead == null) {
            System.out.println("此单链表中没有环");
        } else {
            System.out.println("此单链表中存在环，入口节点为：" + loopHead.getData());
        }
    }

}

