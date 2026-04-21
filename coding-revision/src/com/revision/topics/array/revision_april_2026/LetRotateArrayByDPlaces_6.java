package com.revision.topics.array.revision_april_2026;

public class LetRotateArrayByDPlaces_6 {

    private static void rotateArr(int arr[], int d) {
        while (d > arr.length) {
            d = d - arr.length;
        }
        reverse(arr, 0, d-1);
        reverse(arr, d, arr.length-1);
        reverse(arr, 0, arr.length-1);
        print(arr);
    }

    private static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        rotateArr(new int[]{1, 2, 3, 4, 5}, 2);
        rotateArr(new int[]{2, 4, 6, 8, 10, 12, 14, 16, 18, 20}, 3);
        rotateArr(new int[]{7, 3, 9, 1}, 9);
    }
}
