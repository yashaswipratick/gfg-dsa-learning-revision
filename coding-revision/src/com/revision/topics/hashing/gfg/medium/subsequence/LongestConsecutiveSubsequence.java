package com.revision.topics.hashing.gfg.medium.subsequence;

import java.util.Arrays;
import java.util.HashSet;

// PL - https://www.geeksforgeeks.org/problems/longest-consecutive-subsequence2449/1
// practice - https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Hashing/problem/longest-consecutive-subsequence2449
// VL - https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Hashing/video/MTM3Nw%3D%3D
public class LongestConsecutiveSubsequence {

    //O(nlogn)
    public static int longestConsecutiveNaiveSolution(int[] array) {
        Arrays.sort(array);
        int count = 1;
        int max = 1;
        for (int i = 1; i < array.length; i++) {
            if ((array[i] - array[i-1]) == 1) {
                count++;
                max = Math.max(count, max);
            }
            //Lets say you array = {2.,3,3,4}, int his case you dont want to consider 3 at index 2 to be beginning
            // element and you have to just ignore it. that is handled in else if condition
            else if (array[i] != array[i-1]){ // look into this part of the logic
                max = Math.max(count, max);
                count = 1;
            }
        }
        return Math.max(max, count);
    }

    // TODO - Revisit
    //O(2n) -> for every array we are doing 2n lookups
    public static int longestConsecutiveSubsequence(int[] array) {
        HashSet<Integer> set = new HashSet<>();

        // put all the elements in hashset
        for (int x : array) {
            set.add(x);
        }

        int res = 1;

        for (int x : set) { // for each x repeat the same process.
            // This check make sure if set not contains x-1 element that means x is the starting element to start with.
            if (!set.contains(x-1)) {
                int curr = 1; // set cur to 1.
                // loop until set contains consecutive elements and increase the current count.
                while (set.contains(x+curr)) {
                    curr++;
                }
                //compare the max with cur and store the max in res variable.
                res = Math.max(curr, res);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutiveSubsequence(new int[]{2, 6, 1, 9, 4, 5, 3}));
        System.out.println(longestConsecutiveSubsequence(new int[]{1, 9, 3, 10, 4, 20, 2}));
        System.out.println(longestConsecutiveSubsequence(new int[]{15, 13, 12, 14, 11, 10, 9}));
    }
}
