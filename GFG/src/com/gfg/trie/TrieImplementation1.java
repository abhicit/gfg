package com.gfg.trie;

class TrieNode{
	TrieNode[] child = new TrieNode[26];
	boolean isEnd;
}

public class TrieImplementation1 {
	
	static TrieNode root = new TrieNode();
	
	public static boolean insert(String key) {
		TrieNode curr = root;
		for(int i = 0; i < key.length(); i++) {
			int index = key.charAt(i)-'a';
			if(curr.child[index] == null)
				curr.child[index] = new TrieNode();
			curr = curr.child[index];
		}
		return curr.isEnd = true;
	}
	
	public static boolean search(String key) {
		TrieNode curr = root;
		for(int i = 0; i < key.length(); i++) {
			int index = key.charAt(i)-'a';
			if(curr.child[index] == null)
				return false;
			curr = curr.child[index];
		}
		
		return curr.isEnd == true;
	}
	
	public static void main(String[] args) {
		insert("abhishek");
		insert("dubey");
		System.out.println(search("dube"));
	}
	
}
