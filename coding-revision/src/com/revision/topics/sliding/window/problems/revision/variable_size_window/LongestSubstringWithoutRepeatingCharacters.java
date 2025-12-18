package com.revision.topics.sliding.window.problems.revision.variable_size_window;

import java.util.HashMap;
import java.util.Map;

// PL - https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
// VL - https://www.youtube.com/watch?v=L6cffskouPQ&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=11
public class LongestSubstringWithoutRepeatingCharacters {

    //variation of LongestSubstringWithKUniques
    //Here window size is not provided so window size will be j-i+1;
    //if window size is greater than j-i+1 then keep on adding element
    //if window size equals to j-i+1 then calculate the max
    // if window size is less than j-i+1 then run a loop until map size is less than j-i+1
    // and remove element from ith index.

    //TODO - Revise again
    public static int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int max = -1;

        if (s.isEmpty()) return 0;

        Map<Character, Integer> map = new HashMap<>();

        while (j < s.length()) {
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.size() > j-i+1) {
                j++;
            } else if (map.size() == j - i + 1) {
                max = Math.max(max, j-i+1);
                j++;
            } else if (map.size()<j-i+1) {
                while (map.size() < j-i+1){
                    char cur = s.charAt(i);
                    if (map.containsKey(cur)) {
                        map.put(cur, map.get(cur) - 1);
                    }
                    if (map.get(cur) == 0) {
                        map.remove(cur);
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
