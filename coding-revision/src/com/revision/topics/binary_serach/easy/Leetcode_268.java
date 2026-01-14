package com.revision.topics.binary_serach.easy;

import java.util.Arrays;

// PL - https://leetcode.com/problems/missing-number/
public class Leetcode_268 {

    public static int missingNumber(int[] nums) {
        //optimised formula based approach
        /*int actualSum = (nums.length * (nums.length + 1)) / 2;
        int expectedSum = 0;
        for (int i : nums) {
            expectedSum += i;
        }
        return actualSum - expectedSum;*/

        //Binary search approach
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length-1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == mid) {
                start = mid + 1;
            } else if (nums[mid] > mid) {
                end = mid - 1;
            }
        }
        return end + 1;
    }


    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{3, 0, 1}));
        System.out.println(missingNumber(new int[]{0, 1}));
        System.out.println(missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
    }
}
