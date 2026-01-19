package com.revision.topics.binary_serach.medium.interval;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// PL - https://leetcode.com/problems/find-right-interval/description/
// VL - https://www.youtube.com/watch?v=uSrRvXntLOI
public class Leetcode_436 {

    // TODO - Revisit
    public static int[] findRightInterval(int[][] intervals) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i][0], i);
        }

        int arr[] = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            arr[i] = intervals[i][0];
        }

        Arrays.sort(arr);

        for (int i = 0; i < intervals.length; i++) {
            int key = findIndex(arr, intervals[i][1]);
            if (key == arr.length) {
                arr[i] = -1;
            } else if (key == 0) {
                if (intervals[i][1] < arr[i]) {
                    arr[i] = arr[0];
                } else {

                }
            } else {
                arr[i] = map.get(key);
            }
        }
        return arr;
    }

    private static int findIndex(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start )/ 2;

            if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] rightInterval1 = findRightInterval(new int[][]{{1, 2}});
        for (int i = 0; i < rightInterval1.length; i++) {
            System.out.println(rightInterval1[i] + " ");
        }

        int[] rightInterval2 = findRightInterval(new int[][]{{3,4},{2,3},{1,2}});
        for (int i = 0; i < rightInterval2.length; i++) {
            System.out.print(rightInterval2[i] + " ");
        }
    }
}
