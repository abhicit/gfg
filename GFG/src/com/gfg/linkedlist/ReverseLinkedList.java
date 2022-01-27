package com.gfg.linkedlist;

public class ReverseLinkedList {
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head = reverse(head);
		print(head);
	}
	
	private static Node reverse(Node head) {
		Node prev = null;
		Node curr = head;
		Node next = curr.next;
		
		while(next != null) {
			curr.next = prev;
			prev = curr;
			curr = next;
			next = next.next;
		}
		curr.next = prev;
		prev = curr;
		return prev;
	}

	public static void print(Node head) {
		if(head == null)
			return;
		System.out.print(head.data+" ");
		print(head.next);
	}
}
