package com.revision.topics.binary_serach.medium.peak_element;

// PL = https://leetcode.com/problems/peak-index-in-a-mountain-array
public class Leetcode_852 {

    // TODO - Revisit
    public static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid > 0 && arr[mid] >= arr[mid - 1] && mid < arr.length - 1 && arr[mid] >= arr[mid + 1]) {
                return mid;
            } else if (mid == 0 || arr[mid] > arr[mid - 1]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(peakIndexInMountainArray(new int[]{0, 1, 0}));
        System.out.println(peakIndexInMountainArray(new int[]{0, 2, 1, 0}));
        System.out.println(peakIndexInMountainArray(new int[]{0, 10, 5, 2}));
    }
}
