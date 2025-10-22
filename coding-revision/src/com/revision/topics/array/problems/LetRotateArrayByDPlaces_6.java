package com.revision.topics.array.problems;

//VL - https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Arrays/video/MTE2Mw%3D%3D
//PL - https://www.geeksforgeeks.org/problems/rotate-array-by-n-elements-1587115621/1
public class LetRotateArrayByDPlaces_6 {

    public static void rotateArr(int arr[], int d) {
        while (d > arr.length) {
            d = d - arr.length;
        }
        reverse(arr, 0, d-1);
        reverse(arr, d, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
        print(arr);
    }

    private static void reverse(int arr[], int start, int end) {
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        /*rotateArr(new int[]{1, 2, 3, 4, 5}, 2);
        rotateArr(new int[]{2, 4, 6, 8, 10, 12, 14, 16, 18, 20}, 3);*/
        rotateArr(new int[]{7, 3, 9, 1}, 9);
    }
}
