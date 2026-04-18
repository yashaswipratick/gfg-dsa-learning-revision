package com.revision.topics.hashing.gfg.medium.prefixSumAndHashing;

import java.util.HashMap;

// VL - https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Hashing/video/MjcwMw%3D%3D
// PL - https://www.geeksforgeeks.org/problems/longest-span-with-same-sum-in-two-binary-arrays5142/1
public class LongestCommonSpanInTwoBinaryArrays {

    public static int equalSumSpan(int[] a1, int[] a2) {

        // Convert array into temperoary array
        int[] a3 = new int[a1.length];
        for (int i = 0; i < a1.length; i++) {
            a3[i] = a1[i] - a2[i];
        }

        // converted the problem into subarrayWithZeroSum
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        int sum = 0;
        int res = 0;
        for (int i = 0; i < a3.length; i++) {
            prefixSum += a3[i];

            if (prefixSum == sum) {
                res = i+1;
            }
            if (map.containsKey(prefixSum-sum)) {
                res = Math.max(res, i - map.get(prefixSum - sum));
            }

            map.putIfAbsent(prefixSum, i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(equalSumSpan(new int[]{0, 1, 0, 0, 0, 0}, new int[]{1, 0, 1, 0, 0, 1}));
        System.out.println(equalSumSpan(new int[]{0, 1, 0, 1, 1, 1, 1}, new int[]{1, 1, 1, 1, 1, 0, 1}));
        System.out.println(equalSumSpan(new int[]{0, 0, 0}, new int[]{1, 1, 1}));
    }
}
