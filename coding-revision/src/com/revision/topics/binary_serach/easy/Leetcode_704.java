package com.revision.topics.binary_serach.easy;

// PL - https://leetcode.com/problems/binary-search/description/
public class Leetcode_704 {

    public static int search(int[] array, int num) {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (array[mid] == num) {
                return mid;
            } else if (array[mid] < num) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
    }
}
