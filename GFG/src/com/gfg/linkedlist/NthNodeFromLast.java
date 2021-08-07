package com.gfg.linkedlist;

public class NthNodeFromLast {
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		
		Node res = nthFromLast(head, 2);
		System.out.println(res.data);
		Node res1 = nthFromLastEfficient(head, 3);
		System.out.println(res1.data);
	}

	public static Node nthFromLast(Node head, int n) {//Naive
		Node temp = head;
		int count = 0;
		while(temp != null) {
			count++;
			temp = temp.next;
		}
		temp = head;
		int nthNo = count - n + 1;
		count = 1;
		while(nthNo != count) {
			temp = temp.next;
			count++;
		}
		
		return temp;
	}
	
	public static Node nthFromLastEfficient(Node head, int n) {//Efficient
		Node fast = head;
		for(int i = 0; i < n; i++) {
			fast = fast.next;
		}
		Node slow = head;
		while(fast != null) {
			fast = fast.next;
			slow = slow.next;
		}
		
		return slow;
	}
}
