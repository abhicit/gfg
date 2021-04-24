package com.gfg.linkedlist;

public class CloneLinkedList {
	static class Node{
		int data;
		Node next;
		Node arb;
		
		Node(int data){
			this.data = data;
			next = null;
			arb = null;
		}
	}
	
	public static Node cloneList(Node head) {
		Node curr = head;
		while(curr != null) {
			Node clone = new Node(curr.data);
			clone.next = curr.next;
			curr.next = clone;
			curr = curr.next.next;
		}
		
		curr = head;
		
		while(curr != null) {
			if(curr.next != null)
				curr.next.arb = (curr.arb != null) ? curr.arb.next : curr.arb;
			curr = (curr.next != null) ? curr.next.next : curr.next;
		}
		
		head = head.next;
		curr = head;
		while(curr.next != null) {
			curr.next = (curr.next != null) ? curr.next.next : curr.next;
			curr = curr.next;
		}
		
		return head;
	}
	
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.arb = head.next.next;
		head.next.arb = head;
		head.next.next.arb = head.next.next.next.next;
		head.next.next.next.arb = head.next.next;
		head.next.next.next.next.arb = head.next;
		Node result = cloneList(head);
		Node curr = result;
		while(curr.next != null) {
			System.out.println(curr.data + " " + curr.next.data + " " + curr.arb.data);
			curr = curr.next;
		}
	}
}
