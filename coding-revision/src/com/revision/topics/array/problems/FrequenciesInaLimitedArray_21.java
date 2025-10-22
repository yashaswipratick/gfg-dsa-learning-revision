package com.revision.topics.array.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// PL - https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Arrays/problem/frequency-of-array-elements-1587115620
public class FrequenciesInaLimitedArray_21 {

    public static List<Integer> frequencyCount(int[] arr) {
        List<Integer> list = new ArrayList<>(Collections.nCopies(arr.length, 0));
        for (int i = 0; i < arr.length; i++) {
            if (list.size() >= arr[i] && list.get(arr[i]-1) != null) {
                list.set(arr[i] - 1, list.get(arr[i]-1) + 1);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        /*System.out.println(frequencyCount(new int[]{2, 3, 2, 3, 5}));
        System.out.println(frequencyCount(new int[]{3, 3, 3, 3}));
        System.out.println(frequencyCount(new int[]{4, 4, 4, 4}));
        System.out.println(frequencyCount(new int[]{1}));
        System.out.println(frequencyCount(new int[]{1, 2, 3, 4, 5}));
        System.out.println(frequencyCount(new int[]{5, 5, 5, 5, 5}));
        System.out.println(frequencyCount(new int[]{1, 1, 1, 1}));*/
        System.out.println(frequencyCount(new int[]{2, 2, 5}));
        System.out.println(frequencyCount(new int[]{1, 2, 3, 4, 5, 1, 2, 3, 4, 5}));
    }
}
