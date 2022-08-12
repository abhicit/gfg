package com.gfg.trie;

import java.util.HashMap;
import java.util.Map;

class TrieNode1 {
	Map<Character, TrieNode1> next;
	boolean isEnd;
	static TrieNode1 root = new TrieNode1();
	
	TrieNode1(){
		next = new HashMap<Character, TrieNode1>();
		isEnd = false;
	}
	
	public void insert(String word) {
		TrieNode1 curr = root;
		for(char c : word.toCharArray()) {
			if(curr.next.get(c) == null)
				curr.next.put(c, new TrieNode1());
			curr = curr.next.get(c);
		}
		
		curr.isEnd = true;
	}
	
	public boolean search(String word) {
		TrieNode1 curr = root;
		for(char c : word.toCharArray()) {
			if(curr.next.get(c) == null)
				return false;
			curr = curr.next.get(c);
		}
		
		return curr.isEnd;
	}
	
	public boolean prefixSearch(String text, String word) {
		TrieNode1 curr = root;
		TrieNode1 i;
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
		TrieNode1 trie = new TrieNode1();
		trie.insert("aabdacaadaabaaba");
		System.out.println(trie.prefixSearch("aabdacaadaabaaba", "aaba"));
	}
}
