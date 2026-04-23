package com.revision.topics.binary_serach.revision_april_2026;

public class Leetcode_34 {

    private static int[] searchRange(int[] nums, int target) {
        int firstIndex = findFirstPostion(nums, target);
        int lastIndex = findLastPostion(nums, target);

        int[] arr = new int[2];
        arr[0] = firstIndex;
        arr[1] = lastIndex;
        return arr;
    }

    private static int findFirstPostion(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int res = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                res = mid;
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return res;
    }

    private static int findLastPostion(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int res = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                res = mid;
                start = mid + 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res1 = searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println(res1[0] + " " + res1[1]);
        int[] res2 = searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);
        System.out.println(res2[0] + " " + res2[1]);
        int[] res3 = searchRange(new int[]{}, 0);
        System.out.println(res3[0] + " " + res3[1]);
    }
}
