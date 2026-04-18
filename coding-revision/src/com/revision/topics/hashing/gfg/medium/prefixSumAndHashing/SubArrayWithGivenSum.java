package com.revision.topics.hashing.gfg.medium.prefixSumAndHashing;

import java.util.HashMap;
// PL - https://www.geeksforgeeks.org/problems/subarray-range-with-given-sum2804/1
// practice - https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Hashing/problem/subarray-range-with-given-sum0128
// VL - https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Hashing/video/NzgyNw%3D%3D -
// code reference from  old submission and logic understanding from above VL.
public class SubArrayWithGivenSum {

    // TODO - Revisit

/**
 * Approach
 * Take a hashmap
 * initialise prefix sum variable to 0;
 * initialise count variable to 0;
 * Run loop till arr length from 0
 * calculate prefixSum at every index
 * Two condition to check
    * if map contains prefixSum - k, add count to whatever value present in map for prefix
    * if prefixSum == k increment count.
 * At every index keep on adding prefixSum value in map in the last with incremented value.
 */
    public static int subArraySum(int[] arr, int k) {
        int prefixSum = 0;
        int count = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            if (prefixSum == k) {
                count++;
            }
            if (map.containsKey(prefixSum - k)) {
                count+=map.get(prefixSum - k);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(subArraySum(new int[]{10, 2, -2, -20, 10}, -10));
        System.out.println(subArraySum(new int[]{1, 4, 20, 3, 10, 5}, 33));
    }
}
