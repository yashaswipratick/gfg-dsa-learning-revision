package com.revision.topics.sliding.window.problems.variable_size_window;

import java.util.HashMap;
import java.util.Map;

// PL - https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
// VL - https://www.youtube.com/watch?v=L6cffskouPQ&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=11
public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        // code here
        if (s.isEmpty()) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int max = -1;

        while (j < s.length()) {
            char c = s.charAt(j);

            map.put(c, map.getOrDefault(c, 0) + 1);

            if(map.size() > j-i+1) {
                j++;
            } else if (map.size() == j-i+1) {
                max = Math.max(max, j-i+1);
                j++;
            } else if (map.size() < j-i+1) {
                while (map.size() < j-i+1) {
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
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring(""));
    }
}
