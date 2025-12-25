package com.revision.topics.heap.practise.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

// PL - https://leetcode.com/problems/find-score-of-an-array-after-marking-all-elements/

public class Leetcode_2593 {

    public static long findScore(int[] nums) {
        PriorityQueue<Leetcode_2593Pair> pq = new PriorityQueue<>(
                Comparator.comparingInt((Leetcode_2593Pair p) -> p.x).thenComparingInt(p -> p.idx));

        long sum = 0;
        boolean[] visited = new boolean[nums.length];

        for (int i = 0; i < nums.length; i++) {
            pq.add(new Leetcode_2593Pair(nums[i], i));
        }

        while (!pq.isEmpty()) {
            Leetcode_2593Pair poll = pq.poll();
            if (!visited[poll.idx]) {
                visited[poll.idx] = true;
                if (poll.idx > 0) {
                    visited[poll.idx - 1] = true;
                }

                if (poll.idx < nums.length - 1) {
                    visited[poll.idx + 1] = true;
                }
                sum += poll.x;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(findScore(new int[]{2, 1, 3, 4, 5, 2}));
        System.out.println(findScore(new int[]{2, 3, 5, 1, 3, 2}));
    }
}

class Leetcode_2593Pair {
    int x;
    int idx;

    public Leetcode_2593Pair(int x, int idx) {
        this.x = x;
        this.idx = idx;
    }
}