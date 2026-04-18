package com.revision.topics.greedy.medium.fractional_knapsack;

import java.util.Arrays;

// PL - https://www.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1
// VL - https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Greedy/video/NzU5MQ%3D%3D
public class FractionalKnapsack {

    public static double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        Item[] items = new Item[val.length];

        for (int i = 0; i < items.length; i++) {
            items[i] = new Item(val[i], wt[i]);
        }

        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));

        double res = 0;
        for (int i = 0; i < items.length; i++) {
            if (capacity >= items[i].wt) {
                res += items[i].val;
                capacity -= items[i].wt;
            } else {
                res += items[i].val * ((double) capacity / items[i].wt);
                break; // this is important otherwise it will keep on adding fraction val to res.
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(fractionalKnapsack(new int[]{60, 100, 120}, new int[]{10, 20, 30}, 50));
        System.out.println(fractionalKnapsack(new int[]{500}, new int[]{30}, 10));
        System.out.println(fractionalKnapsack(new int[]{1, 5, 7, 2, 7, 10}, new int[]{4, 9, 6, 3, 7, 3}, 24));
    }
}
