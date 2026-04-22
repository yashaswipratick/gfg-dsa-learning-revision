package com.revision.topics.array.problems;

// PL - https://www.geeksforgeeks.org/problems/trapping-rain-water-1587115621/1
// PL - https://leetcode.com/problems/trapping-rain-water/description/
// VL - https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Arrays/video/MTE2OA%3D%3D
public class TrappingRainWater_11 {

    /**
     * Approach
     * Find the maximum in the left array at each index comparing lmax[i-1] and arr[i] and store it in lMax array at every index.
     * Find the maximum in the right at each index comparing rMax[i+1] and arr[i] and store it in rMax array at every index.
     * Now run the loop from 0 to n-1 and get the minimum of lMax[i] and rMax[i] and subtract arr[i] from the minimum
     * taken between lMax[i] and rMax[i] and then add it to the res variable to get the maximum water stored.
     * @param arr
     * @return
     */

    // TODO - REVISIT - 12 Oct 2025
    public static int maxWater(int arr[]) {
        int[] lMax = new int[arr.length];
        int[] rMax = new int[arr.length];
        int res = 0;

        lMax[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            lMax[i] = Math.max(lMax[i-1], arr[i]);
        }

        rMax[arr.length-1] = arr[arr.length-1];
        for (int i = arr.length - 2; i >= 0; i--) {
            rMax[i] = Math.max(rMax[i+1], arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            res += (Math.min(lMax[i], rMax[i]) - arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxWater(new int[]{3, 0, 1, 0, 4, 0, 2}));
        System.out.println(maxWater(new int[]{3, 0, 2, 0, 4}));
        System.out.println(maxWater(new int[]{1, 2, 3, 4}));
        System.out.println(maxWater(new int[]{2, 1, 5, 3, 1, 0, 4}));
    }
}
