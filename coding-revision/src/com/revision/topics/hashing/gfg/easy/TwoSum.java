package com.revision.topics.hashing.gfg.easy;

import java.util.HashSet;
import java.util.Set;

// PL - https://www.geeksforgeeks.org/problems/key-pair5616/1
public class TwoSum {

    static boolean twoSum(int arr[], int target) {
        Set<Integer> set = new HashSet<>();

        for (int i : arr) {
            int diff = target - i;
            if (set.contains(diff)) {
                return true;
            } else {
                set.add(i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(twoSum(new int[]{0, -1, 2, -3, 1}, -2));
        System.out.println(twoSum(new int[]{1, -2, 1, 0, 5}, 0));
        System.out.println(twoSum(new int[]{11}, 11));
    }
}
