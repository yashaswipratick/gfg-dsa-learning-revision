package com.revision.topics.array.revisit.important_concept;

import java.util.Arrays;
import java.util.List;
// VL - https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Arrays/video/NzU4OQ%3D%3D
// PL - https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Arrays/problem/maximum-occured-integer4602
public class MaximumOccurredInteger_34 {

    /*
        Approach:
        ---------
        Goal:
        ------
        Given two lists L[] and R[], each representing start and end points of ranges,
        find the number (integer) that appears in the maximum number of these ranges.

        Example:
        ---------
        L = [1, 2, 3]
        R = [3, 5, 7]

        → Ranges are:
           [1,3], [2,5], [3,7]

        → Number 3 appears in all three ranges → Output = 3


        Step-by-step logic:
        -------------------
        1. Create a frequency array `freq[]` of large enough size (MAX = 10^6+5)
           to track how many ranges cover each point.

        2. For each range [L[i], R[i]]:
           - Increment freq[L[i]] by 1 → means a new range starts at L[i].
           - Decrement freq[R[i] + 1] by 1 → means that range ends after R[i].

           (This is the **prefix sum technique** — a very efficient way to mark ranges.)

        3. Once all ranges are marked, compute prefix sums:
           - For i = 1 to MAX:
                 freq[i] = freq[i-1] + freq[i];
             This step converts frequency markers into actual counts of
             how many ranges cover each position.

        4. Track the index `res` that has the maximum value in freq[].
           - This index represents the number that occurs in the maximum ranges.

        5. Return that index as the result.

        Why this works:
        ----------------
        → Instead of iterating through every element in every range (which would be O(N * Range)),
           we just mark the start and end points and use prefix sums to get the result in O(N + MAX).

        Time Complexity:  O(N + MAX)
        Space Complexity: O(MAX)

        Key Concept:
        -------------
        → Use **prefix sum (difference array technique)** to efficiently count frequency
           of range overlaps.
        */

    static int MAX = 1000005;

    //TODO - REVISIT - 26 Oct 2025 - important concept
    public static int maxOccured(List<Integer> L, List<Integer> R) {
        // code here

        // Create a frequency array `freq[]` of large enough size (MAX = 10^6+5)
        // to track how many ranges cover each point.
        int[] freq = new int[MAX];

        for (int i = 0; i < L.size(); i++) {
            // Increment freq[L[i]] by 1 → means a new range starts at L[i].
            freq[L.get(i)]++;
            // Decrement freq[R[i] + 1] by 1 → means that range ends after R[i].
            freq[R.get(i) + 1]--;
        }

        int res = 0;

        // For i = 1 to MAX:

        for (int i = 1; i < freq.length; i++) {
            // freq[i] = freq[i-1] + freq[i];
            freq[i] = freq[i - 1] + freq[i]; //calculating prefix sum and storing at current index
            // if freq[i] greater than freq[res] that means element at index
            // i has freq greater than res which is old index. overwrite res to current index i
            // to have the latest index element with greater freq
            if (freq[i] > freq[res]) {
                res = i;
            }
        }
        //return the res with element having the greatest frequency
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxOccured(Arrays.asList(1, 4, 3, 1), Arrays.asList(15, 8, 5, 4)));
        System.out.println(maxOccured(Arrays.asList(1, 5, 9, 13, 21), Arrays.asList(15, 8, 12, 20, 30)));
    }
}
