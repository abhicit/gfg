package com.gfg.linkedlist;

class NodeNew{
	int data;
	NodeNew next;
	NodeNew(int data){
		this.data = data;
		next = null;
	}
}

public class PrintLinkedListRecursive {
	public static void main(String[] args) {
		NodeNew head = new NodeNew(1);
		head.next = new NodeNew(2);
		head.next.next = new NodeNew(3);
		head.next.next.next = new NodeNew(4);
		head.next.next.next.next = new NodeNew(5);
		printLinkedList(head);
	}

	private static void printLinkedList(NodeNew head) {
		if(head == null) {
			System.out.println("NULL");
			return;
		}
		System.out.print(head.data+" -> ");
		printLinkedList(head.next);
	}
}
