package com.revision.topics.array.revisit.important_concept;

//PL - https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Arrays/problem/maximum-index-1587115620
//VL - watch the editorial of the problem
public class MaximumIndex_25 {

    /**
     * Initialise a right array to calaculate and store the maximum element at each index.
     * Run a loop in reverse till 0 and store max(right[i+1], arr[i]) in right of i at each index.
     * initialise i and j with 0.
     * initialise maxDiff with Integer.MIN_VALUE.
     * run the loop until i and j is less than length of array
     * In every iteration
     *      * if arr[i] is less than or equal to right[i]
     *          * calculate maxDiff by taking max(maxDiff, j-i).
     *          * increment j by 1.
     *      * else
     *          * increment i by 1.
     * return the result stored in maxDiff.
     * @param arr
     * @return
     */
    //TODO - REVISIT - 26 Oct 2025 - important concept
    static int maxIndexDiff(int[] arr) {
        int[] right = new int[arr.length];

        right[arr.length - 1] = arr[arr.length-1];
        for (int i = arr.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i+1], arr[i]);
        }

        int i = 0;
        int j = 0;
        int maxDiff = Integer.MIN_VALUE;
        while (i < arr.length && j < arr.length) {
            if (arr[i] <= right[j]) {
                maxDiff = Math.max(maxDiff, j-i);
                j++;
            } else {
                i++;
            }
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        System.out.println(maxIndexDiff(new int[]{34, 8, 10, 3, 2, 80, 30, 33, 1}));
        System.out.println(maxIndexDiff(new int[]{1,10}));
        System.out.println(maxIndexDiff(new int[]{5, 4, 3}));
    }
}

/**
 *  Key Observations:
 * You want the largest j - i such that arr[i] < arr[j].
 * So you're trying to maximize the gap while still satisfying the condition.
 *
 * Thinking Process & Hint:
 * 1. Preprocessing Can Help:
 * Think of tracking:
        * The minimum value so far from the left (prefix min array).
         * The maximum value so far from the right (suffix max array).
 * 2. Idea of Two-Pointer Approach:
 *
 * Once you have:
    * leftMin[i] = minimum value from index 0 to i
    * rightMax[j] = maximum value from index j to n-1
 * Now you can use two pointers i and j to scan the array:
    * If leftMin[i] < rightMax[j], it's a valid pair → update maxDiff = j - i, and try to increase j to make the gap larger.
    * Else, increase i.
 *
 * Tiny Hint to Push Your Thinking:
 * If brute-force loops are slow, ask:
    * Can I precompute useful information (like min/max at each side)?
    * Can I use two pointers, one moving from left and one from right, to reduce the work?
 * This pattern is often used in array range problems, maximum gap, and greedy optimizations.
 *
 * why we are pointing i and j both to 0
     * We want to compare the smallest value seen so far (left[i]) with the largest value from future indexes (right[j]).
     * By starting both pointers at 0, we're checking from the leftmost possible valid i and j.
     * We slide j forward to check for larger spans as long as left[i] < right[j].
     * We're essentially looking for the widest (j - i) gap where the condition holds true.
 */
