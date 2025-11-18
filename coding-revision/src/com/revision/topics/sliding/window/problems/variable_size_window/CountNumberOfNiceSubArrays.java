package com.revision.topics.sliding.window.problems.variable_size_window;

// Pl - https://leetcode.com/problems/count-number-of-nice-subarrays/description/
// VL - https://youtu.be/j_QOv9OT9Og
public class CountNumberOfNiceSubArrays {

    /**
     * We can't directly count subarrays with exactly K odd numbers using one pass of sliding window.
     * But we can count how many subarrays have at most K odd numbers. If we do this for both K and K-1,
     * then the difference gives us the number of subarrays that have exactly K odd numbers. This works because:
     * countExactlyK = countAtMost(K) - countAtMost(K - 1).
     * Use a helper function to count the number of subarrays with at most a given number of odd numbers.
     * 1. Initialize two pointers to define the sliding window.
     * 2. Expand the window by moving the right pointer.
     * 3. If the number of odd numbers in the window exceeds the allowed count, move the left pointer to shrink the window.
     * 4. For each valid window, the number of subarrays ending at the current index is (right - left + 1).
     * 5. Repeat for K and K - 1, then return their difference.
     */
    // Helper function to count subarrays with at most k odd numbers
    public int countAtMost(int[] nums, int k) {
        int left = 0, res = 0;

        // Traverse through the array
        for (int right = 0; right < nums.length; right++) {
            // If current number is odd, reduce k
            if (nums[right] % 2 != 0)
                k--;

            // Shrink the window until k is valid
            while (k < 0) {
                if (nums[left] % 2 != 0)
                    k++;
                left++;
            }

            // Add valid subarrays ending at right
            res += (right - left + 1);
        }

        // Return result
        return res;
    }

    // Function to return number of subarrays with exactly k odd numbers
    public int numberOfSubarrays(int[] nums, int k) {
        return countAtMost(nums, k) - countAtMost(nums, k - 1);
    }
}
