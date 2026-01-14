package com.revision.topics.binary_serach.easy;

// Pl - https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/submissions/1876748130/
public class Leetcode_2529 {

    public static int maximumCount(int[] nums) {
        if (nums[0] > 0) return nums.length;

        int negLastIndex = findNegativeIndex(nums);
        int posLastIndex = findPositiveIndex(nums);
        int posIndex = nums.length - posLastIndex;
        return Math.max(negLastIndex + 1, posIndex);
    }

    private static int findNegativeIndex(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int index = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= 0) {
                end = mid - 1;
            } else {
                start = mid + 1;
                index = mid;
            }
        }
        return index;
    }

    private static int findPositiveIndex(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int index = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= 0) {
                start = mid + 1;
                index = start;
            } else {
                end = mid - 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(maximumCount(new int[]{-2, -1, -1, 1, 2, 3}));
        System.out.println(maximumCount(new int[]{-3,-2,-1,0,0,1,2}));
        System.out.println(maximumCount(new int[]{5,20,66,1314}));
        System.out.println(maximumCount(new int[]{0, 5,20,66,1314}));
        System.out.println(maximumCount(new int[]{-1, 0, 5, 20, 66, 1314}));
        System.out.println(maximumCount(new int[]{-2, -1, -1}));
        System.out.println(maximumCount(new int[]{-2}));
        System.out.println(maximumCount(new int[]{-2,0}));
    }
}
