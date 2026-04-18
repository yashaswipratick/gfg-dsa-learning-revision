package com.revision.topics.graphs.connected_components;

import java.util.ArrayList;
import java.util.List;

// PL - https://leetcode.com/problems/number-of-provinces/description/
// VL - https://www.youtube.com/watch?v=ACzkVtewUYA&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=7
public class NumberOfProvinces {

    public static int findCircleNum(int[][] isConnected) {
        List<List<Integer>> list = new ArrayList<>();

        int V = isConnected.length;

        for (int i = 0; i < V; i++) {
            list.add(new ArrayList<>());
        }

        //convert matrix to adjacency list
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[i].length; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    list.get(i).add(j);
                    list.get(j).add(i);
                }
            }
        }

        int count = 0;
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                count++;
                dfs(list, visited, i);
            }
        }
        return count;
    }

    private static void dfs(List<List<Integer>> list, boolean[] visited, int node) {
        visited[node] = true;

        for (int child : list.get(node)) {
            if (!visited[child]) {
                dfs(list, visited, child);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(findCircleNum(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}));
    }
}
