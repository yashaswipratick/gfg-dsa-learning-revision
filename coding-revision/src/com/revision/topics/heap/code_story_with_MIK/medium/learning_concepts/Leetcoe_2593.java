package com.revision.topics.heap.code_story_with_MIK.medium.learning_concepts;

import java.util.Comparator;
import java.util.PriorityQueue;

// PL - https://leetcode.com/problems/find-score-of-an-array-after-marking-all-elements/description/
// VL - https://www.youtube.com/watch?v=VsMVlAPolXw&list=PLpIkg8OmuX-IkxvvfOeZp-Ot0UWHMGAT-&index=23&t=152s
public class Leetcoe_2593 {

    public static long findScore(int[] nums) {


        //(Leetcoe_2593Pair pair) -> pair.value) compares value and keeps min on top
        // .thenComparingInt(p -> p.idx) -> if 2 elements are same then smaller index element will be on top.
        PriorityQueue<Leetcoe_2593Pair> pq = new PriorityQueue<>(
                Comparator.comparingInt((Leetcoe_2593Pair pair) -> pair.value).thenComparingInt(p -> p.idx));
        boolean[] visited = new boolean[nums.length];
        long score = 0;
        for (int i = 0; i < nums.length; i++) {
            pq.add(new Leetcoe_2593Pair(nums[i], i));
        }

        while (!pq.isEmpty()) {
            Leetcoe_2593Pair poll = pq.poll();
            if (!visited[poll.idx]) {
                score += poll.value;
                visited[poll.idx] = true;
                if (poll.idx > 0) {
                    visited[poll.idx - 1] = true;
                }
                if (poll.idx < nums.length - 1) {
                    visited[poll.idx + 1] = true;
                }
            }
        }
        return score;
    }

    public static void main(String[] args) {
        System.out.println(findScore(new int[]{2, 1, 3, 4, 5, 2}));
        System.out.println(findScore(new int[]{2, 3, 5, 1, 3, 2}));
        System.out.println(findScore(new int[]{2, 5, 6, 6, 10}));
    }
}

class Leetcoe_2593Pair {
    int value;
    int idx;

    public Leetcoe_2593Pair(int value, int idx) {
        this.value = value;
        this.idx = idx;
    }
}