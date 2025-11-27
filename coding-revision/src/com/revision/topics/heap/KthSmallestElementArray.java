package com.revision.topics.heap;

import java.util.Collections;
import java.util.PriorityQueue;

// PL - https://www.geeksforgeeks.org/problems/kth-smallest-element5635/1
//VL - https://www.youtube.com/watch?v=4BfL2Hjvh8g&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=2
public class KthSmallestElementArray {

    // If asked for smallest then use max heap.
    public static int kthSmallest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);

            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        System.out.println(kthSmallest(new int[]{10, 5, 4, 3, 48, 6, 2, 33, 53, 10}, 4));
        System.out.println(kthSmallest(new int[]{7, 10, 4, 3, 20, 15}, 3));
    }
}
