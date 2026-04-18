package com.revision.topics.greedy.medium.fractional_knapsack;

public class Item {

    int val;
    int wt;
    double ratio;

    public Item(int val, int wt) {
        this.val = val;
        this.wt = wt;
        this.ratio = (double) this.val/this.wt;
    }
}
