package com.revision.topics.heap;

import java.util.Collections;
import java.util.PriorityQueue;

// PL - https://www.geeksforgeeks.org/problems/sum-of-elements-between-k1th-and-k2th-smallest-elements3133/1
// VL - https://www.youtube.com/watch?v=3ioQQQrnw4Q&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=10
public class ElementsSumBetweenk1k2smallest {

    public static long sumBetweenTwoKth(long A[], long N, long K1, long K2) {
        PriorityQueue<Long> pq=  new PriorityQueue<>(Collections.reverseOrder());

        //find K1 smallest
        for (int i = 0; i < A.length; i++) {
            pq.add(A[i]);

            if (pq.size() > K1) {
                pq.poll();
            }
        }

        long K1Smallest = pq.poll();

        pq.clear();
        //find K1 smallest
        for (int i = 0; i < A.length; i++) {
            pq.add(A[i]);

            if (pq.size() > K2) {
                pq.poll();
            }
        }

        long K2Smallest = pq.poll();

        long sum = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > K1Smallest && A[i] < K2Smallest) {
                sum += A[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumBetweenTwoKth(new long[]{20, 8, 22, 4, 12, 10, 14}, 7, 3, 6));
        System.out.println(sumBetweenTwoKth(new long[]{10, 2, 50, 12, 48, 13}, 6, 2, 6));
    }
}
