package com.revision.topics.array.revision_april_2026;

import java.util.ArrayList;

public class MaxAndSecondMax_22 {

    private static ArrayList<Integer> largestAndSecondLargest(int arr[]) {
        int max = -1;
        int secondMax = -1;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
            } else if (arr[i] > secondMax && arr[i] < max) {
                secondMax = arr[i];
            }
        }
        list.add(max);
        list.add(secondMax);

        return list;
    }

    public static void main(String[] args) {
        largestAndSecondLargest(new int[]{2, 1, 2});
        largestAndSecondLargest(new int[]{1, 2, 3, 4, 5});
        largestAndSecondLargest(new int[]{3, 3, 3});
    }
}
