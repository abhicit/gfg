package com.gfg.linkedlist;

public class PairwiseSwap {
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(7);
		
		head = swap(head);
		
		print(head);
	}

	private static Node swap(Node head) {
		if(head == null || head.next == null)
			return head;
		
		Node curr = head.next.next;
		Node prev = head;
		head = head.next;
		head.next = prev;
		
		while(curr != null && curr.next != null) {
			prev.next = curr.next;
			prev = curr;
			Node next = curr.next.next;
			curr.next.next = curr;
			curr = next;
		}
		
		prev.next = curr;
		return head;
		
	}

	private static void print(Node head) {
		if(head == null)
			return;
		System.out.print(head.data+" ");
		print(head.next);
	}
}
