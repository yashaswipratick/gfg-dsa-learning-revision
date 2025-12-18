package com.revision.topics.heap;

import java.util.*;

// PL - https://leetcode.com/problems/rank-transform-of-an-array/
// VL - https://takeuforward.org/data-structure/replace-elements-by-its-rank-in-the-array/
public class RankTransformOfAnArray {

    /**
     * We need to assign a rank to each element of the array based on how small or large it is compared to others.
     * The smallest number gets rank 1, the next smallest gets rank 2, and so on. Duplicate elements should get the same rank.
     *
     * Make a copy of the array to avoid modifying the original.
     * Sort the copied array in ascending order.
     * Use a map or dictionary to assign rank starting from 1, skipping duplicates.
     * Loop through the original array and replace each element with its rank using the map.
     */

    //TODO - Revise
    public static int[] arrayRankTransform(int[] arr) {
        //Since K is not defined so we can use sorting here instead of PQ we are using map to store rank
        // TC will ne nlogn in both with pq and sorting
        Map<Integer, Integer> map = new HashMap<>();
        int[] arrCopy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arrCopy);

        int rank = 1;
        for (int i = 0; i < arrCopy.length; i++) {
            if (!map.containsKey(arrCopy[i])) {
                map.put(arrCopy[i], rank);
                rank++;
            }
        }

        int res[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = map.get(arr[i]);
        }
        return res;
    }

    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] res1 = arrayRankTransform(new int[]{40, 10, 20, 30});
        print(res1);
        int[] res2 = arrayRankTransform(new int[]{100,100,100});
        print(res2);
        int[] res3 = arrayRankTransform(new int[]{37,12,28,9,100,56,80,5,12});
        print(res3);
    }
}
