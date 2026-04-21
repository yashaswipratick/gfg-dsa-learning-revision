package com.revision.topics.array.revision_april_2026;

public class MoveZeroesToTheEnd_4 {

    private static void pushZerosToEnd(int[] arr) {
        int count = 0;
        int j = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                count++;
                if (j == -1) {
                    j = i;
                }
            } else {
                if (j > -1) {
                    arr[j] = arr[i];
                    j++;
                }
            }
        }
        if (count > 0) {
            int i = arr.length - count;
            while (count > 0) {
                arr[i] =0;
                i++;
                count--;
            }
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
        pushZerosToEnd(new int[]{1, 2, 0, 4, 3, 0, 5, 0});
        pushZerosToEnd(new int[]{10, 20, 30});
        pushZerosToEnd(new int[]{0, 0});
    }
}
