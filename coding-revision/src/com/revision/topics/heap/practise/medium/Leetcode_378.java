package com.revision.topics.heap.practise.medium;

import java.util.Collections;
import java.util.PriorityQueue;

// PL - https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/

public class Leetcode_378 {

    public static int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                pq.add(matrix[i][j]);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }
        return pq.poll();
    }

    public static void main(String[] args) {
        System.out.println(kthSmallest(new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 8));
        System.out.println(kthSmallest(new int[][]{{-5}}, 1));
    }
}
