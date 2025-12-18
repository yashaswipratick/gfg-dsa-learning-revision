package com.revision.topics.heap.code_story_with_MIK.medium;

import java.util.PriorityQueue;

// PL - https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-ii/description/
// VL - https://www.youtube.com/watch?v=PVHJh8Gq3js&list=PLpIkg8OmuX-IkxvvfOeZp-Ot0UWHMGAT-&index=25
public class Leetcode_3066 {

    public static int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();

        int ops = 0;

        for (int i : nums) {
            pq.add((long) i);
        }

        while (!pq.isEmpty() && pq.peek() < k) {
            Long x = pq.poll();
            Long y = pq.poll();
            long sum = (Math.min(x,y) * 2 + Math.max(x,y));
            pq.add(sum);
            ops++;
        }
        return ops;
    }

    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{2, 11, 10, 1, 3}, 10));
        System.out.println(minOperations(new int[]{1,1,2,4,9}, 20));
        System.out.println(minOperations(new int[]{999999999,999999999,999999999}, 1000000000));
    }
}
