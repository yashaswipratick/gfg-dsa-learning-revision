package com.revision.topics.graphs.traversal;

import java.util.ArrayList;

// PL - https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1
// VL - https://www.youtube.com/watch?v=Qzf1a--rhp8&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=6
public class DFSTraversal {

    private static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] vis = new boolean[adj.size()];
        vis[0] = true;
        ArrayList<Integer> dfs = new ArrayList<>();
        dfsTraversal(0, vis, adj, dfs);
        return dfs;
    }

    public static void dfsTraversal(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfs) {
        vis[node] = true;
        dfs.add(node);

        for (int data : adj.get(node)) {
            if (!vis[data]) {
                vis[data] = true;
                dfsTraversal(data, vis, adj, dfs);
            }
        }
    }

    public static void main(String[] args) {

    }
}
