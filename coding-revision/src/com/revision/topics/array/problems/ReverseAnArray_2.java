package com.revision.topics.array.problems;

public class ReverseAnArray_2 {

    public static void reverseArray(int arr[]) {
        int start = 0;
        int end = arr.length-1;

        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
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
        reverseArray(new int[]{1,2,3,4,5});
        reverseArray(new int[]{1,2});
        reverseArray(new int[]{1});
    }
}
