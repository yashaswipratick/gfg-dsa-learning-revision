package com.revision.topics.heap.practise.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// PL - https://leetcode.com/problems/reduce-array-size-to-the-half/description/

public class Leetcode_1338 {

    public static int minSetSize(int[] arr) {
        int count = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        if (map.size() == 1) {
            return 1;
        }
        int sum = map.values().stream().mapToInt(value -> value).sum();
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));
        pq.addAll(map.entrySet());

        int k = arr.length / 2;

        while (!pq.isEmpty() && sum > k) {
            Map.Entry<Integer, Integer> poll = pq.poll();
            sum -= poll.getValue();
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        /*System.out.println(minSetSize(new int[]{3, 3, 3, 3, 5, 5, 5, 2, 2, 7}));
        System.out.println(minSetSize(new int[]{7, 7, 7, 7, 7, 7}));*/
        System.out.println(minSetSize(new int[]{1, 9}));
    }
}
