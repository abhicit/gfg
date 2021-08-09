package com.gfg.linkedlist;

public class RemoveDuplicatesInSortedSinglyLinkedList {
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(4);
		head = removeDuplicates(head);
		print(head);
	}
	
	private static void print(Node head) {
		if(head == null) {
			System.out.println("NULL");
			return;
		}
		System.out.print(head.data+" -> ");
		print(head.next);
	}
	
	public static Node removeDuplicates(Node head) {
		Node slow = head;
		while(slow.next != null) {
			if(slow.data == slow.next.data) {
				slow.next = slow.next.next;
				break;
			}
			slow = slow.next;
		}
		return head;
	}
}
