package com.revision.topics.heap.practise.easy;

import java.util.PriorityQueue;

// PL - https://leetcode.com/problems/minimum-number-game/description/

public class Leetcode_2974 {

    public static int[] numberGame(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i : nums) {
            pq.add(i);
        }

        int i = 0;
        while (!pq.isEmpty()) {
            int first = pq.poll();
            int second = pq.poll();
            nums[i++] = second;
            nums[i++] = first;
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
        print(numberGame(new int[]{5,4,2,3}));
        print(numberGame(new int[]{2,5}));
    }
}
