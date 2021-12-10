package com.gfg.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

class AdjListNode{
	private int v;
	private int w;
	public AdjListNode() {}
	public AdjListNode(int v, int w) {
		this.v = v;
		this.w = w;
	}
	public int getV() {return v;}
	public int getW() {return w;}
}

public class ShortestPathInDAG {
	static ArrayList<ArrayList<AdjListNode>> adj = new ArrayList<>();
	public static void main(String[] args) {
		int v = 4;
		
		for(int i = 0; i < v; i++) {
			adj.add(new ArrayList<AdjListNode>());
		}
		
		addEdge(adj, 0, 1, 1);
		addEdge(adj, 1, 2, 3);
		addEdge(adj, 1, 3, 2);
		addEdge(adj, 2, 3, 4);
		
		shortestPath(0);
	}
	
	public static void addEdge(ArrayList<ArrayList<AdjListNode>> adj, int u, int v, int w) {
		adj.get(u).add(new AdjListNode(v, w));
	}
	
	public static void topologicalSortUtil(ArrayList<ArrayList<AdjListNode>> adj, int s, boolean[] visited, Stack<Integer> st) {
		visited[s] = true;
		for(AdjListNode i : adj.get(s)) {
			if(!visited[i.getV()])
				topologicalSortUtil(adj, i.getV(), visited, st);
		}
		st.push(s);
	}
	
	public static void shortestPath(int s) {
		Stack<Integer> st = new Stack<Integer>();
		int[] dist = new int[adj.size()];
		
		boolean[] visited = new boolean[adj.size()];
		for(int i = 0; i < adj.size(); i++) {
			if(!visited[i])
				topologicalSortUtil(adj, i, visited, st);
		}
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		dist[s] = 0;
		
		while(!st.isEmpty()) {
			int u = st.pop();
			for(AdjListNode i : adj.get(u)) {
				if(dist[i.getV()] > dist[u] + i.getW())
					dist[i.getV()] = dist[u] + i.getW();
			}
		}
		
		for (int i = 0; i < adj.size(); i++)
        {
            if (dist[i] == Integer.MAX_VALUE)
                System.out.print( "INF ");
            else
                System.out.print( dist[i] + " ");
        }
	}
}
