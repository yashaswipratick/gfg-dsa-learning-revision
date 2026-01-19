package com.revision.topics.binary_serach.medium;

import java.util.Arrays;

// PL - https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/?envType=problem-list-v2&envId=rktnezq3
// VL - https://www.youtube.com/watch?v=erWfh_hBF80
public class Leetcode_1482 {

    // TODO - Revisit
    public static int minDays(int[] bloomDay, int m, int k) {
        int start = 0;
        int end = getax(bloomDay);
        int res = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (canMakeBouquet(bloomDay, mid, k) >= m) {
                res = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }

    private static int canMakeBouquet(int[] bloomDay, int mid, int k) {
        int count = 0;
        int bouqCount = 0;

        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= mid) {
                count++;
            } else {
                count = 0;
            }

            if (count == k) {
                bouqCount++;
                count = 0;
            }
        }
        return bouqCount;
    }

    private static int getax(int[] bloomDay) {
        return Arrays.stream(bloomDay).max().getAsInt();
    }

    private static int getMin(int[] bloomDay) {
        return Arrays.stream(bloomDay).min().getAsInt();
    }

    public static void main(String[] args) {
        System.out.println(minDays(new int[]{1, 10, 3, 10, 2}, 3, 1));
        System.out.println(minDays(new int[]{1,10,3,10,2}, 3, 2));
        System.out.println(minDays(new int[]{7,7,7,7,12,7,7}, 2, 3));
    }
}
