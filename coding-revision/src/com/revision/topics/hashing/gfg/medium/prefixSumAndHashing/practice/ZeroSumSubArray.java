package com.revision.topics.hashing.gfg.medium.prefixSumAndHashing.practice;

import java.util.HashMap;
import java.util.Map;

// PL - https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Hashing/problem/zero-sum-subarrays1825
public class ZeroSumSubArray {

    public static int findSubarray(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        int prefixSum = 0;
        int count = 0;
        map.put(0,1); // this is important
        for(int i = 0; i<arr.length; i++) {
            prefixSum += arr[i];

            if(map.containsKey(prefixSum)) {
                count += map.get(prefixSum);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(findSubarray(new int[]{0, 0, 5, 5, 0, 0}));
        System.out.println(findSubarray(new int[]{6, -1, -3, 4, -2, 2, 4, 6, -12, -7}));
        System.out.println(findSubarray(new int[]{0}));
    }
}
