package com.gfg.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class NodesInALevel {
	public static void main(String[] args) {
		int v = 6;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v);
		for(int i = 0; i < v; i++) {
			adj.add(new ArrayList<Integer>());
		}
		addEdge(adj, 0, 1);
	    addEdge(adj, 0, 2);
	    addEdge(adj, 1, 3);
	    addEdge(adj, 2, 4);
	    addEdge(adj, 2, 5);
	    
	    noOfNodes(adj, 0, 2);
	}
	
	private static void noOfNodes(ArrayList<ArrayList<Integer>> adj, int s, int l) {
		boolean[] visited = new boolean[adj.size()];
		int[] level = new int[adj.size()];
		Queue<Integer> q = new LinkedList<>();
		level[s] = 0;
		q.offer(s);
		visited[s] = true;
		while(!q.isEmpty()) {
			int u = q.poll();
			for(int v : adj.get(u)) {
				if(!visited[v]) {
					visited[v] = true;
					level[v] = level[u]+1;
					q.offer(v);
				}
			}
		}
		
		int count = 0;
		
		for(int i : level)
			if(i == l)
				count++;
		
		System.out.println(count);
		
	}

	public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
		adj.get(u).add(v);
		adj.get(v).add(u);
	}
}
