package com.gfg.linkedlist;

public class RecursiveReverseLinkedList {
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head = reverse1(head);
		print(head);
		System.out.println();
		head = reverse2(head, null);
		print(head);
	}
	
	private static Node reverse2(Node curr, Node prev) {
		if(curr == null)
			return prev;
		
		Node next = curr.next;
		curr.next = prev;
		return reverse2(next, curr);
	}

	private static Node reverse1(Node head) {
		if(head == null || head.next == null) {
			return head;
		}
		Node restHead = reverse1(head.next);
		Node restTail = head.next;
		restTail.next = head;
		head.next = null;
		return restHead;
	}

	public static void print(Node head) {
		if(head == null)
			return;
		System.out.print(head.data+" ");
		print(head.next);
	}
}
