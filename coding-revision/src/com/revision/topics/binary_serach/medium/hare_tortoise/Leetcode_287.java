package com.revision.topics.binary_serach.medium.hare_tortoise;

public class Leetcode_287 {

    // The below algorithm is hare and tortoise problem used for detecting cycle in linked list.
    // same concept used here.

    //TODO - Revisit
    public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        slow = nums[slow];
        fast = nums[nums[fast]];

        //Detect cycle
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1, 3, 4, 2, 2}));
        System.out.println(findDuplicate(new int[]{3, 1, 3, 4, 2}));
        System.out.println(findDuplicate(new int[]{3, 3, 3, 3, 3}));
    }
}
