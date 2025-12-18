package com.revision.topics.sliding.window.problems.revision.fixed_size_window;

import java.util.HashMap;
import java.util.Map;

// PL - https://www.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1
// VL - https://www.youtube.com/watch?v=MW4lJ8Y0xXk&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=5
public class CountOccurenceOfAnagram {

    //TODO - Revise again
    static int search(String pat, String txt) {
        int i = 0;
        int j = 0;
        int count = 0;

        Map<Character, Integer> patMap = new HashMap<>();
        Map<Character, Integer> curMap = new HashMap<>();

        for (char c : pat.toCharArray()) {
            patMap.put(c, patMap.getOrDefault(c, 0) + 1);
        }

        while (j < txt.length()) {
            char c = txt.charAt(j);
            curMap.put(c, curMap.getOrDefault(c, 0) + 1);
            if (j - i + 1 < pat.length()) {
                j++;
            } else if (j - i + 1 == pat.length()) {
                boolean b = checkIfAnagram(curMap, patMap);
                if (b) {
                    count++;
                }
                char cur = txt.charAt(i);
                if (curMap.containsKey(cur)) {
                    curMap.put(cur, curMap.get(cur) - 1);
                }
                if (curMap.get(cur) == 0) {
                    curMap.remove(cur);
                }
                i++;
                j++;
            }
        }
        return count;
    }

    private static boolean checkIfAnagram(Map<Character, Integer> curMap, Map<Character, Integer> patMap) {
        for (Map.Entry<Character, Integer> entry : patMap.entrySet()) {
            if (!curMap.containsKey(entry.getKey())
                    || (curMap.containsKey(entry.getKey()) && !curMap.get(entry.getKey()).equals(entry.getValue()))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(search("for", "forxxorfxdofr"));
        System.out.println(search("aaba", "aabaabaa"));
    }
}
