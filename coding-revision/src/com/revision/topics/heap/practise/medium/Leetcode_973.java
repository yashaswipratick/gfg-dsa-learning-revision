package com.revision.topics.heap.practise.medium;

import java.util.PriorityQueue;

// PL - https://leetcode.com/problems/k-closest-points-to-origin/description/

public class Leetcode_973 {

    // TODO - Revisit - Did it on my own but still come back and revise
    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(((o1, o2) -> Integer.compare(o2.sqrt, o1.sqrt)));

        for (int i = 0; i < points.length; i++) {
            pq.add(new Pair(new int[][]{{points[i][0], points[i][1]}}, getDistance(points[i])));
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[][] res = new int[k][2];
        int i = 0;
        while (!pq.isEmpty()) {
            Pair poll = pq.poll();
            res[i] = poll.arr[0];
            i++;
        }
        return res;
    }

    private static int getDistance(int[] points) {
        return (points[0] * points[0]) + (points[1] * points[1]);
    }

    static class Pair {
        int[][] arr;
        int sqrt;

        public Pair(int[][] arr, int sqrt) {
            this.arr = arr;
            this.sqrt = sqrt;
        }
    }

    static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        print(kClosest(new int[][]{{1,3},{-2,2}}, 1));
        print(kClosest(new int[][]{{3,3},{5,-1},{-2,4}}, 2));
    }
}
