package com.revision.topics.sliding.window.problems.fixed_size_window;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

// PL - https://www.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k3101/1
// VL - https://www.youtube.com/watch?v=xFJXtB5vSmM&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=6
public class KSizedSubArrayMaximum {

    /**
     * Approach:
     * ------------------------------------------------------------
     * 1. Use a Deque (double-ended queue) to store **indices** of useful elements
     *    for each window of size 'k'.
     *
     * 2. The deque will always maintain elements in **decreasing order**
     *    (i.e., the front of the deque always represents the maximum).
     *
     * 3. Steps:
     *    a. Iterate over each element in the array using index 'j'.
     *
     *    b. Remove all elements from the **back of deque** which are
     *       smaller than or equal to the current element arr[j]
     *       — because they cannot be the maximum if a bigger element comes after them.
     *
     *    c. Add the current index 'j' to the deque.
     *
     *    d. If the window size (j - i + 1) < k → expand the window by moving 'j' forward.
     *
     *    e. When window size == k:
     *         - The element at **front of deque (arr[dq.peekFirst()])** is the
     *           maximum for the current window → add it to the result list.
     *         - Before sliding the window, check if the element going out (i)
     *           is the same as dq.peekFirst(); if yes, remove it from the deque.
     *         - Slide the window by incrementing both i and j.
     *
     * 4. Continue this process till the end of the array.
     *
     * 5. Time Complexity: O(n)
     *    - Each element is added and removed from the deque at most once.
     * 6. Space Complexity: O(k)
     *    - Deque stores at most 'k' elements.
     */
    public static ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>(); // store indices, not values

        int i = 0;
        int j = 0;

        while (j < arr.length) {
            // Step 1: Remove smaller elements from the back
            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[j]) {
                dq.pollLast();
            }

            // Step 2: Add the current element’s index
            dq.offerLast(j);

            // Step 3: Check window size
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                // The element at the front is the largest for this window
                list.add(arr[dq.peekFirst()]);

                // Step 4: Slide the window — remove if out of window
                if (dq.peekFirst() == i) {
                    dq.pollFirst();
                }

                i++;
                j++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        /*System.out.println(maxOfSubarrays(new int[]{1, 2, 3, 1, 4, 5, 2, 3, 6}, 3));
        System.out.println(maxOfSubarrays(new int[]{5, 1, 3, 4, 2}, 1));*/
        System.out.println(maxOfSubarrays(new int[]{45, 8, 12, 7}, 3));
    }
}
