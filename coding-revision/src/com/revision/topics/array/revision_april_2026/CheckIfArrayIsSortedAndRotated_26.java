package com.revision.topics.array.revision_april_2026;

public class CheckIfArrayIsSortedAndRotated_26 {

    private static boolean isSortedRotated(int[] arr) {
        boolean isSortedIncreasing = false;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                isSortedIncreasing = true;
            } else {
                isSortedIncreasing = false;
                break;
            }
        }

        if (isSortedIncreasing) {
            return false;
        }

        int isRotatedIncreasing = 0;

        if (!isSortedIncreasing) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    isRotatedIncreasing++;
                }
            }
        }

        if (isRotatedIncreasing == 1) {
            return true;
        }

        boolean isSortedDecreasing = false;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                isSortedDecreasing = true;
            } else {
                isSortedDecreasing = false;
                break;
            }
        }

        int isRotatedDecreasing = 0;
        if (!isSortedDecreasing) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] < arr[i + 1]) {
                    isRotatedDecreasing++;
                }
            }
        }

        if (isRotatedDecreasing == 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isSortedRotated(new int[]{3, 4, 1, 2}));
        System.out.println(isSortedRotated(new int[]{1, 2, 3}));
        System.out.println(isSortedRotated(new int[]{5, 4, 3}));
    }
}
