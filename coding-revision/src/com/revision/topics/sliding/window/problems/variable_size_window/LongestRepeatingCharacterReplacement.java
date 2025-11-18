package com.revision.topics.sliding.window.problems.variable_size_window;

// PL - https://leetcode.com/problems/longest-repeating-character-replacement/submissions/1832651137/
// VL - https://youtu.be/_eNhaDCr6P0
public class LongestRepeatingCharacterReplacement {

    /** The key optimization over the previous sliding window method is to avoid shrinking the window.
    Instead of always adjusting the window size based on the replacement condition, we keep expanding the window as
    long as the current window satisfies the condition. We don’t need to shrink the window manually because the
    maximum window size that satisfies the constraint can be tracked directly,
    as we are only asked for the maximum length, not the actual substring.

    hence, as we slide the window, we always try to increase the window size.
    We maintain the count of the most frequent character in the current window. If the difference between
    the window size and this count exceeds k, it means we need more than k replacements but instead of shrinking,
    we just continue checking and computing the maximum valid length encountered.

    This approach avoids recalculating the maximum frequency on every iteration, making it faster than the better approach.
            1. Initialize a frequency array or hashmap to store character frequencies in the current window.
            2. Track the count of the most frequent character seen so far in the window.
            3. For every character, expand the window by moving the right pointer.
            4. If (current window length - max frequency) exceeds k, it means more than k replacements are needed,
               so we move the left pointer forward.
            5. Throughout the loop, update the max window length that satisfies the constraint.
*/


    //TODO - Revisit
    public static int characterReplacement(String s, int k) {
        // Frequency array for A-Z
        int[] freq = new int[26];

        // Left and right pointers of sliding window
        int left = 0, right = 0;

        // Tracks the count of the most frequent character in current window
        int maxCount = 0;

        // Stores the maximum length of valid window
        int maxLength = 0;

        // Iterate through the string with right pointer
        while (right < s.length()) {

            // Increment the frequency of current character
            freq[s.charAt(right) - 'A']++;

            // Update maxCount with the max frequency seen so far
            maxCount = Math.max(maxCount, freq[s.charAt(right) - 'A']);

            // If the current window needs more than k replacements, move left
            while ((right - left + 1) - maxCount > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            // Update the maximum window length
            maxLength = Math.max(maxLength, right - left + 1);

            // Move right pointer forward
            right++;
        }

        // Return the maximum valid window length
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(characterReplacement("ABAB", 2));
        System.out.println(characterReplacement("AABABBA", 1));
    }
}
