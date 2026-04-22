package com.revision.topics.array.problems;

// VL - https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Arrays/video/MTE2NQ%3D%3D
// PL - https://leetcode.com/problems/maximum-difference-between-increasing-elements/description/
public class MaximumDifferenceWithOrder_8 {

    /**
     * Take res as arr[1] - arr[0] initially
     * take arr[0] as min element
     * at every index starting from 1 take res as max of prev calculated res and arr[i] - minValue
     * Also maintain minVal at every index considering min of minValue and arrays current index element.
     * @param arr
     * @return
     */

    // TODO - REVISIT - 12 Oct 2025
    static int maxDiff(int[] arr) {
        int res = -1;
        int minVal = arr[0]; // store first index element considering it is the smallest in the array

        // start loop from index = 1
        for (int i = 1; i < arr.length; i++) {
            //Get the max of previous stored result and current difference(arr[i], minValue)
            res = Math.max(res, arr[i] - minVal);

            // To calculate max difference the min value should be smallest, so compare current element
            // and previous stored min Value whichever is smallest store it in min value.
            minVal = Math.min(minVal, arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxDiff(new int[]{2, 3, 10, 6, 4, 8, 1}));
        System.out.println(maxDiff(new int[]{7,1,5,4}));
    }
}
