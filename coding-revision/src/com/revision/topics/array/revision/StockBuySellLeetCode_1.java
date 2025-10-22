package com.revision.topics.array.revision;

public class StockBuySellLeetCode_1 {

    /**
     * initialise buyingPrice as 1st element of array;
     * intitialise profit as 0;
     * now to calculate the max profit
     *  * At each index take the minimum of current element of price array and buyingPrice
     *  * At each index Take the maximum of profit calculated till now and (arr[i] - buyingPrice),
     *      which ever is max should be store in profit variable
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int buyingPrice = prices[0];
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {
            buyingPrice = Math.min(buyingPrice, prices[i]);
            profit = Math.max(profit, prices[i] - buyingPrice);
        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
    }
}
