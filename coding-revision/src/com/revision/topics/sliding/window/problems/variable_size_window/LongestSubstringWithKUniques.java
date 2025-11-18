package com.revision.topics.sliding.window.problems.variable_size_window;

import java.util.HashMap;
import java.util.Map;

// PL - https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
// VL - https://www.youtube.com/watch?v=Lav6St0W_pQ&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=10
public class LongestSubstringWithKUniques {

    public static int longestKSubstr(String s, int k) {
        // code here
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int max = -1;

        while (j < s.length()) {
            char c = s.charAt(j);

            map.put(c, map.getOrDefault(c, 0) + 1);

            if(map.size() < k) {
                j++;
            } else if (map.size() == k) {
                max = Math.max(max, j-i+1);
                j++;
            } else if (map.size() > k) {
                while (map.size() > k) {
                    char curr = s.charAt(i);
                    if (map.containsKey(curr)) {
                        map.put(curr, map.get(curr) - 1);
                    }
                    if (map.containsKey(curr) && map.get(curr) == 0) {
                        map.remove(curr);
                    }
                    i++;
                }
                j++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestKSubstr("aabacbebebe", 3));
        System.out.println(longestKSubstr("aaaa", 2));
        System.out.println(longestKSubstr("aabaaab", 2));
    }
}
