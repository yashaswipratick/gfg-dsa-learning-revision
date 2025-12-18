package com.revision.topics.heap;

import java.util.*;

// Pl- https://www.geeksforgeeks.org/problems/maximum-sum-combination/1
public class MaximumSumCombination {

    public static ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < a.length; i++) {
            int sum = 0;
            for (int j = 0; j < b.length; j++) {
                sum = a[i] + b[j];
                pq.add(sum);

                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        while (!pq.isEmpty()) {
            list.add(pq.poll());
        }
        Collections.sort(list, Collections.reverseOrder());
        return list;
    }

    // TODO - Revise the Optimised version copied from chatgpt
    public ArrayList<Integer> topKSumPairsOptimise(int[] a, int[] b, int k) {
        Arrays.sort(a);
        Arrays.sort(b);

        int n = a.length;
        int m = b.length;

        // max heap storing: [sum, i, j]
        PriorityQueue<int[]> maxHeap =
                new PriorityQueue<>((x, y) -> y[0] - x[0]);

        // to avoid duplicate pairs
        Set<String> visited = new HashSet<>();

        // start from largest values
        maxHeap.add(new int[]{a[n - 1] + b[m - 1], n - 1, m - 1});
        visited.add((n - 1) + "," + (m - 1));

        ArrayList<Integer> result = new ArrayList<>();

        while (k > 0 && !maxHeap.isEmpty()) {
            int[] top = maxHeap.poll();
            int sum = top[0], i = top[1], j = top[2];

            result.add(sum);
            k--;

            // next pair (i-1, j)
            if (i - 1 >= 0) {
                String key = (i - 1) + "," + j;
                if (!visited.contains(key)) {
                    visited.add(key);
                    maxHeap.add(new int[]{a[i - 1] + b[j], i - 1, j});
                }
            }

            // next pair (i, j-1)
            if (j - 1 >= 0) {
                String key = i + "," + (j - 1);
                if (!visited.contains(key)) {
                    visited.add(key);
                    maxHeap.add(new int[]{a[i] + b[j - 1], i, j - 1});
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(topKSumPairs(new int[]{3, 2}, new int[]{1, 4}, 2));
        System.out.println(topKSumPairs(new int[]{1, 4, 2, 3}, new int[]{2, 5, 1, 6}, 3));
    }
}
