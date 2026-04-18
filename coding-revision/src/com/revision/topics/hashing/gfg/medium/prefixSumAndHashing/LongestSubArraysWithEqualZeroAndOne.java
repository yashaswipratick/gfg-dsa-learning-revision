package com.revision.topics.hashing.gfg.medium.prefixSumAndHashing;

import java.util.HashMap;
import java.util.Map;

// PL - https://www.geeksforgeeks.org/problems/largest-subarray-of-0s-and-1s/1
// VL - https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Hashing/video/MjcwNA%3D%3D
public class LongestSubArraysWithEqualZeroAndOne {

    public static int maxLen(int[] array) {

        //Replace every 0 with -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = -1;
            }
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        int sum = 0;
        int res = 0;

        //After replacing every 0 with -1, The problem converted to the problem of finding
        //length of longest subarray with 0 sum.

        //Below is the code for the same - below code same as SubArrayWithGivenSum with little variation
        // in this SubArrayWithGivenSum it asked for coount but in current problem it is asked for max length
        // only change is we are using HashMap here and storing current index value for all the calculated
        // prefix sum at each index if the value not present in map.
        // Remember we store index of that calculated prefix sum and not overriding it with same value
        // because we need the longest length.
        for (int i = 0; i < array.length; i++) {

            //calculate the prefix sum at every index
            prefixSum += array[i];

            //check if prefixSum equals to sum(0) then res will be current index + 1
            if (prefixSum == sum) {
                res = i + 1;
            }

            //check if prefixSum - sum present inside map the res will be
            // max of current index - the index stored inside map for prefixSum - sum
            if (map.containsKey(prefixSum - sum)) {
                res = Math.max(res, i-map.get(prefixSum - sum));
            }

            // store the prefixSum value if not present in the map with current index.
            map.putIfAbsent(prefixSum, i);
        }
        return res;
    }

    public int maxLenNaive(int[] array) {

        int max = 0;
        for (int i = 0; i < array.length; i++) {
            int countZero = 0;
            int countOne = 0;
            for (int j = i; j < array.length; j++) {
                if (array[j] == 0) {
                    countZero++;
                } else {
                    countOne++;
                }
                if (countZero == countOne) {
                    Math.max(max, countZero + countOne);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxLen(new int[]{1, 0, 1, 1, 1, 0, 0})); // output = 6
        System.out.println(maxLen(new int[]{0, 0, 1, 1, 0})); // output = 4
    }
}
