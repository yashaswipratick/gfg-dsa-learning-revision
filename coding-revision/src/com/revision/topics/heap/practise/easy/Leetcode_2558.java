package com.revision.topics.heap.practise.easy;

import java.util.Collections;
import java.util.PriorityQueue;

// PL - https://leetcode.com/problems/take-gifts-from-the-richest-pile/description/

public class Leetcode_2558 {

    public static long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i : gifts) {
            pq.add(i);
        }

        while (k-- > 0) {
            int poll = pq.poll();
            double floor = Math.floor(Math.sqrt(poll));
            pq.add((int) floor);
        }

        long sum = 0;
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(pickGifts(new int[]{25, 64, 9, 4, 100}, 4));
        System.out.println(pickGifts(new int[]{1, 1, 1, 1}, 4));
    }
}
