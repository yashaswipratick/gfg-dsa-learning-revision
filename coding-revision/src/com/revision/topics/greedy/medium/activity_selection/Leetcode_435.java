package com.revision.topics.greedy.medium.activity_selection;

import java.util.*;

// https://leetcode.com/problems/non-overlapping-intervals/description/
public class Leetcode_435 {

    //Approach

    /**
     * Always keep the interval with the smallest end
     * When overlap happens → remove the one with the larger end
     * @param intervals
     * @return
     */

    // TODO - Revisit
    public static int eraseOverlapIntervals(int[][] intervals) {

        // Edge case: no intervals → no removals needed
        if (intervals.length == 0) return 0;

    /*
     STEP 1:
     Sort intervals by their end time.
     Why?
     - Interval with smaller end finishes earlier
     - Leaves more room for future non-overlapping intervals
    */
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

    /*
     STEP 2:
     prevEnd keeps track of the end of last selected interval
     We start by selecting the first interval
    */
        int prevEnd = intervals[0][1];

    /*
     STEP 3:
     Count how many intervals we remove
    */
        int removals = 0;

    /*
     STEP 4:
     Traverse remaining intervals
    */
        for (int i = 1; i < intervals.length; i++) {

        /*
         If current interval overlaps with previous one
         → we must remove one interval
         → greedy choice: remove the one with larger end
         Since array is sorted by end,
         current interval always ends later or equal
        */
            if (intervals[i][0] < prevEnd) {
                removals++;
            }
        /*
         No overlap:
         Safe to keep this interval
         Update prevEnd
        */
            else {
                prevEnd = intervals[i][1];
            }
        }

        // Final answer: minimum number of intervals removed
        return removals;
    }

    public static void main(String[] args) {
        System.out.println(eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
        System.out.println(eraseOverlapIntervals(new int[][]{{1, 2}, {1, 2}, {1, 2}}));
        System.out.println(eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}}));
        System.out.println(eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}}));
    }
}
