package com.gfg.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class KosarajuAlgorithm {
	public static void main(String[] args) {
		int res = 0;
		int v = 5;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v);
		for(int i = 0; i < v; i++) {
			adj.add(new ArrayList<Integer>());
		}
		
		addEdge(adj, 0, 2);
		addEdge(adj, 2, 1);
		addEdge(adj, 1, 0);
		addEdge(adj, 0, 3);
		addEdge(adj, 3, 4);
		
		Stack<Integer> st = new Stack<>();
		
		boolean[] visited = new boolean[v];
		Arrays.fill(visited, false);
		
		for(int i = 0; i < v; i++)
			if(!visited[i])
				constructStack(i, adj, visited, st);
		ArrayList<ArrayList<Integer>> adjn = new ArrayList<>();
		for(int i = 0; i < v; i++) {
			adjn.add(new ArrayList<Integer>());
		}
		reverseGraph(adjn, adj, v);
		Arrays.fill(visited, false);
		for(int i = 0; i < v; i++) {
			if(!visited[i]) {
				res++;
				dfs(adjn, i, visited);
			}
		}
		
		System.out.println(res);
	}
	
	private static void dfs(ArrayList<ArrayList<Integer>> adjn, int s, boolean[] visited) {
		visited[s] = true;
		for(int i : adjn.get(s)) {
			if(!visited[i]) {
				dfs(adjn, i, visited);
			}
		}
	}

	private static void reverseGraph(ArrayList<ArrayList<Integer>> adjn, ArrayList<ArrayList<Integer>> adj, int v) {
		for(int i = 0; i < v; i++) {
			for(int j : adj.get(i))
				addEdge(adjn, j, i);
		}
	}

	private static void constructStack(int s, ArrayList<ArrayList<Integer>> adj, 
			boolean[] visited, Stack<Integer> st) {
		visited[s] = true;
		for(int i : adj.get(s)) {
			if(!visited[i]) {
				constructStack(i, adj, visited, st);
			}
		}
		st.push(s);
	}

	public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
		adj.get(u).add(v);
	}
	
	
}
