package com.revision.topics.binary_serach.easy.interactive;

// PL -https://leetcode.com/problems/guess-number-higher-or-lower/
public class Leetcode_374 {

    public int guessNumber(int n) {
        int start = 0;
        int end = n;

        while(start <= end) {
            int mid = start + (end-start) / 2;

            int i = guess(mid);

            if(i == 0) {
                return mid;
            } else if (i == -1) {
                end = mid - 1;
            } else {
                start = mid+1;
            }
        }
        return -1;
    }

    private int guess(int mid) {
        return 0;
    }
}
