package com.revision.topics.heap.practise.easy;

import java.util.Collections;
import java.util.PriorityQueue;

// PL - https://leetcode.com/problems/minimum-amount-of-time-to-fill-cups/
// VL - https://www.youtube.com/watch?v=vjCQqTPhY1A
public class Leetcode_2335 {

    // TODO - Revisit
    public static int fillCups(int[] amount) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i : amount) {
            pq.add(i);
        }
        int ans = 0;
        while (pq.peek() != 0) {
            int x = pq.poll();
            int y = pq.poll();

            x--;
            y--;
            pq.add(x);
            pq.add(y);
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(fillCups(new int[]{1, 4, 2}));
        System.out.println(fillCups(new int[]{5, 4, 4}));
        System.out.println(fillCups(new int[]{5, 0, 0}));
    }
}
