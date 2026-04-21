# Sliding Window — Concept-wise Segregation

> Files span: `fixed_size_window/`, `variable_size_window/`, `revision/fixed_size_window/`, `revision/variable_size_window/`
> All problem links extracted directly from class files

---

## How to Identify a Sliding Window Problem
1. Array or String problem talking about a **subarray / substring**.
2. Window size **K is given** → **Fixed Window**.
3. A **condition is given** and window size is **asked** → **Variable Window**.

---

---

# FIXED SIZE WINDOW
> Window size = K (always given). Slide one step at a time: add `arr[right]`, remove `arr[right - K]`.

---

## F-1 · Sum / Aggregate in a Fixed Window
> Maintain a running sum. On each slide: `sum += arr[right] - arr[right - K]`

- [ ] `fixed_size_window/MaxSumSubArrayOfSizeK.java` - Maximum sum subarray of size K - [Problem](https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1)
- [ ] `revision/fixed_size_window/MaxSumSubArrayOfSizeK.java` - *(revision)* - [Problem](https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1)

---

## F-2 · Max / Min Element in Every Window
> Use a **Monotonic Deque** to get max/min per window in O(1) → overall O(n).

- [ ] `fixed_size_window/KSizedSubArrayMaximum.java` - Maximum element in every window of size K - [Problem](https://www.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k3101/1)
- [ ] `revision/fixed_size_window/KSizedSubarrayMaximum.java` - *(revision)* - [Problem](https://www.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k3101/1)

---

## F-3 · Frequency / Anagram Count in a Fixed Window
> Maintain a character-frequency map. Slide and check map equality (or matched-char count) per window.

- [ ] `fixed_size_window/CountOccurenceOfAnagram.java` - Count anagram occurrences of a pattern in a string - [Problem](https://www.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1)
- [ ] `fixed_size_window/FirstNegativeInEveryWindowOfSizeK.java` - First negative integer in every window of size K - [Problem](https://www.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1)
- [ ] `revision/fixed_size_window/CountOccurenceOfAnagram.java` - *(revision)* - [Problem](https://www.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1)
- [ ] `revision/fixed_size_window/FirstNegativeInEveryWindowOfSizeK.java` - *(revision)* - [Problem](https://www.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1)

---

## F-4 · Fixed Window on Both Ends (Cards / Circular Inversion)
> Picking K elements from both ends = removing a **contiguous middle window of size (n-K)**. Invert the problem to a fixed window on the middle.

- [ ] `variable_size_window/MaximumPointObtainedFromCard.java` - Max points from K cards picked from either end - [Video](https://youtu.be/pBWCOCS636U)

---

---

# VARIABLE SIZE WINDOW
> Window size is NOT fixed. Expand `right` greedily; shrink `left` when window violates the condition.
> Goal: find **longest**, **shortest**, or **count** of valid windows.

---

## V-1 · Longest Subarray with Sum = K  *(Non-negative Integer Arrays)*
> Expand right, shrink left when `sum > K`. For arrays with negatives → use Prefix Sum + HashMap instead.

- [ ] `variable_size_window/LongestSubarrayWithSumK.java` - Longest subarray with sum exactly K - [Video](https://www.youtube.com/watch?v=cyu_nuW5utA&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=7)
- [ ] `revision/variable_size_window/LongestSubarrayWithSumK.java` - *(revision)* - [Video](https://www.youtube.com/watch?v=cyu_nuW5utA&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=7)

---

## V-2 · Longest Substring with At Most / Exactly K Distinct Characters
> Shrink condition: `map.size() > K`. Remove char from map when its count hits 0.

- [ ] `variable_size_window/LongestSubstringWithKDistinctCharacter.java` - Longest substring with **at most** K distinct chars - [Problem](https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1)
- [ ] `variable_size_window/LongestSubstringWithKUniques.java` - Longest substring with **exactly** K unique chars - [Problem](https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1)
- [ ] `variable_size_window/FruitsIntoBasket.java` - At most **2** distinct chars - Leetcode 904 - [Problem](https://leetcode.com/problems/fruit-into-baskets/submissions/1829064259/)
- [ ] `revision/variable_size_window/LongestSubstringWithKUniques.java` - *(revision)* - [Problem](https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1)
- [ ] `revision/variable_size_window/FruitsIntoBasket.java` - *(revision)* - [Problem](https://leetcode.com/problems/fruit-into-baskets/submissions/1829064259/)

---

## V-3 · Longest Substring Without Repeating Characters  *(Zero duplicates)*
> Special case of V-2: shrink left the moment any character appears more than once.

- [ ] `variable_size_window/LongestSubstringWithoutRepeatingCharacters.java` - Leetcode 3 - [Problem](https://leetcode.com/problems/longest-substring-without-repeating-characters/description/)
- [ ] `variable_size_window/Leetcode_3.java` - Leetcode 3 (alternate attempt) - [Video](https://www.youtube.com/watch?v=Lav6St0W_pQ&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=10)
- [ ] `revision/variable_size_window/LongestSubstringWithoutRepeatingCharacters.java` - *(revision)* - [Problem](https://leetcode.com/problems/longest-substring-without-repeating-characters/description/)

---

## V-4 · Longest Valid Window After At Most K Replacements / Flips
> Window is valid while `(windowSize - maxFreqChar) ≤ K`. Never shrink below historical best size.

- [ ] `variable_size_window/LongestRepeatingCharacterReplacement.java` - Leetcode 424 - at most K character replacements - [Problem](https://leetcode.com/problems/longest-repeating-character-replacement/submissions/1832651137/)
- [ ] `variable_size_window/Leetcode_1004.java` - Leetcode 1004 - Max Consecutive Ones III - No link available

---

## V-5 · Count Subarrays with Exactly K  *(Binary / Integer Arrays)*
> "Exactly K" is hard directly. Use the trick:
> **`count(exactly K) = count(atMost K) − count(atMost K−1)`**

- [ ] `variable_size_window/BinarySubarrayWithSumm.java` - Leetcode 930 - Binary subarrays with sum = goal - [Problem](https://leetcode.com/problems/binary-subarrays-with-sum/description/)
- [ ] `variable_size_window/CountNumberOfNiceSubArrays.java` - Leetcode 1248 - Subarrays with exactly K odd numbers - [Video](https://youtu.be/j_QOv9OT9Og)
- [ ] `variable_size_window/SubArraysWithKDifferentIntegers.java` - Leetcode 992 - Subarrays with K different integers - [Problem](https://leetcode.com/problems/subarrays-with-k-different-integers/)

---

## V-6 · Minimum Window / Smallest Subarray Satisfying a Condition
> Expand right until condition is met → **aggressively shrink left** to minimise window → record answer → expand again.

- [ ] `variable_size_window/MinimumWindowSubstring.java` - Leetcode 76 - Minimum window substring containing all chars of pattern - [Problem](https://leetcode.com/problems/minimum-window-substring/)
- [ ] `variable_size_window/LeetCode_1358.java` - Leetcode 1358 - Number of substrings containing all three characters - [Video](https://youtu.be/xtqN4qlgr8s)

---

---

## Pattern Decision Tree

```
Is window size K given?
 ├─ YES → FIXED WINDOW
 │         ├─ Sum / Aggregate?              → F-1
 │         ├─ Max / Min per window?         → F-2
 │         ├─ Frequency / Anagram count?    → F-3
 │         └─ Pick K from both ends?        → F-4 (invert to middle window)
 │
 └─ NO  → VARIABLE WINDOW
           ├─ Longest, sum condition?                    → V-1
           ├─ Longest, at most K distinct chars?         → V-2
           ├─ Longest, no repeating chars?               → V-3
           ├─ Longest, after K replacements / flips?     → V-4
           ├─ Count subarrays with exactly K?            → V-5  (atMost trick)
           └─ Minimum / shortest satisfying window?      → V-6
```

---

## Key Concept Notes
- **V-2 ⊇ V-3**: no-repeat is just "at most 1 of each" — same template, stricter condition.
- **V-4 shrink trick**: never shrink below historical max window size (monotonically growing window).
- **V-5 atMost trick**: most powerful template — `BinarySubarrayWithSum`, `NiceSubArrays`, and `KDifferentIntegers` all reduce to the same `atMost` helper.
- **V-6** is the hardest — the shrink loop uses a validity check (`formed == required`), not a simple threshold comparison.
- Every `revision/` file is a clean re-solve — always revise the **main + revision pair together**.
- **Problem links** are extracted directly from class files — click them to access resources instantly without switching files.
- Topic checkbox is a parent tracker: if you mark a topic as checked, mark all problems under that topic as checked too.
- **Revision order suggestion**: F-1 → F-2 → F-3 → F-4 → V-1 → V-2 → V-3 → V-4 → V-5 → V-6.

