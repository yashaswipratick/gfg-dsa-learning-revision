package com.revision.topics.hashing.gfg.medium.prefixSumAndHashing.revision;

import java.util.HashMap;

public class SubArrayWithGivenSumRevision {

    public static int subArraySum(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int prefixSum = 0;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            if (prefixSum == k) {
                count++;
            }
            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
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
