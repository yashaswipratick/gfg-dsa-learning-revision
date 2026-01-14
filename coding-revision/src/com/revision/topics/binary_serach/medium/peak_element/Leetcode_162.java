package com.revision.topics.binary_serach.medium.peak_element;

// PL - https://leetcode.com/problems/find-peak-element/description
// VL - https://www.youtube.com/watch?v=VFC1oxkn5-E&list=PLICVjZ3X1AcYYdde4GTp79zfdp_VACSkX&index=7&t=78s
public class Leetcode_162 {

    //TODO - Revisit
    public static int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] >= nums[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{1, 2, 3, 1}));
        System.out.println(findPeakElement(new int[]{1,2,1,3,5,6,4}));
    }
}
