package com.revision.topics.array.problems;

// PL - https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Arrays/problem/rearrange-an-array-with-o1-extra-space3142
public class RearrangeArray_29 {

    // TODO - revisit in 3-5 days
    public static void arrange(long[] arr) {
        long[] res = new long[arr.length];

        for(int i = 0; i<arr.length; i++) {
            long cur = arr[i];
            long element = arr[(int)cur];
            res[i] = element;
        }

        System.arraycopy(res, 0, arr, 0, arr.length);
    }

    public static void main(String[] args) {
        arrange(new long[]{1,0});
        arrange(new long[]{4,0,2,1,3});
    }
}
