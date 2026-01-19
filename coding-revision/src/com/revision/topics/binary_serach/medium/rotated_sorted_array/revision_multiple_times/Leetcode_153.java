package com.revision.topics.binary_serach.medium.rotated_sorted_array.revision_multiple_times;

// PL - https://leetcode.com/problems/search-a-2d-matrix/description
public class Leetcode_153 {

    //TODO - Revisit
    public static int findMin(int[] nums) {
        int start = 0;
        int end = nums.length- 1;
        int target = Integer.MAX_VALUE;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[start] <= nums[mid]) {
                target = Math.min(target, nums[start]);
                start = mid + 1;
            } else {
                target = Math.min(target, nums[mid]);
                end = end - 1;
            }
        }
        return target;
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3, 4, 5, 1, 2}));
        System.out.println(findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println(findMin(new int[]{11,13,15,17}));
    }
}
