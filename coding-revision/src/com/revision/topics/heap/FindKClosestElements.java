package com.revision.topics.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

// PL - https://leetcode.com/problems/find-k-closest-elements/submissions/1840671611/
// VL - https://www.youtube.com/watch?v=J8yLD-x7fBI&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=5
public class FindKClosestElements {


    /*
 ------------------------------------------------------------------------------------
 APPROACH: Find K Closest Elements Using a Max-Heap (PriorityQueue)
 ------------------------------------------------------------------------------------

 GOAL:
 -----
 From a sorted array, return the 'k' elements that are closest to value 'x'.


 KEY IDEA:
 ---------
 Use a MAX-HEAP that always stores the current k closest elements.
 The farthest element among these k should stay on top so we can remove it.

 WHY MAX-HEAP?
 -------------
 Because whenever the heap size exceeds k, we want to remove the "worst" element:
    → The element with the largest difference from x
 If differences tie, the larger number is considered farther (as required by problem).


 STEPS:
 ------

 1. Create a max-heap where:
        - Elements are stored as int[]{diff, value}
        - Comparator sorts by:
              (1) larger diff first
              (2) if diff same → larger value first

 2. Loop through every number 'num' in arr:
        - Compute diff = abs(num - x)
        - Add [diff, num] to the heap

 3. If heap size > k:
        - Remove the element at the top (the farthest from x)

 4. After processing all elements:
        - Heap contains EXACTLY k closest elements, but unsorted

 5. Extract all values from heap into a list

 6. Sort the list because final answer must be in ascending order

 7. Return the sorted list


 TIME COMPLEXITY:
 ----------------
 Inserting n elements into a heap of size k:
        → O(n log k)
 Sorting final k elements:
        → O(k log k)
 Total:
        → O(n log k)


 WHY THIS WORKS:
 ---------------
 At any moment, the heap contains only the k closest elements seen so far.
 Anything farther gets thrown out immediately.
 So at the end, we are left with the correct k closest values.

 ------------------------------------------------------------------------------------
*/


    // TODO - Revise
        public static List<Integer> findClosestElements(int[] arr, int k, int x) {

            // Max-heap: keep k closest elements
            PriorityQueue<int[]> pq = new PriorityQueue<>(
                    (a, b) -> {
                        // compare by difference
                        if (b[0] != a[0]) return b[0] - a[0];
                        // if difference is same, compare actual values
                        return b[1] - a[1];
                    }
            );

            for (int num : arr) {
                int diff = Math.abs(num - x);
                pq.offer(new int[]{diff, num});

                if (pq.size() > k) {
                    pq.poll();  // remove farthest
                }
            }

            List<Integer> result = new ArrayList<>();
            while (!pq.isEmpty()) {
                result.add(pq.poll()[1]);
            }

            Collections.sort(result);  // final sorted order
            return result;
        }

        public static List<Integer> findClosestElementsTwoPPointer(int[] arr, int k, int x) {
            int left = 0;
            int right = arr.length - 1;

            // Shrink window until size becomes k
            while (right - left + 1 > k) {
                if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
                    left++;   // drop leftmost (farther from x)
                } else {
                    right--;  // drop rightmost
                }
            }

            // Build result (already sorted)
            List<Integer> res = new ArrayList<>();
            for (int i = left; i <= right; i++) {
                res.add(arr[i]);
            }

            return res;
        }


    public static void main(String[] args) {
        System.out.println(findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3));
    }
}
