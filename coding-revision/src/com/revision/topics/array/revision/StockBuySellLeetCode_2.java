package com.revision.topics.array.revision;

//VL - https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Arrays/video/MTE2Nw%3D%3D
// VL - https://www.youtube.com/watch?v=OG0S3VU_yMM
// PL - https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii
public class StockBuySellLeetCode_2 {

    /**
     * Approach
     * initialize profit variable as 0;
     * keep on adding the profit if the elements of array at i > elements of array at i-1.
     * take the difference of arr[i] - arr[i-1] and add to the profit.
     * At last return the result.
     * @param arr
     * @return
     */

    //Same as StockByAndSellGfg problem
    static int stockBuySell(int arr[]) {
        int profit = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i-1]) {
                profit += arr[i] - arr[i-1];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println(stockBuySell(new int[]{100, 180, 260, 310, 40, 535, 695}));
        System.out.println(stockBuySell(new int[]{4, 2, 2, 2, 4}));
        System.out.println(stockBuySell(new int[]{4, 2}));
    }
}
