package com.revision.topics.binary_serach.medium.rotated_sorted_array.revision_multiple_times;

// PL - https://leetcode.com/problems/search-in-rotated-sorted-array/
public class Leetcode_33 {

    // TODO - revisit
    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start+(end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[start] <= nums[mid]) { // check if left half is sorted
                if (target >= nums[start] && target <= nums[mid]) {
                    end = mid - 1; // eliminate right half as target lies in left half
                } else {
                    start = mid + 1; // eliminate left half as target lies in right half and move right
                }
            } else {
                if (target >= nums[mid] && target <= nums[end]) {
                    start = mid + 1; //eliminate left half as target lies in right half and move right
                } else {
                    end = mid - 1; // eliminate right half as target lies in left half and move left
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 3));
        System.out.println(search(new int[]{1}, 0));
    }
}
