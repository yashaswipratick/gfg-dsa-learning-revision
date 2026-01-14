package com.revision.topics.binary_serach.medium;

// VL - https://www.youtube.com/watch?v=fVAR6SiATgI
// PL - https://leetcode.com/problems/h-index-ii/description/
public class Leetcode_274 {

    // TODO - Revisit
    public static int hIndex(int[] citations) {
        int start = 0;
        int end = citations.length - 1;
        int n = citations.length;
        int res = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            int papers = n - mid;

            // Check if this mid can be a valid h-index
            if (citations[mid] >= papers) {
                res = papers; // h-index candidate
                end = mid - 1; // try to find a higher h
            } else {
                start = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(hIndex(new int[]{0, 1, 3, 5, 6}));
        System.out.println(hIndex(new int[]{1, 2, 100}));
        System.out.println(hIndex(new int[]{1, 1, 2, 2, 2, 2, 20}));
        System.out.println(hIndex(new int[]{1, 1, 3, 3, 3}));
        System.out.println(hIndex(new int[]{11, 15}));
    }
}
