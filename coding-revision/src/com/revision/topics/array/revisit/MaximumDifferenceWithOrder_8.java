package com.revision.topics.array.revisit;

// VL - https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Arrays/video/MTE2NQ%3D%3D
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
        int res = arr[1] - arr[0];
        int minVal = arr[0];

        for (int i = 1; i < arr.length; i++) {
            res = Math.max(res, arr[i] - minVal);
            minVal = Math.min(minVal, arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxDiff(new int[]{2, 3, 10, 6, 4, 8, 1}));
    }
}
