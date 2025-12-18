package com.revision.topics.heap.code_story_with_MIK.medium;

import java.util.PriorityQueue;

// PL - https://leetcode.com/problems/total-cost-to-hire-k-workers/description/
// VL - https://www.youtube.com/watch?v=ODuICq8exLo&list=PLpIkg8OmuX-IkxvvfOeZp-Ot0UWHMGAT-&index=9
public class Leetcode_2464 {

    public static long totalCost(int[] costs, int k, int candidates) {
        long ans = 0;
        int i = 0;
        int j = costs.length - 1;
        int hire = 0;
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();

        while (hire < k) {
            while (pq1.size() < candidates && i <= j) {
                pq1.add(costs[i]);
                i++;
            }
            while (pq2.size() < candidates && j >= i) {
                pq2.add(costs[j]);
                j--;
            }

            int min_pq1 = !pq1.isEmpty() ? pq1.peek() : Integer.MAX_VALUE;
            int min_pq2 = !pq2.isEmpty() ? pq2.peek() : Integer.MAX_VALUE;

            if (min_pq1 <= min_pq2) {
                ans += min_pq1;
                pq1.poll();
            } else {
                ans += min_pq2;
                pq2.poll();
            }
            hire++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(totalCost(new int[]{1, 2, 4, 1}, 3, 3));
    }
}
