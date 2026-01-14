package com.revision.topics.binary_serach.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// PL - https://leetcode.com/problems/find-target-indices-after-sorting-array/description/
public class Leetcode_2089 {

    public static List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i<nums.length; i++ ) {
            if(nums[i] == target) {
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(targetIndices(new int[]{1, 2, 5, 2, 3}, 2));
        System.out.println(targetIndices(new int[]{1, 2, 5, 2, 3}, 3));
        System.out.println(targetIndices(new int[]{1,2,5,2,3}, 5));
    }
}
