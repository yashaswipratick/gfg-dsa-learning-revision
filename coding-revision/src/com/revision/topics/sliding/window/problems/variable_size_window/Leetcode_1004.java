package com.revision.topics.sliding.window.problems.variable_size_window;

public class Leetcode_1004 {

    /**
     * Approach
     * Left pointer - i
     * Right pointer - j
     * 1. Initialize two pointers, left and right, both set to 0,
     * and a variable zerocount to keep track of the number of zeros in the current window.
     * 2. Traverse the array using the right pointer.
     * 3. If the current element is 0, increment zerocount.
     * 4. If zerocount exceeds k, check if the element at the left pointer is 0, and if so, decrement zerocount. Then increment the left pointer.
     * 5. At each step, calculate the current window size and update the maximum length if it's greater than the previously recorded maximum.
     * 6. Continue this process until the right pointer has traversed the entire array.
     * 7. Return the maximum window size found.
     *
     */
    public static int longestOnes(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int zeroes = 0;
        int maxLength = 0;

        while(j < nums.length) {
            if(nums[j] == 0) {
                zeroes++;
            }

            if(zeroes > k) {
                if(nums[i] == 0) {
                    zeroes--;
                }
                i++;
            }
            maxLength = Math.max(maxLength, j-i+1);
            j++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
        System.out.println(longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
    }
}
