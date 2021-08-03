package com.gfg.linkedlist;

public class CircularLinkedList {
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = head;
		Node tail = head.next.next.next;
		
		print(head);
		head = insertBegin(head, tail, 0);
		print(head);
		tail = insertEnd(head, tail, 5);
		print(head);
	}

	private static Node insertEnd(Node head, Node tail, int key) {
		Node temp = new Node(key);
		tail.next = temp;
		temp.next = head;
		tail = temp;
		return tail;
	}

	private static Node insertBegin(Node head, Node tail, int key) {
		Node temp = new Node(key);
		temp.next = head;
		tail.next = temp;
		head = temp;
		return head;
	}

	private static void print(Node head) {
		Node temp = head;
		do {
			System.out.print(temp.data+" -> ");
			temp = temp.next;
		}while(temp != head);
		System.out.print(temp.data);
		System.out.println();
	}
}
