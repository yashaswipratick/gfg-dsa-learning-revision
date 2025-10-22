package com.revision.topics.array.revisit;

// VL - https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Arrays/video/MTU4Ng%3D%3D
public class MinimumConsecutiveFlips_16 {

    /**
     * Efficient Approach:
     * The aim is to do it with one traversal of array
     *
     * An Efficient Solution is based on the below facts :
     *
     * There are only two types of groups (groups of 0s and groups of 1s)
     * Either the counts of both groups are same or the difference between counts is at most 1.
     *
     * For example, in {1, 1, 0, 1, 0, 0} there are two groups of 0s and two groups of 1s.
     * In example, {1, 1, 0, 0, 0, 1, 0, 0, 1, 1}, count of groups of 1 is one more than the counts of 0s.
     *
     * Based on the above facts, we can conclude that if we always flip the second group and other groups
     * that of the same type as the second group, we always get the correct answer.
     * @param arr
     */

    // TODO - REVISIT - 15 Oct 2025
    static void print(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            //first check if previous element is not equal to current element
            if (arr[i] != arr[i-1]) {
                //Check current element is not equal to 0th element, since we are always flipping the 2nd group
                //Take the index as from i to
                if (arr[i] != arr[0]) {
                    System.out.print("From " + i + " ");
                } else {
                    // when if condition not satisfy that means the last flip element lies at i-1 index
                    System.out.println("to " + (i-1));
                }
            }
        }
        // Edge case to handle last element flip
        if (arr[arr.length - 1] != arr[0]) {
            System.out.println("to " + (arr.length-1));
        }
    }

    public static void main(String[] args) {
        print(new int[] {0,0,1,1,0,0,1,1,0});
        print(new int[] {1,0,1,1,0,0,1,1,0});
    }
}
