package com.gfg.graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class ArticulationPoint {
	private int V;
	
	private ArrayList<ArrayList<Integer>> adj;
	int time = 0;
	static final int NIL = -1;
	
	public ArticulationPoint(int v) {
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
		ArticulationPoint ap = new ArticulationPoint(5);
		ap.addEdge(1, 0);
		ap.addEdge(0, 2);
		ap.addEdge(2, 1);
		ap.addEdge(0, 3);
		ap.addEdge(3, 4);
		
		ap.ap();
	}

	private void ap() {
		boolean[] visited = new boolean[V];
		int[] disc = new int[V];
		int[] low = new int[V];
		int[] parent = new int[V];
		boolean[] ap = new boolean[V];
		
		Arrays.fill(visited, false);
		Arrays.fill(parent, NIL);
		Arrays.fill(ap, false);
		
		for(int i = 0; i < V; i++) {
			if(!visited[i])
				APUtil(i, visited, disc, low, parent, ap);
		}
		
		for(int i = 0; i < V; i++)
			if(ap[i])
				System.out.print(i+" ");
	}

	private void APUtil(int u, boolean[] visited, int[] disc, int[] low, int[] parent, boolean[] ap) {
		int count = 0;
		visited[u] = true;
		disc[u] = low[u] = ++time;
		
		for(int v : adj.get(u)) {
			if(!visited[v]) {
				count++;
				parent[v] = u;
				APUtil(v, visited, disc, low, parent, ap);
				low[u] = Math.min(low[u], low[v]);
				
				if(parent[u] == NIL && count > 1)
					ap[u] = true;
				
				if(parent[u] != NIL && low[v] >= disc[u])
					ap[u] = true;
			}else if(v != parent[u]) {
				low[u] = Math.min(low[u], disc[v]);
			}
		}
	}
}
