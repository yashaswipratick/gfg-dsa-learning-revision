package com.revision.topics.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//PL - https://leetcode.com/problems/sort-array-by-increasing-frequency/
//VL - https://www.youtube.com/watch?v=hLR5aMzYGGk&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=7
public class SortArrayByIncreasingFrequency {

    /*
    APPROACH: Frequency Sort an Array

    GOAL:
    ---------
    Sort the array so that:
      1. Elements with LOWER frequency appear first.
      2. If two elements have the SAME frequency → the LARGER value appears first.

    EXAMPLE:
      Input:  [-1,1,-6,4,5,-6,1,4,1]
      Output: [5,-1,4,4,-6,-6,1,1,1]

    --------------------------------------------------------------
    STEP-BY-STEP APPROACH
    --------------------------------------------------------------

    1. Build a frequency map
       - Traverse the array
       - Count frequency of each number using HashMap<Integer, Integer>

    2. Use a PriorityQueue (Min-Heap) with a custom comparator
       - We push pairs: (number, frequency)
       - The comparator must sort by:
            a) Increasing frequency     → smaller freq first
            b) If same frequency        → sort by decreasing number

       Comparator logic:
          if (freq1 != freq2) return freq1 - freq2;
          else return num2 - num1;   // larger number first

    3. Push all unique numbers into the priority queue
       - Each entry from the map is inserted as a Pair(number, frequency)

    4. Build the result array
       - Pop elements from priority queue one by one
       - For each popped pair:
            repeat the number 'frequency' times
            and place into result array

    5. Return the modified nums array
       - The array is now sorted according to the required rules

    --------------------------------------------------------------
    TIME COMPLEXITY:
    --------------------------------------------------------------
      Building frequency map      : O(n)
      Push n unique elements into PQ  : O(n log n)
      Reconstruct output array    : O(n)
      Final complexity: O(n log n)

    --------------------------------------------------------------
    SPACE COMPLEXITY:
    --------------------------------------------------------------
      HashMap + PriorityQueue    : O(n)

    --------------------------------------------------------------
    SUMMARY:
    --------------------------------------------------------------
      Frequency ascending  → (rare elements first)
      Value descending     → (bigger number first when same freq)
*/

    //TODO - revise
    public static int[] frequencySort(int[] nums) {
        // Correct comparator:
        // 1. Increasing frequency
        // 2. If equal frequency → decreasing number
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> {
                    if (a.right != b.right)
                        return a.right - b.right;  // lower freq first
                    return b.left - a.left;       // higher value first
                }
        );

        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(new Pair(entry.getKey(), entry.getValue()));
        }

        int i = 0;
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int element = pair.left;
            int count = pair.right;

            while (count-- > 0) {
                nums[i] = element;
                i++;
            }
        }
        return nums;
    }

    static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] res1 = frequencySort(new int[]{1, 1, 2, 2, 2, 3});
        print(res1);
        int[] res2 = frequencySort(new int[]{2,3,1,3,2});
        print(res2);
        int[] res3 = frequencySort(new int[]{-1,1,-6,4,5,-6,1,4,1});
        print(res3);
    }
}
