package com.revision.topics.sliding.window.problems.fixed_size_window;

import java.util.HashMap;
import java.util.Map;


// PL - https://www.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1
// VL - https://www.youtube.com/watch?v=MW4lJ8Y0xXk&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=5
public class CountOccurenceOfAnagram {

    static int search(String pat, String txt) {
        // code here
        int i = 0;
        int j = 0;
        int k = pat.length();
        int count = 0;
        Map<Character, Integer> patMap = new HashMap<>();
        Map<Character, Integer> curMap = new HashMap<>();

        for (char c : pat.toCharArray()) {
            patMap.put(c, patMap.getOrDefault(c, 0) + 1);
        }

        while(j < txt.length()) {
            char cur = txt.charAt(j);
            curMap.put(cur, curMap.getOrDefault(cur, 0) + 1);
            if(j - i + 1 < k) {
                j++;
            } else if (j - i + 1== k) {
                boolean isAnagram = checkIfAnagram(curMap, patMap);
                if(isAnagram) {
                    count++;
                }
                char c = txt.charAt(i);
                if (curMap.containsKey(c)) {
                    curMap.put(c, curMap.get(c) - 1);
                }
                if (curMap.containsKey(c) && curMap.get(c).equals(0)) {
                    curMap.remove(c);
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
