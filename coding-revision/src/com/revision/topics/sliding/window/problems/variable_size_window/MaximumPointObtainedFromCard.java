package com.revision.topics.sliding.window.problems.variable_size_window;

// VL - https://youtu.be/pBWCOCS636U
// PL - https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/description/
public class MaximumPointObtainedFromCard {

    //TODO - Revise
    public static int maxScore(int[] cardPoints, int k) {
        int leftSum = 0;
        int rightSum = 0;
        int maxSum = 0;

        for (int i = 0; i < k; i++) {
            leftSum += cardPoints[i]; // calculates the left from 0 till length of k-1;
        }

        //assuming that we have picked up all the k elements we can consider leftSum value
        // as max for now and store it in maxSum
        maxSum = leftSum;

        // now the step is to shrink down the window by removing each elements in this fashion below
        // remove k-1 and calculate maxSum.
        // remove k-2 and so on till k-k = 0;
        int rightIndex = cardPoints.length - 1;
        for (int i = k-1; i >= 0 ; i--) {
            leftSum -= cardPoints[i];// evrytine it remove k-1, k-2, k-3 so on until length k-1
            rightSum += cardPoints[rightIndex]; // calculating right sum.
            rightIndex --; // decrementing right index to get the next index so that in next loop rightSum gets calculated.
            maxSum = Math.max(maxSum, leftSum + rightSum); // Finding max between (leftSum + rightSum) and maxSum.
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maxScore(new int[]{1, 2, 3, 4, 5, 6, 1}, 3));
        System.out.println(maxScore(new int[]{2,2,2}, 2));
    }
}
