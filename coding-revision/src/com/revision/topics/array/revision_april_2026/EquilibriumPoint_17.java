package com.revision.topics.array.revision_april_2026;

public class EquilibriumPoint_17 {

    private static int pivotIndex(int[] nums) {
        int totalSum = 0;
        for (int i : nums) {
            totalSum += i;
        }

        int leftSum = 0;

        for (int i = 0; i < nums.length; i++) {
            totalSum = totalSum - nums[i];

            if (leftSum == totalSum) {
                return i;
            }
            
            leftSum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{3, 4, 8, -9, 9, 7}));
        System.out.println(pivotIndex(new int[]{1, 2, 0, 3}));
        System.out.println(pivotIndex(new int[]{1, 1, 1, 1}));
        System.out.println(pivotIndex(new int[]{1, 1, 1, 1}));
        System.out.println(pivotIndex(new int[]{-7, 1, 5, 2, -4, 3, 0}));
    }
}
