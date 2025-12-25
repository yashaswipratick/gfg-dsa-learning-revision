package com.revision.topics.heap.practise.medium;

import java.util.PriorityQueue;

public class Leetcode_3767 {
    // TODO - Revisit
    public static long maxPoints(int[] technique1, int[] technique2, int k) {

        // Min-heap based on the "loss" when choosing technique1 instead of technique2
        // loss = technique2[i] - technique1[i]
        // Smaller loss means cheaper to switch to technique1
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        int count = 0;     // Number of tasks done using technique1
        long total = 0L;   // Total points earned

        // Step 1: First pass – take all guaranteed profitable choices
        for (int i = 0; i < technique1.length; i++) {

            // If technique1 gives equal or more points,
            // we should always choose technique1
            if (technique1[i] >= technique2[i]) {
                total += technique1[i];
                count++;   // contributes to minimum k requirement
            }
            // Otherwise, technique2 is better,
            // but we may still need technique1 later to satisfy k
            else {
                // Store index and loss if we are forced to choose technique1
                pq.offer(new int[]{i, technique2[i] - technique1[i]});
            }
        }

        // Step 2: Process remaining tasks in increasing order of loss
        while (!pq.isEmpty()) {
            int[] pair = pq.poll();
            int idx = pair[0];

            // If we still haven't used technique1 k times,
            // we MUST choose technique1 even if it causes some loss
            if (count < k) {
                total += technique1[idx];
                count++;
            }
            // Otherwise, we are free to maximize profit,
            // so choose the better technique2
            else {
                total += technique2[idx];
            }
        }

        // Step 3: Return the maximum total points
        return total;
    }

    public static void main(String[] args) {
        System.out.println(maxPoints(new int[]{5, 2, 10}, new int[]{10, 3, 8}, 2));
        System.out.println(maxPoints(new int[]{10, 20, 30}, new int[]{5, 15, 25}, 2));
        System.out.println(maxPoints(new int[]{1, 2, 3}, new int[]{4, 5, 6}, 0));
    }
}
