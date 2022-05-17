package com.gfg.tree;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class VerticalSum {
	public static ArrayList <Integer> verticalSum(Node root) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        util(root, map, 0);
        System.out.println(map);
        ArrayList<Integer> li = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
            li.add(entry.getValue());
        
        return li;
    }
    
    public static void util(Node root, Map<Integer, Integer> map, int count) {
        if(root != null){
            util(root.left, map, count-1);
            map.put(count, map.getOrDefault(count, 0)+root.data);
            util(root.right, map, count+1);
        }
    }
    
    public static void main(String[] args) {
    	Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        
        ArrayList<Integer> li = verticalSum(root);
        System.out.println(li);
	}
}
