package com.revision.topics.array.problems;

import java.util.Arrays;

// PL - https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Arrays/problem/mean-and-median-1587115620
public class MeanAndMedian_23 {

    public static int mean(int[] arr) {
        // code here
        int sum = 0;

        for(int i : arr) {
            sum += i;
        }
        return sum/arr.length;
    }

    public static int median(int[] arr) {
        Arrays.sort(arr);
        if(arr.length % 2 == 0) {
            return (arr[(arr.length / 2)] + arr[(arr.length / 2) - 1]) / 2;
        } else {
            return arr[arr.length / 2];
        }
    }

    public static void main(String[] args) {
        System.out.println(mean(new int[]{2}));
        System.out.println(median(new int[]{2}));

        System.out.println(mean(new int[]{2,3}));
        System.out.println(median(new int[]{2,3}));

        System.out.println(mean(new int[]{1, 2, 19, 28, 5}));
        System.out.println(median(new int[]{1, 2, 19, 28, 5}));

        System.out.println(mean(new int[]{2, 8, 3, 4}));
        System.out.println(median(new int[]{2, 8, 3, 4}));
    }
}
