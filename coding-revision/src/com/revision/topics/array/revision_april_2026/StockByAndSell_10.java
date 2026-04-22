package com.revision.topics.array.revision_april_2026;

public class StockByAndSell_10 {
    private static int stockBuySell(int arr[]) {
        int profit = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i-1]) {
                profit += (arr[i] - arr[i-1]);
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
