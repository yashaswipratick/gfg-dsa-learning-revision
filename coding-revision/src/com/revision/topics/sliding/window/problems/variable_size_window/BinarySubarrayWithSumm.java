package com.revision.topics.sliding.window.problems.variable_size_window;

// PL - https://leetcode.com/problems/binary-subarrays-with-sum/description/
// VL - https://youtu.be/XnMdNUkX6VM
public class BinarySubarrayWithSumm {

    // TODO - Revisit

    /**
     * To count the number of subarrays with sum exactly equal to goal, a clever strategy is to reframe the problem:
     * We count the number of subarrays whose sum is at most goal, and subtract from it the number of subarrays
     * whose sum is at most goal- 1.
     *
     * This works because:The subarrays with sum exactly goal are the ones included in atMost(goal)
     * but not in atMost(goal - 1) and This is valid for non-negative elements.
     *
     * Why is this more efficient?
     * Instead of recomputing subarray sums from scratch , we maintain a sliding window that expands
     * and contracts based on the current sum.This gives us linear time performance by moving each pointer at most once.
     * This method only works when goal ≥ 1, because the atMost(goal - 1)
     * calculation is invalid for goal = 0 (negative index/window not possible).
     *
     * 1. Define a helper function to calculate the number of subarrays with sum at most a given value
     * 2. Initialize a sliding window with two pointers (left and right)
     * 3. Iterate through the array, expanding the right pointer and adding to current sum
     * 4. If the current sum exceeds the target, shrink the window from the left until it’s valid
     * 5. At each step, add the size of the current valid window to the count
     * 6. To get the final answer, compute: atMost(goal) - atMost(goal - 1)
     * @param nums
     * @param goal
     * @return
     */
    // Function to calculate number of subarrays with sum exactly equal to goal
    public static int numSubarraysWithSum(int[] nums, int goal) {
        // Return difference between atMost(goal) and atMost(goal - 1)
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    // Helper method to count subarrays with sum at most k
    private static int atMost(int[] nums, int k) {
        // No valid subarray for negative sum
        if (k < 0) return 0;

        int left = 0;
        int sum = 0;
        int count = 0;

        // Traverse array using right pointer
        for (int right = 0; right < nums.length; right++) {
            // Add current element to sum
            sum += nums[right];

            // Shrink window if sum exceeds k
            while (sum > k) {
                sum -= nums[left];
                left++;
            }

            // Add number of valid subarrays ending at right
            count += (right - left + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2));
        System.out.println(numSubarraysWithSum(new int[]{0,0,0,0,0}, 0));
    }
}
