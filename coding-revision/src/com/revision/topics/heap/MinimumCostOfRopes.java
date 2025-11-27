package com.revision.topics.heap;

import java.util.PriorityQueue;

// PL - https://www.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1
// VL - https://www.youtube.com/watch?v=_k_c9nqzKN0&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=9
public class MinimumCostOfRopes {

    public static int minCost(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int cost = 0;
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }
        while (pq.size() >= 2) {
            int first = pq.poll();
            int second = pq.poll();
            cost = cost + first + second;
            pq.add(first + second);
        }
        return cost;
    }

    public static void main(String[] args) {
        System.out.println(minCost(new int[]{1, 2, 3, 4, 5}));
        System.out.println(minCost(new int[]{4, 3, 2, 6}));
        System.out.println(minCost(new int[]{4, 2, 7, 6, 9}));
        System.out.println(minCost(new int[]{10}));
    }
}
