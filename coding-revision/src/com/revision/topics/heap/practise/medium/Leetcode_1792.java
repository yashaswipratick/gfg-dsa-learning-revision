package com.revision.topics.heap.practise.medium;

import java.util.PriorityQueue;

// PL - https://leetcode.com/problems/maximum-average-pass-ratio/
public class Leetcode_1792 {

    /*
         APPROACH (Greedy + PriorityQueue):

         1) Each class is defined by:
                passed = p
                total  = t
            Current pass ratio = p / t

         2) When we add ONE extra student (who always passes):
                new ratio = (p + 1) / (t + 1)

         3) The IMPORTANT part is the "gain" we get by adding a student:
                gain = (p + 1) / (t + 1) - (p / t)

            This gain is different for each class.

         4) Greedy Observation:
                To maximize the final average pass ratio,
                we must ALWAYS assign the next extra student
                to the class with the MAXIMUM gain.

         5) Since gain changes after every assignment,
                we need a data structure that:
                - Always gives us the class with max gain
                - Allows re-insertion after updating values

            → PriorityQueue (Max Heap)

         6) Algorithm Steps:
                a) For each class:
                     - Compute its initial gain
                     - Push it into the PriorityQueue

                b) While extraStudents > 0:
                     - Poll the class with maximum gain
                     - Add one student to it (p++, t++)
                     - Recompute its gain
                     - Push it back into the PriorityQueue

                c) After assigning all extra students:
                     - Compute final average:
                           sum of (p / t) for all classes
                           divided by number of classes

         7) Time Complexity:
                Building heap:      O(N)
                Each extra student: O(log N)
                Total:              O((N + extraStudents) log N)

         8) Space Complexity:
                O(N) for PriorityQueue
     */

    // TODO - Revisit
    public static double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> Double.compare(b.gain(), a.gain()) // MAX heap by gain
        );

        for (int[] c : classes) {
            pq.offer(new Pair(c[0], c[1]));
        }

        while (extraStudents-- > 0) {
            Pair top = pq.poll();
            top.pass++;
            top.total++;
            pq.offer(top);
        }

        double sum = 0.0;
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            sum += (double) p.pass / p.total;
        }

        return sum / classes.length;
    }

    public static void main(String[] args) {
        System.out.println(maxAverageRatio(new int[][]{{1, 2}, {3, 5}, {2, 2}}, 2));
        //System.out.println(maxAverageRatio(new int[][]{{2, 4}, {3, 9}, {4, 5}, {2, 10}}, 4));
    }

    static class Pair {
        int pass;
        int total;

        Pair(int pass, int total) {
            this.pass = pass;
            this.total = total;
        }

        // marginal gain if one student is added
        double gain() {
            return (double) (pass + 1) / (total + 1)
                    - (double) pass / total;
        }
    }
}