package com.revision.topics.array.problems;

import java.util.ArrayList;

// PL - https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Arrays/problem/leaders-in-an-array-1587115620
public class ArrayLeaders_20 {

    static ArrayList<Integer> leaders(int arr[]) {
        ArrayList<Integer> list = new ArrayList<>();

        int max = arr[arr.length - 1];
        for(int i = arr.length - 1; i >= 0; i--) {
            if(arr[i] >= max) {
                max = arr[i];
                list.add(0, max);
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
