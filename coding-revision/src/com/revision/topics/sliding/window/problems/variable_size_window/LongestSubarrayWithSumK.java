package com.revision.topics.sliding.window.problems.variable_size_window;

/**
 * Given an array containing N positive integers and an integer K. Your task is to find the length of the longest Sub-Array with sum of the elements equal to the given value K.
 *
 * For Input:
 * 7 5
 * 4 1 1 1 2 3 5
 * your output is:
 * 4 .
 */
public class LongestSubarrayWithSumK {

    public static int longestSubarray(int[] array, int sum) {
        int max = Integer.MIN_VALUE;
        int i = 0;
        int j = 0;
        int currSum = 0;
        int count = 0;
        while (j < array.length) {
            currSum += array[j];

            if (currSum < sum) {
                j++;
            } else if (currSum == sum) {
                max = Math.max(max, j-i+1);
                j++;
            } else if (currSum > sum){
                while (currSum > sum) {
                    currSum -= array[i];
                    i++;
                }
                j++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{1,1,1}, 2));
        System.out.println(longestSubarray(new int[]{1,2,3}, 3));
        System.out.println(longestSubarray(new int[]{4, 1, 1, 1, 2, 3, 5}, 5));
    }
}
