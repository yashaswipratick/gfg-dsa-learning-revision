package com.revision.topics.array.revision;

// PL - https://www.geeksforgeeks.org/problems/max-circular-subarray-sum-1587115620/1
// PL - https://leetcode.com/problems/maximum-sum-circular-subarray/
// VL - https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Arrays/video/MTQ2NDU%3D
public class MaximumCircularSumSubarray {

    /**
     * Approach
     * The idea is to modify Kadane's algorithm to find a minimum contiguous subarray sum and the maximum contiguous subarray sum,
     * then check for the maximum value between the max_value and the value left after subtracting min_value from the total sum
     *
     * Maximum Sum of a Normal Array (Using Kadane)
     * Minimum Sum of a Normal Array (Using Kadane's - just replace Math.max with Math.min)
     * @param arr
     * @return
     */

    //The idea is to modify Kadane's algorithm to find a minimum contiguous subarray sum and
    // the maximum contiguous subarray sum, then check for the maximum value between the max_value
    // and the value left after subtracting min_value from the total sum.


    /**
     * Find maximum sum of array using kadane's algorithm
     * check if maxSum < 0 then maxSum is the answer
     * Find minimum sum of array using reverse kadane's algorithm
     * Find total sum of array.
     * To get the min value from an array subtract minSum from totalSum.
     * Return the result as max(maxSum, min)
     */

    public static int maxCircularSum(int arr[]) {
        //Find the maximum Sum Subarray maxSum
        int maxSum = maxSumSubarray(arr);
        if (maxSum < 0) {
            return maxSum;
        }
        //Find the minimum Sum Subarray minSum
        int minSum = minSumSubarray(arr);

        //Find the totalSum
        int totalSum = 0;
        for (int i = 0; i < arr.length; i++) {
            totalSum += arr[i];
        }

        //To find minimum value subtract the result of minimum Sum Subarray from total sum.
        int min = totalSum - minSum;

        //Return the maximum of min and maxSum
        return Math.max(min, maxSum);
    }

    //Kadane's Algorithm to find max sum subarray
    //Maximum Sum of a Normal Array (Using Kadane)
    private static int maxSumSubarray(int[] arr) {
        int maxEnding = arr[0];
        int res = arr[0];

        for (int i = 1; i < arr.length; i++) {
            maxEnding = Math.max(arr[i], maxEnding + arr[i]);
            res = Math.max(maxEnding, res);
        }
        return res;
    }

    //Kadane's Algorithm to find min sum subarray
    //Minimum Sum of a Normal Array (Using Kadane's - just replace Math.max with Math.min)
    private static int minSumSubarray(int[] arr) {
        int minEnding = arr[0];
        int res = arr[0];

        for (int i = 1; i < arr.length; i++) {
            minEnding = Math.min(arr[i], minEnding + arr[i]);
            res = Math.min(minEnding, res);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxCircularSum(new int[]{8, -8, 9, -9, 10, -11, 12}));
        System.out.println(maxCircularSum(new int[]{10, -3, -4, 7, 6, 5, -4, -1}));
        System.out.println(maxCircularSum(new int[]{-1, 40, -14, 7, 6, 5, -4, -1}));
        System.out.println(maxCircularSum(new int[]{-5, -3}));
        System.out.println(maxCircularSum(new int[]{8, 3}));
    }
}
