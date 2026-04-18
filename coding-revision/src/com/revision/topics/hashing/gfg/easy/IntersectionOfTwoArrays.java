package com.revision.topics.hashing.gfg.easy;

import java.util.HashSet;

// PL - https://www.geeksforgeeks.org/problems/intersection-of-two-arrays2404/1
// Practice - https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Hashing/problem/intersection-of-two-arrays2404
public class IntersectionOfTwoArrays {

    public static int intersectSize(int a[], int b[]) {
        // Your code here
        int count = 0;
        HashSet<Integer> set = new HashSet<>();

        for(int i : a) {
            set.add(i);
        }

        for (int i : b) {
            if (set.contains(i)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(intersectSize(new int[]{89, 24, 75, 11, 23}, new int[]{89, 2, 4}));
        System.out.println(intersectSize(new int[]{1, 2, 4, 3, 5, 6}, new int[]{3, 4, 5, 6, 7}));
        System.out.println(intersectSize(new int[]{20, 10, 30, 50, 40}, new int[]{15, 25, 30, 20, 35}));
    }
}
