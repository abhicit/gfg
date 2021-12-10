package com.gfg.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Pair implements Comparable<Pair>{
	int v;
	String psf;
	int wsf;
	
	Pair(int v, String psf, int wsf){
		this.v = v;
		this.psf = psf;
		this.wsf = wsf;
	}

	@Override
	public int compareTo(Pair o) {
		return this.wsf - o.wsf;
	}
}

public class DijkstraShortestPathPriorityQueue {
	
	static class Edge{
		int src;
		int nbr;
		int wt;
		
		Edge(int src, int nbr, int wt){
			this.src = src;
			this.nbr = nbr;
			this.wt = wt;
		}
	}
	
	public static void main(String[] args) {
		int v = 5;
		ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
		for(int i = 0; i < v; i++) {
			adj.add(new ArrayList<Edge>());
		}
		addEdge(adj, 0, 1, 10);
		addEdge(adj, 0, 2, 5);
		addEdge(adj, 2, 3, 4);
		addEdge(adj, 1, 4, 6);
		addEdge(adj, 3, 4, 2);
		addEdge(adj, 0, 4, 1);
		dijkstra(adj, 0);
	}
	
	public static void addEdge(ArrayList<ArrayList<Edge>> adj, int u, int v, int wt) {
		adj.get(u).add(new Edge(u, v, wt));
		adj.get(v).add(new Edge(v, u, wt));
	}
	
	public static void dijkstra(ArrayList<ArrayList<Edge>> adj, int src) {
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
		pq.add(new Pair(src, src+"", 0));
		boolean[] visited = new boolean[adj.size()];
		Arrays.fill(visited, false);
		visited[src] = true;
		while(!pq.isEmpty()) {
			Pair rem = pq.remove();
			System.out.println(rem.v+" via "+rem.psf+" @ "+rem.wsf);
			for(Edge e : adj.get(rem.v)) {
				if(!visited[e.nbr]) {
					pq.add(new Pair(e.nbr, rem.psf+e.nbr, rem.wsf+e.wt));
					visited[e.nbr] = true;
				}
			}
		}
	}
}
