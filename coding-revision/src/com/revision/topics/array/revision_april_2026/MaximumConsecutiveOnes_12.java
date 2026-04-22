package com.revision.topics.array.revision_april_2026;

public class MaximumConsecutiveOnes_12 {

    private static int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
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
