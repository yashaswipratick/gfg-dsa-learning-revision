package com.revision.topics.heap.code_story_with_MIK.medium;

import java.util.Collections;
import java.util.PriorityQueue;

// PL - https://leetcode.com/problems/remove-stones-to-minimize-the-total/
//VL - https://www.youtube.com/watch?v=uodyPJ8zUVc&list=PLpIkg8OmuX-IkxvvfOeZp-Ot0UWHMGAT-&index=3
public class Leetcode_1962 {

    public static int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int totalSum = 0;
        for (int i : piles) {
            pq.add(i);
            totalSum += i;
        }

        while (k > 0) {
            Integer poll = pq.poll();
            double curr = Math.floor(poll / 2);
            pq.add((int)curr);
            totalSum -= curr;
            k--;
        }
        return totalSum;
    }

    public static void main(String[] args) {
        System.out.println(minStoneSum(new int[]{5, 4, 9}, 2));
        System.out.println(minStoneSum(new int[]{4,3,6,7}, 3));
        System.out.println(minStoneSum(new int[]{1}, 100000));
        System.out.println(minStoneSum(new int[]{1391,5916}, 3));
    }
}
