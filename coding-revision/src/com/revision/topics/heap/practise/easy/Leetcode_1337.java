package com.revision.topics.heap.practise.easy;

import java.util.Arrays;
import java.util.PriorityQueue;

// PL - https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/description/

public class Leetcode_1337 {

    public static int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Leetcode_1337Pair> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.elem != o2.elem) {
                return o1.elem - o2.elem;
            }
            return o1.idx - o2.idx;
        });

        for (int i = 0; i < mat.length; i++) {
            pq.add(new Leetcode_1337Pair(Arrays.stream(mat[i]).sum(), i));
        }

        int[] res = new int[k];
        int i = 0;
        while (k-- > 0) {
            res[i] = pq.poll().idx;
            i++;
        }
        return res;
    }

    static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        print(kWeakestRows(new int[][]{{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}}, 3));
    }
}

class Leetcode_1337Pair {
    int elem;
    int idx;

    public Leetcode_1337Pair(int elem, int idx) {
        this.elem = elem;
        this.idx = idx;
    }
}