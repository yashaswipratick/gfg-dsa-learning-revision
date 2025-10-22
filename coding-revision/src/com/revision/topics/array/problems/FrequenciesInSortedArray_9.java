package com.revision.topics.array.problems;

import java.util.HashMap;

//PL - https://www.geeksforgeeks.org/problems/find-the-frequency/1
public class FrequenciesInSortedArray_9 {

    static HashMap<Integer, Integer> findFrequency(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        return map;
    }

    static void findAndPrintFrequency(int[] arr) {
        int freq = 1;
        for (int i = 1; i< arr.length; i++) {
            if (arr[i] == arr[i-1]) {
                freq++;
            } else {
                System.out.println(arr[i-1] + " -- " + freq);
                freq = 1;
            }
        }
        System.out.println(arr[arr.length-1] + " -- " + freq);
    }

    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        System.out.println(findFrequency(new int[]{10, 10, 10, 25, 30, 30}));
        findAndPrintFrequency(new int[]{10, 10, 10, 25, 30, 30});
    }
}
