package com.revision.topics.sliding.window.problems.variable_size_window;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

// PL - https://leetcode.com/problems/subarrays-with-k-different-integers/
// VL - https://www.youtube.com/watch?v=seOKHXB_w74&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=12
public class SubArraysWithKDifferentIntegers {
    //variation - Pick Toys, Fruits into basket, Find longest substring with 2 unique characters

    /**
     * Approach
     * Define a helper function that calculates the number of subarrays with at most K distinct elements using a sliding window.
     * Initialize two pointers to represent the sliding window boundaries.
     * Maintain a frequency map to track the count of each number in the window.
     * Expand the window to the right by iterating over the array.
     * If the current element is new to the window (i.e., not in the frequency map or has zero count), decrement the K counter.
     * While K becomes negative (i.e., more than K distinct elements),
     *  shrink the window from the left until the constraint is restored.
     * At each step, the number of valid subarrays ending at the current right index is (right - left + 1).
     *  Accumulate this count.
     * Once you have the count for at most K and at most K-1, subtract to get the final result.
     */
    // TODO - Revise
    public static int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k-1);
    }

    private static int helper(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0, count = 0;

        // Traverse the array with right pointer
        for (int right = 0; right < nums.length; right++) {
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);
            if (freq.get(nums[right]) == 1) {
                k--;
            }

            // Shrink the window if K becomes negative
            while (k < 0) {
                freq.put(nums[left], freq.get(nums[left]) - 1);
                if (freq.get(nums[left]) == 0) {
                    k++;
                }
                left++;
            }

            count += (right - left + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraysWithKDistinct(new int[]{1,2,1,2,3}, 2));
        System.out.println(subarraysWithKDistinct(new int[]{1,2,1,3,4}, 3));
    }
}


