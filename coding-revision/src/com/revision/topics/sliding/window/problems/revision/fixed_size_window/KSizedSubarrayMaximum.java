package com.revision.topics.sliding.window.problems.revision.fixed_size_window;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

// PL - https://www.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k3101/1
// VL - https://www.youtube.com/watch?v=xFJXtB5vSmM&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=6
public class KSizedSubarrayMaximum {

    //TODO - Revise again
    public static ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        int i = 0;
        int j = 0;
        Deque<Integer> deque = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        while (j < arr.length) {
            //At every jth index compare jth index element with deque last stored index,
            // if it is smaller remove from dequeu.
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[j]) {
                deque.pollLast();
            }

            deque.offerLast(j);

            if (j-i+1 < k) {
                j++;
            } else if (j-i+1 == k) {
                result.add(arr[deque.peekFirst()]);

                if (i == deque.peekFirst()) {
                    deque.pollFirst();
                }
                i++;
                j++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxOfSubarrays(new int[]{1, 2, 3, 1, 4, 5, 2, 3, 6}, 3));
    }
}
