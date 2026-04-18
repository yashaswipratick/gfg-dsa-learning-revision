package com.revision.topics.hashing.gfg.easy;

import java.util.HashMap;
import java.util.Map;

// PL - https://www.geeksforgeeks.org/problems/find-distinct-elements--130928/1
public class CountDistinctElement {

    static int distinct(int arr[]) {
        // code here
        Map<Integer, Integer> map = new HashMap<>();

        for(int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        return map.size();
    }
    public static void main(String[] args) {
        System.out.println(distinct(new int[]{2, 2, 3, 2}));
        System.out.println(distinct(new int[]{12, 1, 14, 3, 16}));
        System.out.println(distinct(new int[]{1, 1, 1, 1}));
    }
}
