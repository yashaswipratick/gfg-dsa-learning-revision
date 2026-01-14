package com.revision.topics.binary_serach.easy.interactive;

//PL - https://leetcode.com/problems/first-bad-version/

public class Leetcode_278 {

    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        int res = -1;

        while (start <= end) {
            int mid = start + (end - start) /2;
            boolean isBadVerion = isBadVersion(mid);

            if (!isBadVerion) {
                start = mid + 1;
            } else {
                res = mid;
                end = mid - 1;
            }
        }
        return res;
    }

    private boolean isBadVersion(int mid) {
        return false;
    }

    public static void main(String[] args) {

    }
}
