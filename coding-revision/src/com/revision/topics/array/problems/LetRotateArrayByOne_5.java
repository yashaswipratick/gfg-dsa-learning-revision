package com.revision.topics.array.problems;

//VL - https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Arrays/video/MTE2Mw%3D%3D
//PL - https://www.geeksforgeeks.org/problems/cyclically-rotate-an-array-by-one2614/1
public class LetRotateArrayByOne_5 {

    public static void rotate(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[i];
            arr[i] = arr[i - 1];
            arr[i - 1] = temp;
        }
        print(arr);
    }

    static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        rotate(new int[]{1, 2, 3, 4, 5});
        rotate(new int[]{9, 8, 7, 6, 4, 2, 1, 3});
    }
}
