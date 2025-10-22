package com.revision.topics.array.problems;

// PL - https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Arrays/problem/check-if-array-is-sorted-and-rotated-clockwise-1587115620
public class CheckIfArrayIsSortedAndRotated_26 {

    // TODO - revisit in 3-5 days
    public static boolean isSortedRotated(int[] arr) {
        int n = arr.length;
        boolean isSortedInc = false;

        for (int i = 0; i < n-1; i++) {
            if (arr[i] < arr[i+1]) {
                isSortedInc = true;
            } else {
                isSortedInc = false;
                break;
            }
        }

        if(isSortedInc) {
             return false;
        }

        int breakInc = 0;
        if (!isSortedInc) {
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i+1]) {
                    breakInc++;
                }
            }
        }
        if (breakInc == 1) {
            return true;
        }

        boolean isSortedDex = false;

        for (int i = 0; i < n-1; i++) {
            if (arr[i] > arr[i+1]) {
                isSortedDex = true;
            } else {
                isSortedDex= false;
                break;
            }
        }

        if(isSortedDex) {
            return false;
        }

        int breakDec= 0;
        if (!isSortedDex) {
            for (int i = 0; i < n-1; i++) {
                if (arr[i] < arr[i+1]) {
                    breakDec++;
                }
            }
        }
        if (breakDec == 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isSortedRotated(new int[]{3, 4, 1, 2})); // true
        System.out.println(isSortedRotated(new int[]{1, 2, 3}));     // false
        System.out.println(isSortedRotated(new int[]{5, 4, 3}));     // false
        System.out.println(isSortedRotated(new int[]{2, 3, 4, 5, 1})); // true

    }
}
