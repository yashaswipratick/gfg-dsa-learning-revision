package com.revision.topics.heap;

import java.util.PriorityQueue;

//PL - https://www.geeksforgeeks.org/problems/nearly-sorted-1587115620/1
//VL - https://www.youtube.com/watch?v=dYfM6J1y0mU&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=4
public class NearlySorted {

    public static void nearlySorted(int[] arr, int k) {
        // code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);

            if (pq.size() > k) {
                arr[j] = pq.poll();
                j++;
            }
        }
        while (!pq.isEmpty()) {
            arr[j] = pq.poll();
            j++;
        }
        print(arr);
    }

    static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{2, 3, 1, 4};
        nearlySorted(arr1, 2);

        int[] arr2 = new int[]{7, 9, 14};
        nearlySorted(arr2, 1);

        int[] arr3 = new int[]{6, 5, 3, 2, 8, 10, 9};
        nearlySorted(arr3, 3);
    }
}
