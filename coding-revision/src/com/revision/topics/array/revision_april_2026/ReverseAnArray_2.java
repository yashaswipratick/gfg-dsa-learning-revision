package com.revision.topics.array.revision_april_2026;

public class ReverseAnArray_2 {

    private static void reverse(int[] arr) {
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

    private static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        reverse(new int[]{1,2,3,4,5});
    }
}
