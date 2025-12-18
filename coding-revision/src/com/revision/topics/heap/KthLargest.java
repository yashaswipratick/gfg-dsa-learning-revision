package com.revision.topics.heap;

import java.util.PriorityQueue;

// Pl - https://leetcode.com/problems/kth-largest-element-in-a-stream
public class KthLargest {

    PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<>();
        this.k = k;

        for(int i : nums) {
            pq.add(i);
            if(pq.size() > k) {
                pq.poll();
            }
        }
    }

    public int add(int val) {
        pq.add(val);
        if(pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 8, 2};
        KthLargest obj = new KthLargest(3, nums);
        int add1 = obj.add(3);
        System.out.println(add1);
        int add2 = obj.add(5);
        System.out.println(add2);
        int add3 = obj.add(10);
        System.out.println(add3);
        int add4 = obj.add(9);
        System.out.println(add4);
        int add5 = obj.add(4);
        System.out.println(add5);
    }
}
