package com.example.arithmetic.suanfa;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    /**
     * 就是在temp存储了尾节点，然后再一层层往前。这个head.next=null是必须的，因为最后一个节点时不会自己赋值的，会形成一个环。
     *
     * @param node
     * @return
     */


    public ListNode reverse1(ListNode node) {
        if (node.next == null) {
            return node;
        }
        //next 是最后节点 node是倒数第二个节点
        ListNode next = node.next;
        ListNode lastNode = this.reverse1(next);
        System.out.println(lastNode.toString());
        next.next = node;
        node.next = null;
        return lastNode;
    }

    public ListNode reverse(ListNode head){
        ListNode p = head,q = null,front = null;
        while(p!=null){
            q = p.next;//设置q是p结点的后继结点,即用q来保持p的后继结点
            p.next = front;//逆转,即使p.next指向p结点的前驱结点
            front = p;//front向后移一步
            p = q;//p向后移一步
        }
        head = front;//head指向原链表的最后一个结点，完成逆转
        return head;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        System.out.println("开始反转");
        head = head.reverse1(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
