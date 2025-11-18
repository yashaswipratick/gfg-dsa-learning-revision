package com.revision.topics.sliding.window.problems.variable_size_window;

import java.util.HashMap;
import java.util.Map;

// Pl - https://leetcode.com/problems/longest-substring-without-repeating-characters/
// VL - https://www.youtube.com/watch?v=Lav6St0W_pQ&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=10
public class Leetcode_3 {

    public static int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int max = -1;

        Map<Character, Integer> map = new HashMap<>();

        while (j < s.length()) {
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0) + 1);

            if (map.size() > j-i+1) {
                j++;
            } else if (map.size() == j-i+1) {
                max = Math.max(max, j-i+1);
                j++;
            } else if (map.size() < j- i + 1){
                while (map.size() < j- i + 1) {
                    char c1 = s.charAt(i);
                    if (map.containsKey(c1)) {
                        map.put(c1, map.get(c1) - 1);
                    }
                    if (map.containsKey(c1) && map.get(c1) == 0) {
                        map.remove(c1);
                    }
                    i++;
                }
                j++;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
