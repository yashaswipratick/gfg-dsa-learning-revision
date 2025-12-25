package com.revision.topics.heap.practise.medium;

import java.util.PriorityQueue;

// PL - https://leetcode.com/problems/k-th-smallest-prime-fraction/

public class Leetcode_786 {

    public static int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(((o1, o2) -> Double.compare(o2.avg, o1.avg)));

        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                pq.add(new Pair(arr[i], arr[j], ((double) arr[i] /arr[j])));
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }
        int[] res = new int[2];
        Pair peek = pq.peek();
        res[0] = peek.i;
        res[1] = peek.j;;
        return res;
    }

    static class Pair {
        int i;
        int j;
        double avg;

        public Pair(int i, int j, double avg) {
            this.i = i;
            this.j = j;
            this.avg = avg;
        }
    }

    static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        print(kthSmallestPrimeFraction(new int[]{1,2,3,5}, 3));
        print(kthSmallestPrimeFraction(new int[]{1,7}, 1));
        print(kthSmallestPrimeFraction(new int[]{1,29,47}, 1));
    }
}
