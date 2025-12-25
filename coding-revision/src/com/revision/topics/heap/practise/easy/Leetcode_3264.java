package com.revision.topics.heap.practise.easy;

import java.util.Comparator;
import java.util.PriorityQueue;

// PL - https://leetcode.com/problems/final-array-state-after-k-multiplication-operations-i/description/
public class Leetcode_3264 {

    public static int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<Leetcode_3264Pair> pq = new PriorityQueue<>(
                Comparator.comparingInt((Leetcode_3264Pair pair) -> pair.elem)
                        .thenComparingInt(p -> p.idx));

        int idx = 0;
        for (int i : nums) {
            pq.add(new Leetcode_3264Pair(i, idx));
            idx++;
        }

        while (k > 0) {
            Leetcode_3264Pair poll = pq.poll();
            int data = poll.elem * multiplier;
            pq.add(new Leetcode_3264Pair(data, poll.idx));
            k--;
        }
        while (!pq.isEmpty()) {
            Leetcode_3264Pair poll = pq.poll();
            nums[poll.idx] = poll.elem;
        }
        return nums;
    }

    static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        print(getFinalState(new int[]{2, 1, 3, 5, 6}, 5, 2));
        print(getFinalState(new int[]{1,2}, 3, 4));
    }
}

class Leetcode_3264Pair {
    int elem;
    int idx;

    public Leetcode_3264Pair(int elem, int idx) {
        this.elem = elem;
        this.idx = idx;
    }
}
