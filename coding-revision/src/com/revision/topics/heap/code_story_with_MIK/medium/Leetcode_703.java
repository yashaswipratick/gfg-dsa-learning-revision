package com.revision.topics.heap.code_story_with_MIK.medium;

import java.util.PriorityQueue;

// PL - https://leetcode.com/problems/kth-largest-element-in-a-stream/description/
// VL - https://www.youtube.com/watch?v=3Bge5OCcXUk&list=PLpIkg8OmuX-IkxvvfOeZp-Ot0UWHMGAT-&index=7
public class Leetcode_703 {

    PriorityQueue<Integer> pq;
    int k;

    public Leetcode_703(int k, int[] nums) {
        this.pq = new PriorityQueue<>();
        this.k = k;

        for (int i : nums) {
            pq.add(i);
            if (pq.size() > this.k) {
                pq.poll();
            }
        }
    }

    public int add(int val) {
        pq.add(val);
        if (pq.size() > this.k) {
            pq.poll();
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        Leetcode_703 kthLargest1 = new Leetcode_703(4, new int[]{7, 7, 7, 7, 8, 3});
        System.out.println(kthLargest1.add(2)); // return 7
        System.out.println(kthLargest1.add(10)); // return 7
        System.out.println(kthLargest1.add(9)); // return 7
        System.out.println(kthLargest1.add(9)); // return 8

        Leetcode_703 kthLargest = new Leetcode_703(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3)); // return 4
        System.out.println(kthLargest.add(5)); // return 5
        System.out.println(kthLargest.add(10)); // return 5
        System.out.println(kthLargest.add(9)); // return 8
        System.out.println(kthLargest.add(4)); // return 8

    }
}
