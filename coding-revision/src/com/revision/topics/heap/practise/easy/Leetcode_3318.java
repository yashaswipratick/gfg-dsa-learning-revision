package com.revision.topics.heap.practise.easy;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// PL - https://leetcode.com/problems/find-x-sum-of-all-k-long-subarrays-i/

public class Leetcode_3318 {

    public static int[] findXSum(int[] nums, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                Comparator.comparingInt((Pair p) -> p.freq).thenComparingInt(p -> p.x));
        Map<Integer, Integer> map = new HashMap<>();
        int[] sum = new int[nums.length - k + 1];

        int j = 0;
        int i = 0;
        int y = 0;

        while (j < nums.length) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                m1(map, pq, x);
                int curSum = 0;
                while (!pq.isEmpty()) {
                    Pair poll = pq.poll();
                    curSum += (poll.x * poll.freq);
                }
                sum[y] = curSum;
                if (map.containsKey(nums[i])) {
                    map.put(nums[i], map.get(nums[i]) - 1);
                }

                if (map.containsKey(nums[i]) && map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }
                i++;
                j++;
                y++;
            }
        }
        return sum;
    }

    private static void m1(Map<Integer, Integer> map, PriorityQueue<Pair> pq, int x) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(new Pair(entry.getKey(), entry.getValue()));
            if (pq.size() > x) {
                pq.poll();
            }
        }
    }

    public static void main(String[] args) {
        int[] xSum = findXSum(new int[]{1, 1, 2, 2, 3, 4, 2, 3}, 6, 2);
        for (int i : xSum) {
            System.out.print(i + " ");
        }
        System.out.println();
        int[] xSum1 = findXSum(new int[]{3, 8, 7, 8, 7, 5}, 2, 2);
        for (int i : xSum1) {
            System.out.print(i + " ");
        }
    }
}

class Pair {
    int x;
    int freq;

    public Pair(int x, int freq) {
        this.x = x;
        this.freq = freq;
    }
}