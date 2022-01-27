package com.gfg.linkedlist;

public class ReverseLinkedListInGroups {
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head = reverseInGroup(head, 2);
		print(head);
		System.out.println();
		head = reverseInGroupsIterative(head, 2);
		print(head);
	}
	
	public static Node reverseInGroup(Node head, int k) {
		Node curr = head;
		Node next = null;
		Node prev = null;
		int count = 0;
		while(curr != null && count < k) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}
		
		if(next != null) {
			Node restHead = reverseInGroup(next, k);
			head.next = restHead;
		}
		
		return prev;
	}
	
	public static Node reverseInGroupsIterative(Node head, int k) {
		Node curr = head;
		Node prevFirst = null;
		boolean isFirstPass = true;
		while(curr != null) {
			Node first = curr, prev = null;
			int count = 0;
			while(curr != null && count < k) {
				Node next = curr.next;
				curr.next = prev;
				prev = curr;
				curr =  next;
				count++;
			}
			
			if(isFirstPass) {
				head = prev;
				isFirstPass = false;
			}else {
				prevFirst.next = prev;
			}
			prevFirst = first;
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
