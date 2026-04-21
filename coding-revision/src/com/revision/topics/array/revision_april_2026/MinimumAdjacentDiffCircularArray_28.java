package com.revision.topics.array.revision_april_2026;

// PL - https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Arrays/problem/minimum-absloute-difference-between-adjacent-elements-in-a-circular-array-1587115620
public class MinimumAdjacentDiffCircularArray_28 {

    public static int minAdjDiff(int arr[], int n) {
        int diff = Math.abs(arr[arr.length-1] - arr[0]);
        for(int i = 0; i<arr.length-1; i++) {
            int curDiff = Math.abs(arr[i] - arr[i+1]);
            diff = Math.min(curDiff, diff);
        }
        return diff;
    }

    public static void main(String[] args) {
        System.out.println(minAdjDiff(new int[]{8, -8, 9, -9, 10, -11, 12}, 7));         // Output: 4
        System.out.println(minAdjDiff(new int[]{10, -3, -4, 7, 6, 5, -4, -1}, 8));       // Output: 1

// Edge Cases
        System.out.println(minAdjDiff(new int[]{5}, 1));                                 // Output: 0 (Only one element, min diff is 0)
        System.out.println(minAdjDiff(new int[]{5, 5}, 2));                              // Output: 0 (Both elements same)
        System.out.println(minAdjDiff(new int[]{1, 1000}, 2));                           // Output: 999 (Only two elements)
        System.out.println(minAdjDiff(new int[]{-100, -50, -20, -10}, 4));              // Output: 10 (Differences: 50, 30, 10, 90)
        System.out.println(minAdjDiff(new int[]{100, 50, 0, -50, -100}, 5));            // Output: 50 (Differences: 50, 50, 50, 50, 200)

// Random cases
        System.out.println(minAdjDiff(new int[]{1, 3, 6, 10, 15}, 5));                  // Output: 2
        System.out.println(minAdjDiff(new int[]{-1, -5, -3, -4}, 4));                  // Output: 1
        System.out.println(minAdjDiff(new int[]{100, -200, 300, -400, 500}, 5));        // Output: 100
        System.out.println(minAdjDiff(new int[]{0, 0, 0, 0, 0}, 5));                    // Output: 0
        System.out.println(minAdjDiff(new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE}, 2)); // Output: 1 (abs diff wraps to 1 due to overflow handling)

    }
}
