package com.revision.topics.heap.code_story_with_MIK.medium;

import java.util.Collections;
import java.util.PriorityQueue;

// PL - https://leetcode.com/problems/find-median-from-data-stream/submissions/1856505462/
// VL - https://www.youtube.com/watch?v=jnj87BSi9Is&list=PLpIkg8OmuX-IkxvvfOeZp-Ot0UWHMGAT-&index=2
public class Leetcode_295 {

    PriorityQueue<Integer> rightMinHeap;
    PriorityQueue<Integer> leftMaxHeap;
    
    public Leetcode_295() {
        leftMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
        rightMinHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (leftMaxHeap.isEmpty() || num < leftMaxHeap.peek()) {
            leftMaxHeap.add(num);
        } else {
            rightMinHeap.add(num);
        }

        if (Math.abs(leftMaxHeap.size() - rightMinHeap.size()) > 1) {
            rightMinHeap.add(leftMaxHeap.poll());
        } else if (rightMinHeap.size() > leftMaxHeap.size()) {
            leftMaxHeap.add(rightMinHeap.poll());
        }
    }

    public double findMedian() {
        if (leftMaxHeap.size() == rightMinHeap.size()) {
            return ((double) (leftMaxHeap.peek() + rightMinHeap.peek()) /2);
        } else {
            return ((double) leftMaxHeap.peek());
        }
    }
    
    public static void main(String[] args) {
        Leetcode_295 leetcode295 = new Leetcode_295();
        leetcode295.addNum(1);    // arr = [1]
        leetcode295.addNum(2);    // arr = [1, 2]
        System.out.println(leetcode295.findMedian()); // return 1.5 (i.e., (1 + 2) / 2)
        leetcode295.addNum(3);    // arr[1, 2, 3]
        System.out.println(leetcode295.findMedian()); // return 2.0

    }
}
