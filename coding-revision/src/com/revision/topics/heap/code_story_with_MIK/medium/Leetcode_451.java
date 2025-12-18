package com.revision.topics.heap.code_story_with_MIK.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// PL - https://leetcode.com/problems/sort-characters-by-frequency/description/
// VL - https://www.youtube.com/watch?v=HwCYa1_2vkU&list=PLpIkg8OmuX-IkxvvfOeZp-Ot0UWHMGAT-&index=2
public class Leetcode_451 {

    // TODO - Revisit again
    public String frequencySort(String s) {

        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));
        pq.addAll(map.entrySet());

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> poll = pq.poll();
            sb.append(String.valueOf(poll.getKey()).repeat(poll.getValue()));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Leetcode_451 leetcode451 = new Leetcode_451();
        System.out.println(leetcode451.frequencySort("tree"));
        System.out.println(leetcode451.frequencySort("cccaaa"));
        System.out.println(leetcode451.frequencySort("Aabb"));
    }
}