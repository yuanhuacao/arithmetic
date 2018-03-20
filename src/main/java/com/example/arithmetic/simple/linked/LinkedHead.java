package com.example.arithmetic.simple.linked;

public class LinkedHead {

    public void printCommonPart(Node head1, Node head2) {
        while (head1 != null && head2 != null) {
            if (head1.value == head2.value) {
                System.out.println(head1.value);
                head1 = head1.next;
                head2 = head2.next;
            } else if (head1.value < head2.value) {
                head1 = head1.next;
            } else {
                head2 = head2.next;
            }
        }
    }

    public static void main(String[] args) {
        Node node1=new Node(1);
        node1.next=new Node(2);
        node1.next.next=new Node(3);
        node1.next.next.next=new Node(4);
        Node node2=new Node(2);
        node2.next=new Node(3);
        node2.next.next=new Node(4);
        LinkedHead linkedHead=new LinkedHead();
        linkedHead.printCommonPart(node1,node2);
    }


}
