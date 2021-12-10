package com.gfg.graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class Bridges {
private int V;
	
	private ArrayList<ArrayList<Integer>> adj;
	int time = 0;
	static final int NIL = -1;
	
	public Bridges(int v) {
		this.V = v;
		adj = new ArrayList<>();
		for(int i = 0; i < V; i++)
			adj.add(new ArrayList<Integer>());
	}
	
	void addEdge(int u, int v) {
		adj.get(u).add(v);
		adj.get(v).add(u);
	}
	
	public static void main(String[] args) {
		System.out.println("Articulation points in first graph ");
		Bridges b = new Bridges(5);
		b.addEdge(1, 0);
		b.addEdge(0, 2);
		b.addEdge(2, 1);
		b.addEdge(0, 3);
		b.addEdge(3, 4);
		
		b.bridge();
	}

	private void bridge() {
		boolean[] visited = new boolean[V];
		int[] disc = new int[V];
		int[] low = new int[V];
		int[] parent = new int[V];
		
		Arrays.fill(visited, false);
		Arrays.fill(parent, NIL);
		
		for(int i = 0; i < V; i++) {
			if(!visited[i])
				BridgeUtil(i, visited, disc, low, parent);
		}
	}

	private void BridgeUtil(int u, boolean[] visited, int[] disc, int[] low, int[] parent) {
		visited[u] = true;
		disc[u] = low[u] = ++time;
		
		for(int v : adj.get(u)) {
			if(!visited[v]) {
				parent[v] = u;
				BridgeUtil(v, visited, disc, low, parent);
				
				low[u] = Math.min(low[u], low[v]);
				
				if(low[v] > disc[u])
					System.out.println(u+" "+v);
			}else if(v != parent[u]) {
				low[u] = Math.min(low[u], disc[v]);
			}
		}
	}
}
