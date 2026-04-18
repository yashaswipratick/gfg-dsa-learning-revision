package com.revision.topics.graphs.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// PL - https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
// VL - https://www.youtube.com/watch?v=-tgVpUgsQ5k&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=5
public class BFSTraversal {

    public static ArrayList<Integer> bfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        boolean[] vis = new boolean[adj.size()];

        queue.add(0);
        vis[0] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            bfs.add(node);
            vis[node] = true;

            for (Integer data : adj.get(node)) {
                if (!vis[data]) {
                    vis[data] = true;
                    queue.add(data);
                }
            }
        }
        return bfs;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> innerList = new ArrayList<>();
        innerList.add(2);
        innerList.add(3);
        innerList.add(1);
        list.add(innerList);
        ArrayList<Integer> innerList1 = new ArrayList<>();
        innerList1.add(0);
        list.add(innerList1);
        ArrayList<Integer> innerList2 = new ArrayList<>();
        innerList2.add(0);
        innerList2.add(4);
        list.add(innerList2);
        ArrayList<Integer> innerList3 = new ArrayList<>();
        innerList3.add(0);
        list.add(innerList3);
        ArrayList<Integer> innerList4 = new ArrayList<>();
        innerList4.add(2);
        list.add(innerList4);
        System.out.println(bfsOfGraph(list));
    }
}
