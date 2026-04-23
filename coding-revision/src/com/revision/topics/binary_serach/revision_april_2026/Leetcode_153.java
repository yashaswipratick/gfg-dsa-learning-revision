package com.revision.topics.binary_serach.revision_april_2026;

public class Leetcode_153 {

    private static int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int res = Integer.MAX_VALUE;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[start] <= nums[mid]) {
                res = Math.min(nums[start], res);
                start = mid + 1;
            } else {
                res = Math.min(nums[mid], res);
                end = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3, 4, 5, 1, 2}));
        System.out.println(findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println(findMin(new int[]{11,13,15,17}));
    }
}
