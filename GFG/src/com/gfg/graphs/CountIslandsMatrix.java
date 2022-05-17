package com.gfg.graphs;

import java.util.Arrays;

public class CountIslandsMatrix {
	public static int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(boolean[] i : visited)
            Arrays.fill(i, false);
            
        int count = 0;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    count++;
                    util(grid, i, j, visited);
                }
            }
        }
        
        return count;
    }
    
    public static void util(char[][] grid, int i, int j, boolean[][] visited){
        if(!isSafe(grid, i, j, visited))
            return;
        visited[i][j] = true;
        
        util(grid, i+1, j, visited);
        util(grid, i, j+1, visited);
        util(grid, i+1, j+1, visited);
    }
    
    public static boolean isSafe(char[][] grid, int i, int j, boolean[][] visited){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length
         || grid[i][j] == '0' || visited[i][j])
            return false;
        
        return true;
            
    }
    
    public static void main(String[] args) {
		char[][] ch = {{'0', '1', '0'},
				{'0', '1', '0'},
				{'0', '0', '0'},
				{'1', '1', '0'},
				{'1', '0', '1'},
				{'0', '1', '1'},
				{'1', '1', '1'},
				{'0', '1', '1'},
				{'1', '0', '1'}};
		System.out.println(numIslands(ch));
	}
}
