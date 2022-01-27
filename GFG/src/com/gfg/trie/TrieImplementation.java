package com.gfg.trie;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
	Map<Character, TrieNode> next;
	boolean isEnd;
	static TrieNode root = new TrieNode();
	
	TrieNode(){
		next = new HashMap<Character, TrieNode>();
		isEnd = false;
	}
	
	public void insert(String word) {
		TrieNode curr = root;
		for(char c : word.toCharArray()) {
			if(curr.next.get(c) == null)
				curr.next.put(c, new TrieNode());
			curr = curr.next.get(c);
		}
		
		curr.isEnd = true;
	}
	
	public boolean search(String word) {
		TrieNode curr = root;
		for(char c : word.toCharArray()) {
			if(curr.next.get(c) == null)
				return false;
			curr = curr.next.get(c);
		}
		
		return curr.isEnd;
	}
	
	public boolean prefixSearch(String text, String word) {
		TrieNode curr = root;
		TrieNode i;
		int c = 0;
		int count = 0;
		for(i = curr; !curr.isEnd; curr = curr.next.get(text.charAt(c))) {
			if(i.next.get(word.charAt(c)) != null) {
				count++;
				if(count == word.length())
					return true;
				c++;
				continue;
			}
			count = 0;
			c++;
		}
		
		return false;
	}
}


public class TrieImplementation {
	public static void main(String[] args) {
		TrieNode trie = new TrieNode();
		trie.insert("aabdacaadaabaaba");
		System.out.println(trie.prefixSearch("aabdacaadaabaaba", "aaba"));
	}
}
