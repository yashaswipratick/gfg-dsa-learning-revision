package com.revision.topics.heap.practise.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// PL - https://leetcode.com/problems/maximum-total-importance-of-roads/description/

public class Leetcode_2285 {

    // TODO - Revisit
    public static long maximumImportance(int n, int[][] roads) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < roads.length; i++) {
            map.put(roads[i][0], map.getOrDefault(roads[i][0], 0) + 1);
            map.put(roads[i][1], map.getOrDefault(roads[i][1], 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq =
                new PriorityQueue<>(((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue())));
        pq.addAll(map.entrySet());

        int[] res = new int[n];

        while (!pq.isEmpty()) {
            Map.Entry<Integer, Integer> poll = pq.poll();
            res[poll.getKey()] = n;
            n--;
        }

        long sum = 0;
        for (int i = 0; i < roads.length; i++) {
            sum += res[roads[i][0]] + res[roads[i][1]];
        }
        return sum;
    }

    public static void main(String[] args) {
        /*System.out.println(maximumImportance(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {0, 2}, {1, 3}, {2, 4}}));
        System.out.println(maximumImportance(5, new int[][]{{0,3},{2,4},{1,3}}));
        System.out.println(maximumImportance(5, new int[][]{{0,1}}));*/
        System.out.println(maximumImportance(4, new int[][]{{3,2},{0,2}}));
    }
}
