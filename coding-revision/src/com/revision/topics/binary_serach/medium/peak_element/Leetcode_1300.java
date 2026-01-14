package com.revision.topics.binary_serach.medium.peak_element;

import java.util.Arrays;

// PL - https://leetcode.com/problems/sum-of-mutated-array-closest-to-target/description/
// VL - https://www.youtube.com/watch?v=jbiDsInyTwA
public class Leetcode_1300 {

    // TODO - Revisit
    public static int findBestValue(int[] arr, int target) {
        int start = 0;
        int end = Arrays.stream(arr).max().getAsInt();

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int sum = mid * arr.length;
            int diff = target - sum;
            if (predicate(mid, arr, target)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private static boolean predicate(int mid, int[] arr, int target) {
        return mapFunc(mid, arr, target) <= mapFunc(mid + 1, arr, target);
    }

    private static int mapFunc(int mid, int[] arr, int target) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += Math.min(mid, arr[i]);
        }
        return Math.abs(sum - target);
    }

    public static void main(String[] args) {
        System.out.println(findBestValue(new int[]{4, 9, 3}, 10));
        System.out.println(findBestValue(new int[]{2, 3, 5}, 10));
        System.out.println(findBestValue(new int[]{60864, 25176, 27249, 21296, 20204}, 56803));
    }
}
