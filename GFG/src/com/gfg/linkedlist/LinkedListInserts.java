package com.gfg.linkedlist;

public class LinkedListInserts {
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head = insertAtHead(head, 0);
		insertAtMiddle(head.next.next.next, 6);
		head = insertAtEnd(head, 7);
		printLinkedList(head);
		head = deleteFirstNode(head);
		printLinkedList(head);
		head = deleteEndNode(head);
		printLinkedList(head);
		System.out.println(iterativeSearch(head, 5).data);
		System.out.println(recursiveSearch(head, 6).data);
		head = reverseLinkedList(head);
		printLinkedList(head);
		
	}

	private static Node insertAtHead(Node head, int i) {
		if(head == null) {
			head = new Node(i);
			return head;
		}
		Node temp = new Node(i);
		temp.next = head;
		head = temp;
		return head;
	}
	
	private static void insertAtMiddle(Node node, int i) {
		if(node == null) {
			node = new Node(i);
			return;
		}
		Node temp = new Node(i);
		temp.next = node.next;
		node.next = temp;
	}
	
	private static Node insertAtEnd(Node head, int i) {
		if(head == null) {
			head = new Node(i);
			return head;
		}
		Node temp = new Node(i);
		Node curr = head;
		while(curr.next != null) {
			curr = curr.next;
		}
		curr.next = temp;
		return head;
	}
	
	private static Node deleteFirstNode(Node head) {
		if(head == null || head.next == null) {
			head = null;
			return head;
		}
		
		head = head.next;
		return head;
		
	}
	
	private static Node deleteEndNode(Node head) {
		if(head == null || head.next == null) {
			head = null;
			return head;
		}
		
		Node temp = head;
		while(temp.next.next != null) {
			temp = temp.next;
		}
		temp.next = null;
		return head;
	}
	
	private static Node iterativeSearch(Node head, int key) {
		if(head == null)
			return null;
		Node temp = head;
		while(temp != null) {
			if(temp.data == key)
				return temp;
			temp = temp.next;
		}
		return null;
	}
	
	private static Node recursiveSearch(Node head, int key) {
		if(head == null)
			return null;
		if(head.data == key)
			return head;
		return recursiveSearch(head.next, key);
	}
	
	private static void printLinkedList(Node head) {
		if(head == null) {
			System.out.println("NULL");
			return;
		}
		System.out.print(head.data+" -> ");
		printLinkedList(head.next);
	}
	
	private static Node reverseLinkedList(Node head) {
		if(head == null || head.next == null)
			return head;
		Node curr = head;
		Node prev = null;
		Node next = curr.next;
		while(curr.next != null) {
			curr.next = prev;
			prev = curr;
			curr = next;
			next = next.next;
		}
		curr.next = prev;
		head = curr;
		return head;
	}
}
