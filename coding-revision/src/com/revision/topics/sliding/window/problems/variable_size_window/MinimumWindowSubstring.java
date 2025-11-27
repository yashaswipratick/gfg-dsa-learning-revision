package com.revision.topics.sliding.window.problems.variable_size_window;

import java.util.HashMap;
import java.util.Map;

// PL - https://leetcode.com/problems/minimum-window-substring/
//VL - https://www.youtube.com/watch?v=WJaij9ffOIY
public class MinimumWindowSubstring {

    /*
    -------------------------------------------------------------
    APPROACH — Minimum Window Substring (Sliding Window + HashMap)
    -------------------------------------------------------------

    GOAL:
    -----
    Find the smallest substring in 's' that contains ALL characters of 't'
    including duplicates.

    KEY IDEA:
    ---------
    Use Sliding Window Technique with a HashMap that tracks required characters.

    -------------------------------------------------------------
    STEP-BY-STEP APPROACH
    -------------------------------------------------------------

    1. Build a frequency map for string 't'
        - This map tells how many of each character we STILL need.

           Example:
           t = "ABC"
           map = { A:1, B:1, C:1 }

    2. Maintain two pointers:
        - 'i' = left boundary of window
        - 'j' = right boundary of window

    3. Maintain a variable 'required'
        - It tells how many total characters we still need
        - Initially required = t.length()

    4. Expand the window using 'j'
        - Add s[j] into the window
        - If this character was still needed (map[c] > 0)
              -> decrease 'required'
        - Always decrease map[c] (because this char is entering the window)

    5. When required becomes 0
        - It means current window [i..j] contains ALL characters of 't'
        - Now try to SHRINK the window from the left using 'i'
        - Update minimum window if this window is smaller

        - While shrinking:
            - Increase map[s[i]]
              (because we are removing it from window)
            - If map[s[i]] becomes > 0
                 -> It means we are now missing a required character
                 -> Increase 'required' by 1
                 -> STOP shrinking

        - Move i forward

    6. Continue expanding 'j' until we finish the string.

    7. Return the smallest window found.

    -------------------------------------------------------------
    WHY THIS WORKS?
    -------------------------------------------------------------
    - Expanding 'j' helps include all required characters.
    - Shrinking 'i' ensures we find the SMALLEST valid window.
    - HashMap tracks exactly what characters we need and how many.
    - 'required' ensures we know when the window is valid.

    -------------------------------------------------------------
    TIME COMPLEXITY:
    -------------------------------------------------------------
    O(n) — both pointers (i and j) move only forward.

    -------------------------------------------------------------
    SPACE COMPLEXITY:
    -------------------------------------------------------------
    O(1) — max map size = 128 or 256 chars.

    -------------------------------------------------------------
*/

    // TODO - Revise
    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        Map<Character, Integer> map = new HashMap<>();

        for (char ch : t.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);

        int required = t.length();
        int i = 0, j = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (j < s.length()) {
            char c = s.charAt(j);

            if (map.containsKey(c)) {
                if (map.get(c) > 0) required--;
                map.put(c, map.get(c) - 1);
            }

            while (required == 0) {
                if (j - i + 1 < minLen) {
                    minLen = j - i + 1;
                    start = i;
                }

                char left = s.charAt(i);
                if (map.containsKey(left)) {
                    map.put(left, map.get(left) + 1);
                    if (map.get(left) > 0) required++;
                }
                i++;
            }

            j++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("a", "a"));
        System.out.println(minWindow("a", "aa"));
    }
}
