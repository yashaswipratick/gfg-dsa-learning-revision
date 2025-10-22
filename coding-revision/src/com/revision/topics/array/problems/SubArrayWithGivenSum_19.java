package com.revision.topics.array.problems;

// VL - https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Arrays/video/MTQ2NTk%3D
public class SubArrayWithGivenSum_19 {

    /**
     * Approach - sliding window technique
     *
     * calculate the sum using element at current index
     * if sum is greater than target then run loop to start removing elements from 0th index until cur sum is less than target
     * then check at each index if sum == target. If yes return true else return false.
     * @param arr
     * @param target
     * @return
     */
    static boolean isSubarraySum(int[] arr, int target) {
        int j = 0;
        int i = 0;
        int sum = 0;

        while (j <= arr.length) {
            sum += arr[j];
            while (sum > target) {
                sum -= arr[i];
                i++;
            }
            if (sum == target) {
                return true;
            }
            j++;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isSubarraySum(new int[]{4, 8, 12, 5}, 17));
        System.out.println(isSubarraySum(new int[]{1, 4, 20, 3, 10, 5}, 33));
    }
}
