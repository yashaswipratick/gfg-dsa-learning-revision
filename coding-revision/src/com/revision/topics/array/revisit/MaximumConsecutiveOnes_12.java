package com.revision.topics.array.revisit;

//VL - https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Arrays/video/MTU0MTY%3D
//PL - https://leetcode.com/problems/max-consecutive-ones/description/
public class MaximumConsecutiveOnes_12 {

    /**
     * The approach used in the solution is as follows:
     *
     * 1.  **Initialize Variables**:
     *     *   `res`: Stores the maximum number of consecutive ones found so far. Initialize it to `0`.
     *     *   `count`: Stores the current number of consecutive ones as you iterate through the array.
     *     Initialize it to `0`.
     *
     * 2.  **Iterate Through the Array**:
     *     *   Go through each element of the input array from left to right.
     *
     * 3.  **Process Each Element**:
     *     *   **If the current element is `0`**: This means the sequence of consecutive ones is broken.
     *     Reset `count` to `0`.
     *     *   **If the current element is `1`**: This means the sequence of consecutive ones continues.
     *     Increment `count`. After incrementing, update `res` to be the maximum of its current value
     *     and `count`. This ensures `res` always keeps track of the longest sequence found so far.
     *
     * 4.  **Return Result**:
     *     *   After iterating through the entire array, `res` will hold the maximum number of
     *     consecutive ones. Return `res`.
     * @param arr
     * @return
     */
    public static int findMaxConsecutiveOnes(int[] arr) {
        int res = 0;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                count = 0;
            } else {
                count++;
                res = Math.max(res, count);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{1, 1, 0, 0, 1, 1, 1}));
        System.out.println(findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0, 1}));
        System.out.println(findMaxConsecutiveOnes(new int[]{1, 1, 1, 1, 1}));
        System.out.println(findMaxConsecutiveOnes(new int[]{0,0,0}));
    }
}
