package com.revision.topics.hashing.gfg.medium.practice;

import java.util.HashMap;

// PL - https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Hashing/problem/count-subarrays-with-equal-number-of-1s-and-0s-1587115620
public class SubArrayWithEqualZeroAndOne {

    public static int countSubarray(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        for(int i = 0; i<arr.length; i++) {
            //convert 0 to -1
            int val = (arr[i] == 0) ? -1 : 1;

            prefixSum += val;
            count += map.get(prefixSum) == null ? 0 : map.get(prefixSum);
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSubarray(new int[]{1, 0, 0, 1, 0, 1, 1}));
        System.out.println(countSubarray(new int[]{1, 1, 1, 1, 0}));
    }
}
