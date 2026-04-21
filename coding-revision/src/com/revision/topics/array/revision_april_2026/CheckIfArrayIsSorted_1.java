package com.revision.topics.array.revision_april_2026;

public class CheckIfArrayIsSorted_1 {

    private static boolean isSorted(int[] arr) {
        if (arr == null || arr.length == 0) {return true;}

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
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
