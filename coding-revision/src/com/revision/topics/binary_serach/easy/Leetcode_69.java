package com.revision.topics.binary_serach.easy;

public class Leetcode_69 {

    public static int mySqrt(int x) {
        long start = 1;
        long end = x;
        int res = 0;

        while (start <= end) {
            long mid = start + (end - start) / 2;

            long sqrt = mid*mid;
            if (sqrt == x) {
                return (int) mid;
            } else if (sqrt > x) {
                end = mid - 1;
            } else {
                start = mid + 1;
                res = (int) mid;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }
}
