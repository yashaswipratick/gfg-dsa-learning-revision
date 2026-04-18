package com.revision.topics.hashing.gfg.medium.prefixSumAndHashing.revision;

import java.util.HashMap;

public class LongestCommonSpanInTwoBinaryArraysRevision {

    public static int equalSumSpan(int[] a1, int[] a2) {
        int a3[] = new int[a1.length];

        for (int i = 0; i < a1.length; i++) {
            a3[i] = a1[i] - a2[i];
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        int target = 0;
        int max = 0;

        for (int i = 0; i < a3.length; i++) {
            prefixSum += a3[i];

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
        System.out.println(equalSumSpan(new int[]{0, 1, 0, 0, 0, 0}, new int[]{1, 0, 1, 0, 0, 1}));
        System.out.println(equalSumSpan(new int[]{0, 1, 0, 1, 1, 1, 1}, new int[]{1, 1, 1, 1, 1, 0, 1}));
        System.out.println(equalSumSpan(new int[]{0, 0, 0}, new int[]{1, 1, 1}));
    }
}
