package com.revision.topics.heap.practise.medium;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

// PL - https://leetcode.com/problems/smallest-number-in-infinite-set/description/

public class Leetcode_2336 {

    Set<Integer> set;
    PriorityQueue<Integer> pq;

    public Leetcode_2336() {
        this.set = new HashSet<>();
        for(int i = 1; i <= 1000; i++) {
            set.add(i);
        }
        this.pq = new PriorityQueue<>();
        this.pq.addAll(this.set);
    }

    public int popSmallest() {
        Integer poll = pq.poll();
        set.remove(poll);
        return poll;
    }

    public void addBack(int num) {
        if (!set.contains(num)) {
            set.add(num);
            pq.add(num);
        }
    }

    public static void main(String[] args) {
        Leetcode_2336 obj = new Leetcode_2336();
        obj.addBack(2);    // 2 is already in the set, so no change is made.
        System.out.println(obj.popSmallest()); // return 1, since 1 is the smallest number, and remove it from the set.
        System.out.println(obj.popSmallest()); // return 2, and remove it from the set.
        System.out.println(obj.popSmallest()); // return 3, and remove it from the set.
        obj.addBack(1);    // 1 is added back to the set.
        System.out.println(obj.popSmallest()); // return 1, since 1 was added back to the set and
        // is the smallest number, and remove it from the set.
        System.out.println(obj.popSmallest()); // return 4, and remove it from the set.
        System.out.println(obj.popSmallest()); // return 5, and remove it from the set.
    }
}
