package com.revision.topics.array.revision_april_2026;

public class LeftRotateArrayByOne_5 {

    private static void rotate(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[i];
            arr[i] = arr[i - 1];
            arr[i - 1] = temp;
        }

        print(arr);
    }

    private static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        rotate(new int[]{1, 2, 3, 4, 5});
        rotate(new int[]{9, 8, 7, 6, 4, 2, 1, 3});
    }
}
