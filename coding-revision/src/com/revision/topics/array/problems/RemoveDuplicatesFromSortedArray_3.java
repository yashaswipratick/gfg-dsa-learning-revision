package com.revision.topics.array.problems;

import java.util.ArrayList;

//VL - https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Arrays/video/MTQzMw%3D%3D
//PL - https://www.geeksforgeeks.org/problems/remove-duplicate-elements-from-sorted-array/1
public class RemoveDuplicatesFromSortedArray_3 {

    static ArrayList<Integer> removeDuplicates(int[] arr) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for(int i  = 1; i<arr.length; i++) {
            if(arr[i-1] != arr[i]) {
                list.add(arr[i]);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{2, 2, 2, 2, 2}));
        System.out.println(removeDuplicates(new int[]{1, 2, 4}));
    }
}
