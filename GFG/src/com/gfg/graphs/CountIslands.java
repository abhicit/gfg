package com.gfg.graphs;

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class CountIslands {
 public static void main(String[] args) throws IOException {
     BufferedReader br =
         new BufferedReader(new InputStreamReader(System.in));
     int T = Integer.parseInt(br.readLine().trim());
     while (T-- > 0) {
         String[] s = br.readLine().trim().split(" ");
         //int n = Integer.parseInt(s[0]);
         //int m = Integer.parseInt(s[1]);
         char[][] grid = {{0,1},{1,0},{1,1},{1,0}};
         /*for (int i = 0; i < n; i++) {
             String[] S = br.readLine().trim().split(" ");
             for (int j = 0; j < m; j++) {
                 grid[i][j] = S[j].charAt(0);
             }
         }*/
         Solution obj = new Solution();
         int ans = obj.numIslands(grid);
         System.out.println(ans);
     }
 }
}// } Driver Code Ends


class Solution {
 // Function to find the number of islands.
 public int numIslands(char[][] grid) {
     boolean[][] visited = new boolean[grid.length][grid[0].length];
     int res = 0;
     
     for(int i = 0; i < grid.length; ++i)
         for(int j = 0; j < grid[i].length; ++j)
             if(grid[i][j] == 1 && !visited[i][j]){
                 DFS(grid, i, j, visited);
                 ++res;
             }
             
     return res;
 }
 
 public void DFS(char[][] grid, int row, int col, boolean[][] visited){
     
     int[] rowNbr = new int[] {-1, -1, -1, 0, 0, 1, 1, 1};
     int[] colNbr = new int[] {-1, 0, 1, -1, 1, -1, 0, 1};
     
     visited[row][col] = true;
     
     for(int k = 0; k < 8; ++k)
         if(isSafe(grid, row + rowNbr[k], col + colNbr[k], visited))
             DFS(grid, row + rowNbr[k], col + colNbr[k], visited);
     
 }
 
 boolean isSafe(char[][] grid, int row, int col, boolean[][] visited){
     return (row >= 0) && (row < grid.length) && (col >= 0) && (col < grid[0].length) && (grid[row][col] == 1 && !visited[row][col]);
 }
}
