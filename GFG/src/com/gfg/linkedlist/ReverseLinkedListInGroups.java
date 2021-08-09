package com.gfg.linkedlist;

public class ReverseLinkedListInGroups {
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head = reverseInGroup(head, 3);
		print(head);
	}
	
	public static Node reverseInGroup(Node head, int k) {
		Node temp = head;
		head = null;
		int count = 0;
		Node lastEnd = temp;
		Node prev = null;
		Node curr = temp;
		while(count != k) {
			Node next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}
		head = prev;
		prev = lastEnd;
		while(prev != null) {
			Node next = curr.next;
			
		}
		return head;
	}
	
	public static void print(Node head) {
		if(head == null)
			return;
		System.out.print(head.data+" ");
		print(head.next);
	}
}
