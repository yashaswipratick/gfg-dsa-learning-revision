package com.revision.topics.array.problems;

// PL - https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Arrays/problem/smallest-positive-missing-number-1587115621

public class SmallestPositiveMissingNumber_32 {
    /*
    Approach: Smallest Positive Missing Number (Cyclic Sort)

    1. Problem Understanding:
       - We need to find the smallest missing positive integer (starting from 1).
       - The array can contain negative numbers, zeros, and duplicates.
       - Constraints are large, so we need an O(n) solution with constant extra space.

    2. Key Idea:
       - For any number x in the range [1, n] (where n = array length),
         ideally x should be placed at index (x - 1).
         Example: 1 → index 0, 2 → index 1, ..., n → index (n-1).
       - Numbers that are ≤ 0 or > n are ignored since they can't affect the answer.

    3. Cyclic Sort Process:
       - Traverse the array:
           while current number arr[i] is in the range [1, n]
           and not already at its correct position (arr[i] != arr[arr[i]-1]),
           swap it to its correct index.
       - This rearranges the array so that if a number k exists,
         it will end up at index (k-1).

    4. Finding the Answer:
       - After rearrangement, iterate through the array:
           if at index i, arr[i] != i+1, then (i+1) is the missing number.
       - If all positions are correct, then the smallest missing number is (n+1).

    5. Complexity:
       - Time: O(n) → Each element is swapped at most once.
       - Space: O(1) → In-place rearrangement.

    Example walkthrough:
       arr = [2, -3, 4, 1, 1, 7]
       After cyclic sort → [1, 2, 4, -3, 1, 7]
       Checking positions → at index 2, expected 3 but got 4 → Answer = 3
    */

    // TODO - Revisit in 3-5 days
    public static int missingNumber(int[] arr) {
        int n = arr.length;

        for(int i = 0; i<n; i++) {
            while(arr[i] > 0 && arr[i] <= n && arr[arr[i] - 1] != arr[i]) {

                int correctIndex = arr[i] - 1;

                int temp = arr[i];
                arr[i] = arr[correctIndex];
                arr[correctIndex] = temp;
            }
        }

        for(int i = 0; i< n; i++) {
            if(arr[i] != i+1) {
                return i+1;
            }
        }
        return n+1;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{2, -3, 4, 1, 1, 7}));
        System.out.println(missingNumber(new int[]{5, 3, 2, 5, 1}));
        System.out.println(missingNumber(new int[]{-8, 0, -1, -4, -3}));
    }
}
