package com.revision.topics.hashing.gfg.medium.prefixSumAndHashing;

import java.util.HashSet;

// PL - https://www.geeksforgeeks.org/problems/subarray-with-0-sum-1587115621/1
// VL - https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Hashing/video/MTQ5MDY%3D
public class SubArrayWithZeroSum {

    // TODO - Revisit

    /**
     * Approach
     * Take a hashset
     * initialise prefix sum variable to 0;
     * Run loop till arr length from 0
     * calculate prefixSum at every index
     * Two condition to check
         * if set contains prefix sum return true.
         * if prefixSum becomes zero return true.
     * At every index keep on adding prefixSum value in set in the last
     * @param arr
     * @return
     */
    static boolean findsum(int arr[]) {
        // Your code here

        HashSet<Integer> set = new HashSet<>();
        int prefixSum = 0;
        for (int i = 0; i < arr.length; i++) {
            //calculate prefixSum at every index
            prefixSum += arr[i];

            if (set.contains(prefixSum)) {
                return true;
            }

            if (prefixSum == 0) {
                return true;
            }
            set.add(prefixSum);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(findsum(new int[]{4, 2, -3, 1, 6}));
        System.out.println(findsum(new int[]{4, 2, 0, 1, 6}));
        System.out.println(findsum(new int[]{1, 2, -1}));
    }
}
