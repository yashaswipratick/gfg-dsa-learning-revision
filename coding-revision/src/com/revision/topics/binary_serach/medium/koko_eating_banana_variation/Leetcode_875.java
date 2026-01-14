package com.revision.topics.binary_serach.medium.koko_eating_banana_variation;

// PL - https://leetcode.com/problems/koko-eating-bananas/description
// VL - https://www.youtube.com/watch?v=QQcEIxK-snE&list=PLpIkg8OmuX-LkgtrEF7eyyYWJM3m5tVQY&index=11
public class Leetcode_875 {

    // TODO - Revisit
    public static int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = maxInArray(piles);

        while (start <= end) {
            long mid = start + (end - start) / 2;

            if (canEatAllBanana(piles, mid, h)) {
                end = (int) mid - 1;
            } else {
                start = (int) mid + 1;
            }
        }
        return start;
    }

    private static boolean canEatAllBanana(int[] piles, long mid, long h) {
        long sum = 0;
        for (int i = 0; i < piles.length; i++) {
            long quotent = piles[i] / mid;
            long remainder = 0;
            if (piles[i] % mid > 0) {
                remainder = 1;
            }
            sum += (quotent + remainder);
        }
        if (sum > h)
            return false;
        return true;
    }

    private static int maxInArray(int[] piles) {
        int max = 0;
        for (int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
        System.out.println(minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5));
        System.out.println(minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6));
        System.out.println(minEatingSpeed(new int[]{805306368, 805306368, 805306368}, 1000000000));
    }
}
