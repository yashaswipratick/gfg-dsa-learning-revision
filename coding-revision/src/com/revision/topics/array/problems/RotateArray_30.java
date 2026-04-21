package com.revision.topics.array.problems;

public class RotateArray_30 {

    //TODO - REVISIT - 26 Oct 2025
    static void rotateArr(int arr[], int d) {

        if (d % arr.length == 0) return;

        int rev = d % arr.length;

        reverse(arr, 0, rev-1);
        reverse(arr, rev, arr.length-1);
        reverse(arr, 0, arr.length-1);
    }

    static void reverse(int[] arr, int start, int end) {
        while(start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Basic example from prompt
        rotateArr(new int[]{1, 2, 3, 4, 5}, 2); // Simple mid-size rotation
        rotateArr(new int[]{2, 4, 6, 8, 10, 12, 14, 16, 18, 20}, 3); // Larger array
        rotateArr(new int[]{7, 3, 9, 1}, 9); // Rotation greater than size

// Edge cases
        rotateArr(new int[]{10}, 1); // Single element array
        rotateArr(new int[]{1, 2}, 1); // Two elements, rotate by 1
        rotateArr(new int[]{1, 2}, 2); // Rotation equals size
        rotateArr(new int[]{1, 2, 3}, 0); // Rotation by 0 (no change)
        rotateArr(new int[]{5, 10, 15}, 3); // Rotation equal to size (no change)

// Special cases
        rotateArr(new int[]{1, 2, 3, 4, 5}, 4); // Rotation just before size
        rotateArr(new int[]{0, 0, 0, 0}, 2); // All same elements
        rotateArr(new int[]{100000, 99999, 50000, 1}, 1); // Large values
        rotateArr(new int[]{1, 2, 3, 4, 5, 6}, 5); // Rotation close to size
        rotateArr(new int[]{1, 2, 3, 4, 5, 6}, 6); // Rotation equal to size
        rotateArr(new int[]{1, 2, 3, 4, 5, 6}, 7); // Rotation just above size

    }
}
