package com.revision.topics.array.problems;

import java.util.Arrays;
import java.util.List;

// VL - https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Arrays/video/NzU4OQ%3D%3D
// PL - https://www.geeksforgeeks.org/problems/maximum-occured-integer4602/1
public class MaximumAppearingElement_18 {

    static int MAX = 1000005; // as it was throwing index out of bound at 1000000 so increased to 1000005
    /**
     * 🧠 Approach to Find the Integer that Appears in the Most Ranges
     *
     * Problem:
     * -----------
     * You are given two arrays/lists L[] and R[], where each L[i] and R[i]
     * define the start and end of a range [L[i], R[i]] (inclusive).
     * You need to find the integer that appears in the maximum number of these ranges.
     * If multiple integers occur the same maximum number of times, return the smallest one.
     *
     * Example:
     * ---------
     * L = [1, 4, 3, 1]
     * R = [15, 8, 5, 4]
     *
     * The ranges are:
     * [1,15], [4,8], [3,5], [1,4]
     * → The number '4' appears in most ranges → Output = 4
     *
     * ✅ Efficient Approach (Using Prefix Sum / Difference Array)
     * -----------------------------------------------------------
     * 1️⃣ Create a frequency array `freq[]` of a fixed maximum size (say MAX = 1e6+2)
     *     - Each index represents an integer value.
     *
     * 2️⃣ For every range [L[i], R[i]]:
     *     - Increment freq[L[i]] by 1  (starting point of a range)
     *     - Decrement freq[R[i] + 1] by 1 (end point + 1, since range is inclusive)
     *
     *     ➤ This marks the beginning and end of contribution for that range.
     *
     * 3️⃣ Now, compute prefix sum of freq[]:
     *     - freq[i] = freq[i-1] + freq[i]
     *     - This step converts the difference array into actual frequency counts,
     *       where freq[i] now represents how many ranges include the integer i.
     *
     * 4️⃣ Traverse freq[] to find the index having the maximum frequency value.
     *     - Keep track of the smallest index in case of ties.
     *
     * 5️⃣ Return that index → this is the integer that appears in most ranges.
     *
     * ⏱️ Time Complexity: O(N + MAX)
     * 💾 Space Complexity: O(MAX)
     *
     * 💡 Why This Works:
     * -------------------
     * The difference array approach efficiently captures range updates in O(1) per range,
     * and prefix sum then spreads those updates across the entire array cumulatively.
     */
    // TODO - REVISIT - 17 Oct 2025
    public static int maxOccured(List<Integer> L, List<Integer> R) {
        int[] freq = new int[MAX];

        for (int i = 0; i < L.size(); i++) {
            freq[L.get(i)]++;
            freq[R.get(i) + 1] --;
        }

        int res = 0;

        for (int i = 1; i < freq.length; i++) {
            freq[i] = freq[i-1] + freq[i];
            if (freq[i] > freq[res]) {
                res = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxOccured(Arrays.asList(1, 2, 4), Arrays.asList(4, 5, 7)));
    }
}
