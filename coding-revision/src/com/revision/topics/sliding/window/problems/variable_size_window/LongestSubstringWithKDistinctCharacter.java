package com.revision.topics.sliding.window.problems.variable_size_window;

import java.util.HashMap;
import java.util.Map;

// PL - https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
// VL - https://www.youtube.com/watch?v=seOKHXB_w74&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=12
public class LongestSubstringWithKDistinctCharacter {
    //variation - Pick Toys, Fruits into basket, Find longest substring with 2 unique characters

    //1,2,3,2,2
    public static int totalFruit(String s, int k) {
        int i = 0;
        int j = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (j < s.length()) {
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0 ) + 1);

            if (map.size() < k) {
                j++;
            } else if (map.size() == k) {
                int sum = map.values().stream().mapToInt(value -> value).sum();
                max = Math.max(sum, max);
                j++;
            } else {
                char curr = s.charAt(i);
                if (map.containsKey(curr)) {
                    map.put(curr, map.get(curr) - 1);
                }
                if (map.get(curr).equals(0)) {
                    map.remove(curr);
                }
                i++;
                j++;
            }
        }

        //edge case
        if (map.size() == 1 && max == 0) {
            max = Math.max(max, map.values().stream().mapToInt(value -> value).sum());
        }
        return max;
    }

    public static void main(String[] args) {
        /*System.out.println(totalFruit(new int[]{1, 2, 1}));
        System.out.println(totalFruit(new int[]{0, 1, 2, 2}));
        System.out.println(totalFruit(new int[]{1,2,3,2,2}));*/
        System.out.println(totalFruit("aabacbebebe", 3));
    }
}
