package com.revision.topics.heap.code_story_with_MIK.medium;

import java.util.PriorityQueue;

// Pl - https://leetcode.com/problems/kth-largest-element-in-an-array/description/
// VL - https://www.youtube.com/watch?v=cI0shWNnB4o&list=PLpIkg8OmuX-IkxvvfOeZp-Ot0UWHMGAT-&index=12
public class Leetcode_215 {

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);

            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }
}
