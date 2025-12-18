package com.revision.topics.sliding.window.problems.revision.variable_size_window;

import java.util.HashMap;
import java.util.Map;

// PL - https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
// VL - https://www.youtube.com/watch?v=Lav6St0W_pQ&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=10
public class LongestSubstringWithKUniques {

    //TODO - Revise again
    public static int longestKSubstr(String s, int k) {
        int i = 0;
        int j = 0;
        int max = -1;

        Map<Character, Integer> map = new HashMap<>();

        while (j < s.length()) {
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0) + 1);

            if (map.size() < k) {
                j++;
            } else if (map.size() == k) {
                max = Math.max(max, map.values().stream().mapToInt(sum -> sum).sum());
                j++;
            } else {
                char cur = s.charAt(i);
                if (map.containsKey(cur)) {
                    map.put(cur, map.get(cur) - 1);
                }
                if (map.get(cur) == 0) {
                    map.remove(cur);
                }
                i++;
                j++;
            }
        }
        if (map.size() == 1 && max == 0) {
            max = Math.max(max, map.values().stream().mapToInt(sum -> sum).sum());
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestKSubstr("aabacbebebe", 3));
        System.out.println(longestKSubstr("aaaa", 2));
        System.out.println(longestKSubstr("aabaaab", 2));
    }
}
