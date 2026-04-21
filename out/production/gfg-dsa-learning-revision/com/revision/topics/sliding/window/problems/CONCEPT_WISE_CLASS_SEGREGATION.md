# Sliding Window — Concept-wise Segregation

> Files span: `fixed_size_window/`, `variable_size_window/`, `revision/fixed_size_window/`, `revision/variable_size_window/`

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

| File | Problem |
|------|---------|
| `fixed_size_window/MaxSumSubArrayOfSizeK.java` | Maximum sum subarray of size K |
| `revision/fixed_size_window/MaxSumSubArrayOfSizeK.java` | *(revision)* |

---

## F-2 · Max / Min Element in Every Window
> Use a **Monotonic Deque** to get max/min per window in O(1) → overall O(n).

| File | Problem |
|------|---------|
| `fixed_size_window/KSizedSubArrayMaximum.java` | Maximum element in every window of size K |
| `revision/fixed_size_window/KSizedSubarrayMaximum.java` | *(revision)* |

---

## F-3 · Frequency / Anagram Count in a Fixed Window
> Maintain a character-frequency map. Slide and check map equality (or matched-char count) per window.

| File | Problem |
|------|---------|
| `fixed_size_window/CountOccurenceOfAnagram.java` | Count anagram occurrences of a pattern in a string (window size = pattern length) |
| `fixed_size_window/FirstNegativeInEveryWindowOfSizeK.java` | First negative integer in every window of size K |
| `revision/fixed_size_window/CountOccurenceOfAnagram.java` | *(revision)* |
| `revision/fixed_size_window/FirstNegativeInEveryWindowOfSizeK.java` | *(revision)* |

---

## F-4 · Fixed Window on Both Ends (Cards / Circular Inversion)
> Picking K elements from both ends = removing a **contiguous middle window of size (n-K)**. Invert the problem to a fixed window on the middle.

| File | Problem |
|------|---------|
| `variable_size_window/MaximumPointObtainedFromCard.java` | Max points from K cards picked from either end — Leetcode 1423 |

---

---

# VARIABLE SIZE WINDOW
> Window size is NOT fixed. Expand `right` greedily; shrink `left` when window violates the condition.
> Goal: find **longest**, **shortest**, or **count** of valid windows.

---

## V-1 · Longest Subarray with Sum = K  *(Non-negative Integer Arrays)*
> Expand right, shrink left when `sum > K`. For arrays with negatives → use Prefix Sum + HashMap instead.

| File | Problem |
|------|---------|
| `variable_size_window/LongestSubarrayWithSumK.java` | Longest subarray with sum exactly K |
| `revision/variable_size_window/LongestSubarrayWithSumK.java` | *(revision)* |

---

## V-2 · Longest Substring with At Most / Exactly K Distinct Characters
> Shrink condition: `map.size() > K`. Remove char from map when its count hits 0.

| File | Problem |
|------|---------|
| `variable_size_window/LongestSubstringWithKDistinctCharacter.java` | Longest substring with **at most** K distinct chars — Leetcode style |
| `variable_size_window/LongestSubstringWithKUniques.java` | Longest substring with **exactly** K unique chars — GFG style |
| `variable_size_window/FruitsIntoBasket.java` | At most **2** distinct chars — Leetcode 904 (same template, K = 2) |
| `revision/variable_size_window/LongestSubstringWithKUniques.java` | *(revision)* |
| `revision/variable_size_window/FruitsIntoBasket.java` | *(revision)* |

---

## V-3 · Longest Substring Without Repeating Characters  *(Zero duplicates)*
> Special case of V-2: shrink left the moment any character appears more than once.

| File | Problem |
|------|---------|
| `variable_size_window/LongestSubstringWithoutRepeatingCharacters.java` | Leetcode 3 |
| `variable_size_window/Leetcode_3.java` | Leetcode 3 (alternate attempt) |
| `revision/variable_size_window/LongestSubstringWithoutRepeatingCharacters.java` | *(revision)* |

---

## V-4 · Longest Valid Window After At Most K Replacements / Flips
> Window is valid while `(windowSize - maxFreqChar) ≤ K`. Never shrink below historical best size.

| File | Problem |
|------|---------|
| `variable_size_window/LongestRepeatingCharacterReplacement.java` | Leetcode 424 — at most K character replacements in a string |
| `variable_size_window/Leetcode_1004.java` | Leetcode 1004 — Max Consecutive Ones III (at most K zero-flips; same pattern on binary array) |

---

## V-5 · Count Subarrays with Exactly K  *(Binary / Integer Arrays)*
> "Exactly K" is hard directly. Use the trick:
> **`count(exactly K) = count(atMost K) − count(atMost K−1)`**

| File | Problem |
|------|---------|
| `variable_size_window/BinarySubarrayWithSumm.java` | Leetcode 930 — Binary subarrays with sum = goal |
| `variable_size_window/CountNumberOfNiceSubArrays.java` | Leetcode 1248 — Subarrays with exactly K odd numbers |
| `variable_size_window/SubArraysWithKDifferentIntegers.java` | Leetcode 992 — Subarrays with K different integers |

---

## V-6 · Minimum Window / Smallest Subarray Satisfying a Condition
> Expand right until condition is met → **aggressively shrink left** to minimise window → record answer → expand again.

| File | Problem |
|------|---------|
| `variable_size_window/MinimumWindowSubstring.java` | Leetcode 76 — Minimum window substring containing all chars of pattern |
| `variable_size_window/LeetCode_1358.java` | Leetcode 1358 — Number of substrings containing all three characters (a, b, c) |

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

