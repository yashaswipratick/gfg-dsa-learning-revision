package com.revision.topics.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// PL - https://leetcode.com/problems/top-k-frequent-elements/
// VL - https://www.youtube.com/watch?v=7VoJn544QrM&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=6
public class TopKFrequentElements {

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.right));

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(new Pair(entry.getKey(), entry.getValue()));
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] res = new int[pq.size()];
        int i = 0;
        while (!pq.isEmpty()) {
            res[i] = pq.poll().left;
            i++;
        }
        return res;
    }

    static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] res1 = topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        print(res1);
        int[] res2 = topKFrequent(new int[]{1}, 1);
        print(res2);
        int[] res3 = topKFrequent(new int[]{1, 2, 1, 2, 1, 2, 3, 1, 3, 2}, 2);
        print(res3);
    }
}
