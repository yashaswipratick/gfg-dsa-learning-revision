package com.revision.topics.array.problems;

//VL - https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Arrays/video/MTYyMw%3D%3D
//PL - https://www.geeksforgeeks.org/problems/check-if-an-array-is-sorted0701/1
public class CheckIfArrayIsSorted_1 {
    public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i-1] > arr[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isSorted(new int[]{10, 20, 30, 40, 50}));
        System.out.println(isSorted(new int[]{90, 80, 100, 70, 40, 30}));
    }
}
