package com.revision.topics.array.revision_april_2026;

import java.util.ArrayList;

public class RemoveDuplicatesFromSortedArray_3 {

    private static ArrayList<Integer> removeDuplicates(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i-1] != arr[i]) {
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
