package com.gfg.linkedlist;

public class LinkedListMergeSort {
	Node head = null;
	static class Node{
		int data;
		Node next;
		Node(int data){
			this.data = data;
			next = null;
		}
	}
	
	public static Node sortedMerge(Node a, Node b) {
		Node result = null;
		if(a == null)
			return b;
		if(b == null)
			return a;
		
		if(a.data <= b.data) {
			result = a;
			result.next = sortedMerge(a.next, b);
		}else {
			result = b;
			result.next = sortedMerge(a, b.next);
		}
		return result;
	}
	
	public static Node mergeSort(Node h) {
		if(h == null || h.next == null)
			return h;
		Node mid = getMiddle(h);
		Node nextOfMid = mid.next;
		
		mid.next = null;
		Node left = mergeSort(h);
		Node right = mergeSort(nextOfMid);
		Node sortedList = sortedMerge(left, right);
		return sortedList;
	}
	
	public static Node getMiddle(Node head) {
		if(head == null)
			return head;
		Node slow = head, fast = head;
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	static void printList(Node headref) 
    { 
        while (headref != null) { 
            System.out.print(headref.data + " "); 
            headref = headref.next; 
        } 
    }
	
	public static void main(String[] args) {
		LinkedListMergeSort li = new LinkedListMergeSort();
		Node h = new Node(5);
		h.next = new Node(3);
		h.next.next = new Node(2);
		h.next.next.next = new Node(1);
		h.next.next.next.next = new Node(4);
		
		li.head = mergeSort(h);
		
		printList(li.head);
		
	}
}
