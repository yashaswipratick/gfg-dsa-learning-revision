package com.revision.topics.heap.code_story_with_MIK.medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// PL - https://leetcode.com/problems/top-k-frequent-elements/description/
// VL - https://www.youtube.com/watch?v=GLw4WbJdYLw&list=PLpIkg8OmuX-IkxvvfOeZp-Ot0UWHMGAT-&index=6
public class Leetcode_347 {

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue =
                new PriorityQueue<>(((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue())));
        priorityQueue.addAll(map.entrySet());

        int[] res = new int[k];
        int i = 0;
        while (!priorityQueue.isEmpty() && k > 0) {
            res[i] = priorityQueue.poll().getKey();
            k--;
            i++;
        }
        return res;
    }
    public static void main(String[] args) {
        int[] ints = topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        for (int i : ints) {
            System.out.println(i);
        }
        int[] ints1 = topKFrequent(new int[]{1,2,1,2,1,2,3,1,3,2}, 2);
        for (int i : ints1) {
            System.out.println(i);
        }
        int[] ints2 = topKFrequent(new int[]{1}, 1);
        for (int i : ints2) {
            System.out.println(i);
        }
    }
}
