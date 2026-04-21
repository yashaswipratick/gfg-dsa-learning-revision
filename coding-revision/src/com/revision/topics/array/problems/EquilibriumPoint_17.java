package com.revision.topics.array.problems;

// VL - https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Arrays/video/NzU4OA%3D%3D
// PL - https://www.geeksforgeeks.org/problems/equilibrium-point-1587115620/1
// PL - https://leetcode.com/problems/find-pivot-index/
public class EquilibriumPoint_17 {

    /**
     * The idea is to get the total sum of the array first.
     * Then Iterate through the array and keep updating the left sum which is initialized as zero.
     * In the loop, we can get the right sum by subtracting the elements one by one.
     * @param arr
     * @return
     */
    static boolean equilibriumPoint(int[] arr) {
        int rightSum = 0;
        for (int i = 0; i < arr.length; i++) {
            rightSum += arr[i];
        }

        int leftSum = 0;
        for (int i = 0; i < arr.length; i++) {
            rightSum -= arr[i];
            if (leftSum == rightSum) {
                return true;
            }
            leftSum += arr[i];
        }
        return false;
    }

    /**
     * 🧠 Approach to Find Equilibrium Index in an Array
     *
     * Problem:
     * -----------
     * Given an array, we need to find the index `i` such that the sum of all elements
     * to the left of `i` is equal to the sum of all elements to the right of `i`.
     * If no such index exists, return -1.
     *
     * Example:
     *  arr = [1, 3, 5, 2, 2]
     *  Output: 2
     *  (Because left sum = 1 + 3 = 4 and right sum = 2 + 2 = 4)
     *
     * ✅ Approach:
     * -------------
     * 1. First, calculate the total sum of the array → call it `rightSum`.
     *    - This will help us easily get the right-side sum during iteration.
     *
     * 2. Initialize `leftSum = 0`.
     *
     * 3. Iterate through each element:
     *    - Subtract the current element from `rightSum` → now `rightSum` represents
     *      the sum of elements to the right of index `i`.
     *    - Compare `leftSum` and `rightSum`.
     *         → If equal, this is the equilibrium index → return `i`.
     *    - Add the current element to `leftSum` (as we move to the next index).
     *
     * 4. If no equilibrium index is found, return -1.
     *
     * ⏱️ Time Complexity: O(n)
     * 💾 Space Complexity: O(1)
     *
     * Intuition:
     * ------------
     * Instead of recalculating left and right sums repeatedly for each index (which would be O(n²)),
     * we maintain running totals of both sides in a single linear pass.
     */
    // TODO - REVISIT - 17 Oct 2025
    static int equilibriumPointIndex(int[] arr) {
        int rightSum = 0;
        for (int i = 0; i < arr.length; i++) {
            rightSum += arr[i];
        }

        int leftSum = 0;
        for (int i = 0; i < arr.length; i++) {
            rightSum -= arr[i];
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += arr[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(equilibriumPointIndex(new int[]{3, 4, 8, -9, 9, 7}));
        System.out.println(equilibriumPointIndex(new int[]{1, 2, 0, 3}));
        System.out.println(equilibriumPointIndex(new int[]{1, 1, 1, 1}));
        System.out.println(equilibriumPointIndex(new int[]{1, 1, 1, 1}));
        System.out.println(equilibriumPointIndex(new int[]{-7, 1, 5, 2, -4, 3, 0}));
    }
}
