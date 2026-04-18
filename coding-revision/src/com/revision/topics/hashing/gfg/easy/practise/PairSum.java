package com.revision.topics.hashing.gfg.easy.practise;

import java.util.HashSet;

// PL - https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Hashing/problem/hashing-for-pair-1
public class PairSum {

    public static int sumExists(int arr[], int N, int sum) {
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i< N; i++) {
            if(set.contains(sum-arr[i])) {
                return 1;
            }
            set.add(arr[i]);
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(sumExists(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 10, 14));
        System.out.println(sumExists(new int[]{2, 5}, 2, 10));
    }
}
