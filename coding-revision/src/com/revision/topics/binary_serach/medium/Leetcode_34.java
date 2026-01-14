package com.revision.topics.binary_serach.medium;

// PL - https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
public class Leetcode_34 {

    public static int[] searchRange(int[] nums, int target) {
        int startIndex = findStartingPosition(nums, target);
        int endIndex = findEndingPosition(nums, target);
        int[] arr = new int[2];
        arr[0] = startIndex;
        arr[1] = endIndex;
        return arr;
    }

    private static int findStartingPosition(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int position = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                position = mid;
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return position;
    }

    private static int findEndingPosition(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int position  = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                position = mid;
                start = mid + 1;
            }  else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return position;
    }

    public static void main(String[] args) {
        int[] res1 = searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println(res1[0] + " " + res1[1]);
        int[] res2 = searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);
        System.out.println(res2[0] + " " + res2[1]);
    }
}
