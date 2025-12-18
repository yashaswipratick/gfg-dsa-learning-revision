package com.revision.topics.heap.code_story_with_MIK.medium;

import com.revision.topics.heap.Pair;

import java.util.*;

// Pl - https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/
// VL - https://www.youtube.com/watch?v=eptC4nUL_2A&list=PLpIkg8OmuX-IkxvvfOeZp-Ot0UWHMGAT-&index=10
// VL - https://www.youtube.com/watch?v=PiGYS7BbV_Q&list=PLpIkg8OmuX-IkxvvfOeZp-Ot0UWHMGAT-&index=11 (Optimal)
public class Leetcode_373 {

    //T(O(n-square))
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> list = new ArrayList<>();

        PriorityQueue<Leetcode_373Pair> pq = new PriorityQueue<>(((o1, o2) -> Integer.compare(o2.sum, o1.sum)));

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int sum = nums1[i] + nums2[j];

                if (pq.size() < k) {
                    pq.add(new Leetcode_373Pair(sum, i, j));
                } else if (sum < pq.peek().sum) {
                    pq.poll();
                    pq.add(new Leetcode_373Pair(sum, i, j));
                } else {
                    break;
                }
            }
        }

        while (!pq.isEmpty()) {
            Leetcode_373Pair poll = pq.poll();
            List<Integer> cur = new ArrayList<>();
            cur.add(nums1[poll.i]);
            cur.add(nums2[poll.j]);
            list.add(cur);
        }
        return list;
    }

    public static List<List<Integer>> kSmallestPairsOptimal(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> list = new ArrayList<>();

        PriorityQueue<Leetcode_373Pair> pq = new PriorityQueue<>((Comparator.comparingInt(o -> o.sum)));

        pq.add(new Leetcode_373Pair(nums1[0] + nums2[0], 0, 0));
        Set<Pair> visited = new HashSet<>();
        visited.add(new Pair(0, 0));

        while (!pq.isEmpty() && k > 0) {
            Leetcode_373Pair poll = pq.poll();
            List<Integer> cur = new ArrayList<>();
            int i = poll.i;
            int j = poll.j;
            cur.add(nums1[i]);
            cur.add(nums1[j]);
            list.add(cur);

            //Push i+1, j if possible
            if (i+1 < nums1.length && !visited.contains(new Pair(i + 1, j))) {
                pq.add(new Leetcode_373Pair(nums1[i+1] + nums2[j], i+1, j));
                visited.add(new Pair(i + 1, j));
            }
            //Push i, j+1 if possible
            if (j+1 < nums2.length && !visited.contains(new Pair(i, j+1))) {
                pq.add(new Leetcode_373Pair(nums1[i] + nums2[j+1], i, j+1));
                visited.add(new Pair(i, j+1));
            }
            k--;
        }
        return list;
    }


    public static void main(String[] args) {
        System.out.println(kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3));
        System.out.println(kSmallestPairs(new int[]{1,1,2}, new int[]{1,2,3}, 2));
    }
}

class Leetcode_373Pair {
    int sum;
    int i;
    int j;

    public Leetcode_373Pair(int sum, int i, int j) {
        this.sum = sum;
        this.i = i;
        this.j = j;
    }
}
