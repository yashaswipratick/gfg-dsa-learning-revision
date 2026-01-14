package com.revision.topics.binary_serach.medium.koko_eating_banana_variation;

import java.util.Arrays;

// PL - https://leetcode.com/problems/minimum-time-to-complete-trips/description/
// VL - https://www.youtube.com/watch?v=tUCVupA0lAc&list=PLpIkg8OmuX-LkgtrEF7eyyYWJM3m5tVQY&index=10
public class Leetcode_2187 {

    // TODO - Revisit
    public static long minimumTime(int[] time, int totalTrips) {
        long start = 1;
        long end = (long) Arrays.stream(time).min().getAsInt() * totalTrips;

        while (start <= end) {
            long mid = start + (end - start) / 2;

            if (possible(time, mid, totalTrips)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private static boolean possible(int[] time, long givenTime, int totalTrips) {
        long actualTrips = 0;

        for (int i = 0; i < time.length; i++) {
            actualTrips += (givenTime / time[i]);
        }
        return actualTrips >= totalTrips;
    }

    public static void main(String[] args) {
        System.out.println(minimumTime(new int[]{1, 2, 3}, 5));
        System.out.println(minimumTime(new int[]{2}, 1));
    }
}
