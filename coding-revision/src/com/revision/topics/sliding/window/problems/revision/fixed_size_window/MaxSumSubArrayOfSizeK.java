package com.revision.topics.sliding.window.problems.revision.fixed_size_window;

// PL - https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1
// VL - https://www.youtube.com/watch?v=KtpqeN0Goro&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=3
public class MaxSumSubArrayOfSizeK {

    public static int maxSubarraySum(int[] arr, int k) {
        int i = 0;
        int j = 0;
        int maxSum = 0;
        int sum = 0;

        while(j < arr.length) {
            sum += arr[j];

            if(j-i+1 < k) {
                j++;
            } else if(j-i+1 == k) {
                maxSum = Math.max(sum, maxSum);
                sum -= arr[i];
                i++;
                j++;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maxSubarraySum(new int[]{100, 200, 300, 400}, 2));
        System.out.println(maxSubarraySum(new int[]{1, 4, 2, 10, 23, 3, 1, 0, 20}, 4));
        System.out.println(maxSubarraySum(new int[]{100, 200, 300, 400}, 1));
    }
}
