package com.revision.topics.heap.code_story_with_MIK.medium;

import java.util.Collections;
import java.util.PriorityQueue;

// PL - https://leetcode.com/problems/maximal-score-after-applying-k-operations/
// VL - https://www.youtube.com/watch?v=t2tBCpzYl6w&list=PLpIkg8OmuX-IkxvvfOeZp-Ot0UWHMGAT-&index=21
public class Leetcode_2530 {

    public static long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());

        for (int i : nums) {
            pq.add(i);
        }

        long maxScore = 0;

        while (k > 0) {
            int poll = pq.poll();
            maxScore += poll;
            pq.add((int) Math.ceil((double) poll /3));
            k--;
        }
        return maxScore;
    }
    public static void main(String[] args) {
        System.out.println(maxKelements(new int[]{10, 10, 10, 10, 10}, 5));
        System.out.println(maxKelements(new int[]{1,10,3,3,3}, 3));
    }
}
