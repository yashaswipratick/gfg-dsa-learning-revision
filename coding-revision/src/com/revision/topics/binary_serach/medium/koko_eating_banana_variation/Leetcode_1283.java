package com.revision.topics.binary_serach.medium.koko_eating_banana_variation;

// PL - https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/description
// VL - https://www.youtube.com/watch?v=QQcEIxK-snE&list=PLpIkg8OmuX-LkgtrEF7eyyYWJM3m5tVQY&index=11
public class Leetcode_1283 {

    // TODO - Revisit
    public static int smallestDivisor(int[] nums, int threshold) {
        int start = 1;
        int end = maxInArray(nums);

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (isValidSmallestDivisor(nums, mid, threshold)) {
                end = mid-1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private static boolean isValidSmallestDivisor(int[] nums, long mid, long threshold) {
        long sum = 0;

        for (int i = 0; i < nums.length; i++) {
            long quotient = nums[i] / mid;
            long remainder = 0;
            if (nums[i] % mid > 0) {
                remainder = 1;
            }
            sum += quotient + remainder;
        }
        if (sum > threshold) {
            return false;
        }
        return true;
    }

    private static int maxInArray(int[] piles) {
        int max = 0;
        for (int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(smallestDivisor(new int[]{1, 2, 5, 9}, 6));
        System.out.println(smallestDivisor(new int[]{44, 22, 33, 11, 1}, 5));
    }
}
