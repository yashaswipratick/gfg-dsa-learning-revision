package com.revision.topics.hashing.gfg.easy;

import java.util.ArrayList;
import java.util.HashSet;

// PL - http://geeksforgeeks.org/problems/union-of-two-arrays3538/1
// practice - https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Hashing/problem/union-of-two-arrays3538

public class UnionWithDuplicates {

    public static ArrayList<Integer> findUnion(int[] a, int[] b) {
        // code here
        HashSet<Integer> set = new HashSet<>();

        for (int i : a) {
            set.add(i);
        }

        for (int i : b) {
            set.add(i);
        }

        ArrayList<Integer> list = new ArrayList<>(set);
        return list;
    }

    public static void main(String[] args) {
        System.out.println(findUnion(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 2, 3, 3, 2}));
        System.out.println(findUnion(new int[]{1, 2, 3}, new int[]{4, 5, 6}));
        System.out.println(findUnion(new int[]{1, 2, 1, 1, 2}, new int[]{2, 2, 1, 2, 1}));
    }
}
