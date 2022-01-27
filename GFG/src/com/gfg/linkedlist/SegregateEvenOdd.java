package com.gfg.linkedlist;

public class SegregateEvenOdd {
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(7);
		head = segregate(head);
		print(head);
	}

	private static Node segregate(Node head) {
		Node curr = head;
		Node evenStart = null;
		Node evenEnd = null;
		Node oddStart = null;
		Node oddEnd = null;
		while(curr != null) {
			if(curr.data%2 == 0) {
				if(evenStart == null) {
					evenStart = curr;
					evenEnd = evenStart;
				}else {
					evenEnd.next = curr;
					evenEnd = evenEnd.next;
				}
			}else {
				if(oddStart == null) {
					oddStart = curr;
					oddEnd = oddStart;
				}else {
					oddEnd.next = curr;
					oddEnd = oddEnd.next;
				}
			}
			curr = curr.next;
		}
		if(oddStart == null || evenStart == null)
			return head;
		oddEnd.next = evenStart;
		evenEnd.next = null;
		return oddStart;
	}

	private static void print(Node head) {
		if(head == null)
			return;
		System.out.print(head.data+" ");
		print(head.next);
	}
}
