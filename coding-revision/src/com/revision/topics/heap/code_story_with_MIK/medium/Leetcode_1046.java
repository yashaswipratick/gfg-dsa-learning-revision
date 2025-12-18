package com.revision.topics.heap.code_story_with_MIK.medium;

import java.util.Collections;
import java.util.PriorityQueue;

// PL - https://leetcode.com/problems/last-stone-weight/description/
// VL - https://www.youtube.com/watch?v=GBzie2ETYQg&list=PLpIkg8OmuX-IkxvvfOeZp-Ot0UWHMGAT-&index=5
public class Leetcode_1046 {

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : stones) {
            pq.add(i);
        }

        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();

            int diff = Math.abs(first - second);
            if (diff > 0) {
                pq.add(diff);
            }
        }
        return !pq.isEmpty() ? pq.poll() : 0;
    }

    public static void main(String[] args) {
        System.out.println(lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
        System.out.println(lastStoneWeight(new int[]{1}));
    }
}
