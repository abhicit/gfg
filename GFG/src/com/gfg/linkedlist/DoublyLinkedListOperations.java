package com.gfg.linkedlist;

class Node{
	int data;
	Node prev;
	Node next;
	
	Node(int data){
		this.data = data;
		prev = null;
		next = null;
	}
}

public class DoublyLinkedListOperations {
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
		
		print(head);
		head = insertBegin(head, 0);
		print(head);
		head = insertEnd(head, 6);
		print(head);
		insertMid(head.next.next.next, 7);
		print(head);
		head = reverse(head);
		print(head);
	}
	
	public static Node insertBegin(Node head, int key) {
		if(head == null) {
			head = new Node(key);
			return head;
		}
		
		Node temp = new Node(key);
		temp.next = head;
		head.prev = temp;
		head = temp;
		return head;
	}
	
	public static Node insertEnd(Node head, int key) {
		if(head == null) {
			head = new Node(key);
			return head;
		}
		
		Node temp = new Node(key);
		Node curr = head;
		while(curr.next != null) {
			curr = curr.next;
		}
		
		curr.next = temp;
		temp.prev = curr;
		return head;
	}
	
	public static void insertMid(Node node, int key) {
		Node temp = new Node(key);
		temp.prev = node;
		temp.next = node.next;
		node.next.prev = temp;
		node.next = temp;
	}
	
	public static Node reverse(Node head) {
		Node curr = head;
		while(curr != null) {
			Node temp = curr.prev;
			curr.prev = curr.next;
			curr.next = temp;
			if(curr.prev == null) {
				head = curr;
				break;
			}
			curr = curr.prev;
			
		}
		return head;
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
