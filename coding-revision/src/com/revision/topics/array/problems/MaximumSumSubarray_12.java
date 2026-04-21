package com.revision.topics.array.problems;

// VL - https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Arrays/video/MTQwMg%3D%3D
// Article  - https://www.geeksforgeeks.org/dsa/largest-sum-contiguous-subarray/
// PL - https://leetcode.com/problems/maximum-subarray/description/
public class MaximumSumSubarray_12 {

    // Kadane's algorithm

    /**
     * The approach for implementing Kadane's algorithm to find the maximum sum of a contiguous subarray is as follows:
     *
     * 1.  **Initialize Variables**:
     *     *   `max_so_far`: This variable will store the maximum subarray sum found across the entire array.
     *     Initialize it to the first element of the array. If the array could be empty or contain only
     *     negative numbers, it's often initialized to `Integer.MIN_VALUE` to handle edge cases
     *     where all sums are negative.
     *     *   `current_max`: This variable will store the maximum sum of a subarray *ending at the
     *     current position*. Initialize it to the first element of the array.
     *
     * 2.  **Iterate Through the Array**:
     *     *   Start iterating from the second element of the array (index 1) up to the end.
     *
     * 3.  **Update `current_max`**:
     *     *   For each element `arr[i]`, you have two choices for the maximum sum ending at this position:
     *         *   Either extend the subarray ending at `i-1` by adding `arr[i]` to `current_max`.
     *         *   Or start a new subarray from `arr[i]` itself.
     *     *   So, `current_max = Math.max(current_max + arr[i], arr[i])`.
     *     This ensures that `current_max` always holds the largest sum of a subarray ending at the current index `i`.
     *
     * 4.  **Update `max_so_far`**:
     *     *   After updating `current_max` for the current position, compare it with `max_so_far`.
     *     *   `max_so_far = Math.max(max_so_far, current_max)`. This step updates the overall maximum
     *     sum if the `current_max` is greater.
     *
     * 5.  **Return Result**:
     *     *   After the loop finishes, `max_so_far` will contain the maximum sum of any
     *     contiguous subarray in the entire array. Return `max_so_far`.
     * @param arr
     * @return
     */
    // TODO - REVISIT - 12 Oct 2025
    static int maxSubarraySum(int[] arr) {

        // Maximum sum of subarray ending at current position
        int maxEnding = arr[0];

        // Stores the result (maximum sum found so far)
        int res = arr[0];

        for (int i = 1; i < arr.length; i++) {
            // Either extend the previous subarray or start
            // new from current element
            maxEnding = Math.max(maxEnding + arr[i], arr[i]);

            // Update result if the new subarray sum is larger
            res = Math.max(res, maxEnding);
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(maxSubarraySum(new int[]{2, 3, -8, 7, -1, 2, 3}));
        System.out.println(maxSubarraySum(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
