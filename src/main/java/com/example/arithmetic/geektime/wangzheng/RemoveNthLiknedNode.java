package com.example.arithmetic.geektime.wangzheng;

/**
 * 删除链表倒数第N个节点
 * 单链表
 * 思路很简单，只有两种出现的情况，
 * 1、链表的长度刚刚好等于n，也就是说删除表头节点，
 * 2、链表长度大于n，那么我们先定义两个表头，一个后移n位，然后两个链表同时后移，这时当后面的节点到达尾部时，前面的节点就是删除的节点的前一个节点。
 */
public class RemoveNthLiknedNode {

	public static SingleNode removeNthNode(SingleNode head, int n) {
		if (head == null) {
			return null;
		}
		SingleNode temp = new SingleNode(-1);
		temp.setNext(head);
		SingleNode front = temp;
		SingleNode tail = temp;
		int num = 0;
		while (num <= n && front != null) {
			front = front.getNext();
			num++;
		}
		while (front != null) {
			front = front.getNext();
			tail = tail.getNext();
		}
		tail.setNext(tail.getNext().getNext());
		return temp.getNext();

	}

	public static SingleNode removeThNode(SingleNode head, int n) {
		if (n <= 0) {
			return head;
		}
		if (head == null) {
			return null;
		}
		SingleNode temp = new SingleNode(-1);
		temp.setNext(head);
		SingleNode reHead = temp;
		int num = 1;
		while (num < n && temp != null) {
			temp = temp.getNext();
			num++;
		}
		if (temp.getNext() == null) {
			return head;
		}
		temp.setNext(temp.getNext().getNext());
		return reHead.getNext();
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
			SingleNode reHead = removeNthNode(head, 2);
			while (reHead != null) {
				System.out.println(reHead.getData());
				reHead = reHead.getNext();

			}
		}
	}

}
