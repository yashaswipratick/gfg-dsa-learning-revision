package com.revision.topics.binary_serach.medium.rotated_sorted_array.revision_multiple_times;

// PL - https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description
public class Leetcode_81 {

    // TODO - REVISIT
    public static boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return true;
            } else if (nums[start] == nums[mid] && nums[mid] == nums[end]) { // skip the duplicate until this condition is meeting
                start++;
                end--;
                continue;
            }

            if (nums[start] <= nums[mid]) {// check if left half is sorted
                if (nums[start] <= target && target <= nums[mid]) {
                    end = mid - 1; // eliminate right half as target lies in left half
                } else {
                    start = mid + 1; // eliminate left half as target lies in right half and move right
                }
            } else {
                if (nums[mid] <= target && target <= nums[end]) {
                    start = mid + 1; //eliminate left half as target lies in right half and move right
                } else {
                    end = mid - 1; //eliminate right half as target lies in left half and move left
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0));
        System.out.println(search(new int[]{2,5,6,0,0,1,2}, 3));
    }
}
