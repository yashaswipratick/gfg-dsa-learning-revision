package com.revision.topics.hashing.gfg.medium.prefixSumAndHashing.revision;

import java.util.HashSet;
import java.util.Set;

public class SubArrayWithZeroSumRevision {

    static boolean findSum(int arr[]) {
        Set<Integer> set = new HashSet<>();
        int prefixSum = 0;

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            if (prefixSum == 0) {
                return true;
            }
            if (set.contains(prefixSum)) {
                return true;
            }
            set.add(prefixSum);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(findSum(new int[]{4, 2, -3, 1, 6})); //true
        System.out.println(findSum(new int[]{4, 2, 0, 1, 6})); // true
        System.out.println(findSum(new int[]{1, 2, -1})); // false
    }
}
