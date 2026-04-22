package com.revision.topics.array.revision_april_2026;

public class MaximumSumSubarray_12 {

    private static int maxSubArray(int[] nums) {
        int max = nums[0];
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            max = Math.max(nums[i], max + nums[i]);
            res = Math.max(res, max);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArray(new int[]{1}));
        System.out.println(maxSubArray(new int[]{5, 4, -1, 7, 8}));
    }
}
