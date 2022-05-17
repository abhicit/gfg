package com.gfg.linkedlist;

public class MaxSumContiguousNode {
	public static void main(String[] args) {
		Node head = new Node(-2);
		head.next = new Node(-3);
		head.next.next = new Node(4);
		head.next.next.next = new Node(-1);
		head.next.next.next.next = new Node(-2);
		head.next.next.next.next.next = new Node(1);
		head.next.next.next.next.next.next = new Node(5);
		head.next.next.next.next.next.next.next = new Node(-3);
		
		System.out.println(maxSum(head));
	}

	private static int maxSum(Node head) {
		if(head == null)
			return 0;
		if(head.next == null)
			return head.data;
		Node temp = head;
		int curr = temp.data;
		int max = temp.data;
		temp = temp.next;
		while(temp != null) {
			curr = Math.max(temp.data, temp.data+curr);
			max = Math.max(max, curr);
			temp = temp.next;
		}
		return max;
	}
	
	
}
