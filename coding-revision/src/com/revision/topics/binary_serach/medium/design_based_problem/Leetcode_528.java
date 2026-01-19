package com.revision.topics.binary_serach.medium.design_based_problem;

import java.util.Random;

// PL - https://leetcode.com/problems/random-pick-with-weight/description
// VL - https://www.youtube.com/watch?v=3Ky9ZlI95cY
public class Leetcode_528 {

    int[] arr;
    Random random = new Random();
    int max = 0;
    public Leetcode_528(int[] w) {
        arr = new int[w.length];
        arr[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            arr[i] = arr[i-1] + w[i];
        }
        max = arr[arr.length - 1];
    }

    //TODO - Revisit
    public int pickIndex() {
        int start = 0;
        int end = arr.length-1;
        int target = 1 + random.nextInt(max);

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {

    }
}
