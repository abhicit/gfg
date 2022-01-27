package com.gfg.linkedlist;

public class ReverseDoublyLinkedList {
	public static void main(String[] args) {
		Node head = new Node(1);
		
		head.next = new Node(2);
		head.next.prev = head;
		
		head.next.next = new Node(3);
		head.next.next.prev = head.next;
		
		head.next.next.next = new Node(4);
		head.next.next.next.prev = head.next.next;
		
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.prev = head.next.next.next;
		
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
			curr.prev = next;
			curr = next;
			next = next.next;
		}
		curr.next = prev;
		prev = curr;
		curr.prev = next;
		
		return prev;
	}

	private static void print(Node head) {
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
	}
}
