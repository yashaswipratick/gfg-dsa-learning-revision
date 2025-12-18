package com.revision.topics.sliding.window.problems.revision.variable_size_window;

/**
 * Given an array containing N positive integers and an integer K. Your task is to find the length of the longest Sub-Array with sum of the elements equal to the given value K.
 *
 * For Input:
 * 7 5
 * 4 1 1 1 2 3 5
 * your output is:
 * 4 .
 */
//VL - https://www.youtube.com/watch?v=cyu_nuW5utA&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=7
public class LongestSubarrayWithSumK {

    /**
     * Identification
     * Problem of array or string
     * Condition will be given.
     * Ask to find subarray of max/min/largest/longest/smallest subarrray or related answer
     * @param array
     * @param sum
     * @return
     */
    public static int longestSubarray(int[] array, int sum) {
       int i = 0;
       int j = 0;
       int max = 0;
       int curSum = 0;

       while (j < array.length) {
           curSum += array[j]; // calculate the current sum

           if (curSum < sum) {
               j++; // increament until currSum < sum
           } else if (curSum == sum) { // Once surSum == sum store max length
               max = Math.max(j-i+1, max);
               j++;
           } else {
               while (curSum > sum) {// iterate until cursum > sum and remove ith element
                   curSum -= array[i];
                   i++;
               }
               j++;
           }
       }
       return max; // return the max
    }

    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{1,1,1}, 2));
        System.out.println(longestSubarray(new int[]{1,2,3}, 3));
        System.out.println(longestSubarray(new int[]{4, 1, 1, 1, 2, 3, 5}, 5));
    }
}
