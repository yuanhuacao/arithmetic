package com.example.arithmetic.geektime.wangzheng;

/**
 * 检测单链表中是否存在环
 * 返回环的入口
 */
public class Solution {

    public SingleNode entryNodeOfLoop(SingleNode pHead) {
        if (pHead == null || pHead.getNext() == null)
            return null;
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
            }
            if (fast.getData() == slow.getData()) {
                return slow;
            }
        }
        return null;//要是没有相遇，此链表没有环返回空
    }

}

