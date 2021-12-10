package com.gfg.greedy;

import java.util.PriorityQueue;

class Node implements Comparable<Node>{
	Node left;
	Node right;
	int freq;
	char ch;
	
	Node(int freq, char ch, Node l, Node r){
		this.freq = freq;
		this.ch = ch;
		this.left = l;
		this.right = r;
	}

	@Override
	public int compareTo(Node n) {
		return this.freq - n.freq;
	}
}

public class HuffmanCoding {
	public static void main(String[] args) {
		char[] ch = {'a', 'd', 'b', 'e', 'f'};
		int[] freq = {10, 50, 20, 40, 80};
		
		Node root = buildTree(ch, freq);
		
		printCode(root, "");
	}

	private static void printCode(Node root, String str) {
		if(root == null)
			return;
		if(root.ch != '$') {
			System.out.println(root.ch+" "+str);
		}
		printCode(root.left, str+"0");
		printCode(root.right, str+"1");
	}

	private static Node buildTree(char[] ch, int[] freq) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		for(int i = 0; i < ch.length; i++) {
			q.add(new Node(freq[i], ch[i], null, null));
		}
		
		while(q.size() > 1) {
			Node left = q.poll();
			Node right = q.poll();
			
			q.add(new Node(left.freq+right.freq, '$', left, right));
		}
		
		return q.poll();
	}
}
