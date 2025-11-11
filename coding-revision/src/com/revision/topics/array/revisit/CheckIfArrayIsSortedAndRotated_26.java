package com.revision.topics.array.revisit;

// PL - https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Arrays/problem/check-if-array-is-sorted-and-rotated-clockwise-1587115620
// VL - https://www.youtube.com/watch?v=9S96hJ9SoFI
public class CheckIfArrayIsSortedAndRotated_26 {

    /**
     * First step to find if array is sorted in increasing order or decreasing order.
     * if isSortedInc = true then return false because array is sorted but not rotated
     * if isSortedInc = false then check
     *      if arr current element is greater than array of currElement + 1 and store the count in breakInc variable
     *      if breakInc == 1 that means array is sorted in increasing order and also rotated so return true.
     * if isSortedDex = true then return false because array is sorted but not rotated
     * if isSortedDex = false then check
     *      if arr current element is greater than array of currElement + 1 and store the count in breakDec variable
     *      if breakInc == 1 that means array is sorted in decreasing order and also rotated so return true.
     * In last if both the condition does not means then return false
     * @param arr
     * @return
     */
    //TODO - REVISIT - 26 Oct 2025
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

        if (isSortedInc) {
            return false;
        }

        int breakInc = 0;
        if (!isSortedInc) {
            for (int i = 0; i < n-1; i++) {
                if (arr[i] > arr[i+1]) {
                    breakInc++;
                }
            }
        }
        if (breakInc == 1) {
            return true;
        }

        boolean isSortedDec = false;

        for (int i = 0; i < n-1; i++) {
            if (arr[i] > arr[i+1]) {
                isSortedDec = true;
            } else {
                isSortedDec = false;
                break;
            }
        }

        if (isSortedDec) {
            return false;
        }

        int breakDec = 0;
        if (!isSortedDec) {
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
