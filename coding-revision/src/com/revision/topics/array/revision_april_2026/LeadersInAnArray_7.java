package com.revision.topics.array.revision_april_2026;

import java.util.ArrayList;

public class LeadersInAnArray_7 {

    private static ArrayList<Integer> leaders(int arr[]) {
        ArrayList<Integer> list = new ArrayList<>();

        int leader = -1;
        leader = arr[arr.length-1];
        list.add(arr[arr.length-1]);

        for (int i = arr.length-2; i >= 0; i--) {
            if (arr[i] >= leader) {
                list.add(0, arr[i]);
                leader = arr[i];
            }
        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println(leaders(new int[]{16, 17, 4, 3, 5, 2}));
        System.out.println(leaders(new int[]{10, 4, 2, 4, 1}));
        System.out.println(leaders(new int[]{5, 10, 20, 40}));
        System.out.println(leaders(new int[]{30, 10, 10, 5}));
    }
}
