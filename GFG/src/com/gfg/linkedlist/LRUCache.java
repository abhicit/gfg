package com.gfg.linkedlist;

import java.util.HashMap;

public class LRUCache {
	private HashMap<Integer, Node> map;
	private int capacity, count;
	private Node head, tail;
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
		count = 0;
		map = new HashMap<Integer, Node>();
		head = new Node(0);
		tail = new Node(0);
		head.next = tail;
		tail.prev = head;
	}
	
	public int get(int key) {
		if(map.get(key) != null) {
			Node temp = map.get(key);
			int result = temp.data;
			deleteNode(temp);
			addToHead(temp);
			return result;
		}
		
		return -1;
	}
	
	public void set(int key, Node node) {
		if(map.get(key) != null) {
			deleteNode(node);
			addToHead(node);
		}else {
			map.put(key, node);
			if(count < capacity) {
				count++;
				addToHead(node);
			}else {
				map.remove(tail.prev.data);
				deleteNode(tail.prev);
				addToHead(node);
			}
		}
	}

	private void addToHead(Node temp) {
		temp.next = head.next;
		temp.next.prev = temp;
		temp.prev = head;
		head.next = temp;
	}

	private void deleteNode(Node temp) {
		temp.prev.next = temp.next;
		temp.next.prev = temp.prev;
	}
	
	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		cache.set(1, one);
		cache.set(2, two);
		cache.set(3, three);
		cache.get(2);
		print(cache.head.next, cache.tail);
		cache.set(4, four);
		System.out.println();
		print(cache.head.next, cache.tail);
	}

	private static void print(Node head, Node tail) {
		if(head == tail)
			return;
		System.out.print(head.data+" ");
		print(head.next, tail);
	}
	
}
