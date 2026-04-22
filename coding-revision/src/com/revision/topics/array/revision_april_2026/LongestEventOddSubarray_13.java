package com.revision.topics.array.revision_april_2026;

public class LongestEventOddSubarray_13 {

    private static int longestEvenOddSubarray(int[] arr) {
        int res = 1;
        int count = 1;

        for (int i = 1; i < arr.length; i++) {
            if ((arr[i] % 2 == 0 && arr[i-1] % 2 == 1) || (arr[i] % 2 != 0 && arr[i-1] % 2 == 0)) {
                count++;
                res = Math.max(res, count);
            } else {
                count = 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestEvenOddSubarray(new int[]{1, 2, 3, 4, 5, 7, 9}));
        System.out.println(longestEvenOddSubarray(new int[]{5, 10, 20, 6, 3, 8}));
        System.out.println(longestEvenOddSubarray(new int[]{1, 3, 5}));
        System.out.println(longestEvenOddSubarray(new int[]{1, 2, 3, 4, 5, 3, 7, 2, 9, 4 }));
    }
}
