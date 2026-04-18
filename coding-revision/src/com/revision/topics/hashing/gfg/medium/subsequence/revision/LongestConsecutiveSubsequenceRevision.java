package com.revision.topics.hashing.gfg.medium.subsequence.revision;

import java.util.HashSet;

public class LongestConsecutiveSubsequenceRevision {

    public static int longestConsecutiveSubsequence(int[] array) {
        HashSet<Integer> set = new HashSet<>();

        int res = 1;

        for (int i : array) {
            set.add(i);
        }

        for (int i : set) {
            if (!set.contains(i - 1)) {
                int cur = 1;
                while (set.contains(i + cur)) {
                    cur++;
                }
                res = Math.max(res, cur);
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
