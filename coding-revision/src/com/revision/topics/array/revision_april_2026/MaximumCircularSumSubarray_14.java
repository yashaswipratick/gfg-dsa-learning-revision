package com.revision.topics.array.revision_april_2026;

public class MaximumCircularSumSubarray_14 {

    private static int maxCircularSum(int arr[]) {
        int maxSum = maxSubarraySum(arr);

        if (maxSum < 0) {
            return maxSum;
        }

        int minSum = minSubarraySum(arr);

        int totalSum = 0;
        for (int i = 0; i < arr.length; i++) {
            totalSum += arr[i];
        }

        int min = totalSum - minSum;

        return Math.max(min, maxSum);
    }

    private static int maxSubarraySum(int[] arr) {
        int max= arr[0];
        int res= arr[0];

        for (int i = 1; i < arr.length; i++) {
            max = Math.max(arr[i], max + arr[i]);
            res = Math.max(res, max);
        }
        return res;
    }

    private static int minSubarraySum(int[] arr) {
        int min = arr[0];
        int res= arr[0];

        for (int i = 1; i < arr.length; i++) {
            min = Math.min(arr[i], min + arr[i]);
            res = Math.min(res, min);
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
