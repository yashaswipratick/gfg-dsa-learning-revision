package com.revision.topics.sliding.window.problems.variable_size_window;

import java.util.HashMap;
import java.util.Map;

// VL - https://youtu.be/xtqN4qlgr8s
// PL - https://leetcode.com/problems/number-of-substrings-containing-all-three-characters
public class LeetCode_1358 {

    /**
     * 1. Initialize a HashMap<Character, Integer> to store frequencies of 'a', 'b', 'c'.
     *
     * 2. Maintain two pointers:
     *    - left = start of window
     *    - right = expanding pointer
     *
     * 3. Expand the window using 'right':
     *    - Add s.charAt(right) to HashMap and update frequency.
     *
     * 4. Whenever the window contains all characters:
     *    Condition:
     *        map.get('a') > 0 && map.get('b') > 0 && map.get('c') > 0
     *
     *    - Count how many substrings end at or after 'right':
     *        res += (s.length() - right)
     *
     *    - Then shrink the window from the left:
     *        reduce frequency of s.charAt(left)
     *        move left++
     *
     *    Continue shrinking until one of the chars becomes 0.
     *
     * 5. Repeat this until right reaches the end.
     *
     * 6. Return result.
     *
     * Why Sliding Window Works:
     * -------------------------
     * The window always maintains the smallest valid substring starting at 'left'.
     * Once valid, every extension to the right produces more valid substrings.
     * This ensures we count all valid substrings in O(n) time.
     *
     */
    public static int numberOfSubstrings(String s) {
        // HashMap to count occurrences of 'a', 'b', 'c'
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 0);
        map.put('b', 0);
        map.put('c', 0);

        int left = 0;
        int res = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            // increment frequency of current character
            map.put(ch, map.get(ch) + 1);

            // shrink window while all three chars have frequency > 0
            while (map.get('a') > 0 && map.get('b') > 0 && map.get('c') > 0) {
                res += (s.length() - right);

                // decrease count of outgoing left char
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                left++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(numberOfSubstrings("abcabc"));
        System.out.println(numberOfSubstrings("aaacb"));
        System.out.println(numberOfSubstrings("abc"));
    }
}
