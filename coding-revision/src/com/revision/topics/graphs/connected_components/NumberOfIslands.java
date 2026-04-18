package com.revision.topics.graphs.connected_components;

import java.util.LinkedList;
import java.util.Queue;

// PL - https://leetcode.com/problems/number-of-islands/description/
// VL - https://www.youtube.com/watch?v=muncqlKJrH0&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=8
public class NumberOfIslands {

    public static int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != '0' && !visited[i][j]) {
                    bfs(grid, i, j, m, n, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private static void bfs(char[][] grid, int i, int j, int m, int n, boolean[][] visited) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(i, j));

        visited[i][j] = true;
        while (!queue.isEmpty()) {
            Pair poll = queue.poll();
            int iIndex = poll.iIndex;
            int jIndex = poll.jIndex;

            traversal(iIndex-1, jIndex, m, n, grid, visited, queue);
            traversal(iIndex+1, jIndex, m, n, grid, visited, queue);
            traversal(iIndex, jIndex-1, m, n, grid, visited, queue);
            traversal(iIndex, jIndex+1, m, n, grid, visited, queue);
        }
    }

    private static void traversal(int iIndex, int jIndex, int m, int n, char[][] grid, boolean[][] visited, Queue<Pair> queue) {
        if (iIndex >= 0 && jIndex >= 0 && iIndex < m && jIndex < n && grid[iIndex][jIndex] != '0' && !visited[iIndex][jIndex]) {
            visited[iIndex][jIndex] = true;
            queue.add(new Pair(iIndex, jIndex));
        }
    }

    public static void main(String[] args) {

        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        System.out.println(numIslands(grid));

        char[][] grid1 = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println(numIslands(grid1));
    }

    static class Pair {
        int iIndex;
        int jIndex;

        public Pair(int iIndex, int jIndex) {
            this.iIndex = iIndex;
            this.jIndex = jIndex;
        }
    }
}
