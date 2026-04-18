package com.revision.topics.hashing.gfg.medium.prefixSumAndHashing.revision;

import java.util.HashMap;

public class LongestSubArraysWithEqualZeroAndOneRevision {

    public static int maxLen(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int prefixSum = 0;
        int target = 0;
        int max = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = -1;
            }
        }

        for (int i = 0; i < array.length; i++) {
            prefixSum += array[i];

            if (prefixSum == target) {
                max = i + 1;
            }

            if (map.containsKey(prefixSum - target)) {
                max = Math.max(max, i - map.get(prefixSum - target));
            }
            map.putIfAbsent(prefixSum, i);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxLen(new int[]{1, 0, 1, 1, 1, 0, 0})); // output = 6
        System.out.println(maxLen(new int[]{0, 0, 1, 1, 0})); // output = 4
    }
}
