# Hashing/GFG Classes - Concept-wise Segregation

This file groups all hashing classes under `hashing/gfg/` by core revision concept.

---

## 1) Basics: Frequency, Count, and Lookup (Easy)
Foundational use of HashMap/HashSet for counting and existence checks.

- [ ] `easy/FrequencyOfElement.java`
- [ ] `easy/CountDistinctElement.java`
- [ ] `easy/practise/CountNonRepeatedElements.java`
- [ ] `easy/practise/FirstRepeatingElement.java`
- [ ] `easy/practise/WinnersElection.java`

---

## 2) Set Operations: Union, Intersection, and Pair Problems (Easy)
Using HashSet for fast lookups on two collections or pair-target problems.

- [ ] `easy/IntersectionOfTwoArrays.java`
- [ ] `easy/UnionWithDuplicates.java`
- [ ] `easy/TwoSum.java`
- [ ] `easy/practise/PairSum.java`
- [ ] `easy/practise/CheckEqualArray.java`

---

## 3) Prefix Sum + Hashing (Medium)
Subarray problems solved using prefix sums stored in a HashMap to find ranges in O(n).

- [ ] `medium/prefixSumAndHashing/SubArrayWithZeroSum.java`
- [ ] `medium/prefixSumAndHashing/SubArrayWithGivenSum.java`
- [ ] `medium/prefixSumAndHashing/SubArrayWithEqualZeroAndOne.java`
- [ ] `medium/prefixSumAndHashing/LongestSubArraysWithEqualZeroAndOne.java`
- [ ] `medium/prefixSumAndHashing/LongestCommonSpanInTwoBinaryArrays.java`
- [ ] `medium/prefixSumAndHashing/practice/ZeroSumSubArray.java`
- [ ] `medium/prefixSumAndHashing/revision/SubArrayWithZeroSumRevision.java`
- [ ] `medium/prefixSumAndHashing/revision/SubArrayWithGivenSumRevision.java`
- [ ] `medium/prefixSumAndHashing/revision/LongestSubArraysWithEqualZeroAndOneRevision.java`
- [ ] `medium/prefixSumAndHashing/revision/LongestCommonSpanInTwoBinaryArraysRevision.java`

---

## 4) Sliding Window + Hashing (Medium)
Fixed/variable window over a stream; use a HashMap to track window state.

- [ ] `medium/slidinWindowWithHashing/CountDistinctElementInEveryWindow.java`
- [ ] `medium/slidinWindowWithHashing/revision/CountDistinctElementInEveryWindowRevision.java`

---

## 5) N/K Majority (Frequency Threshold) + Moore's Voting Algorithm (Medium)
Find elements appearing more than ⌊n/k⌋ times — pure HashMap approach vs optimised Boyer-Moore.

- [ ] `medium/nbykOccurence/MoreThanNByKOccurrences.java`
- [ ] `medium/nbykOccurence/mooreVotingAlgorithm/MoreThanNByKOccurrencesMVAlgo.java`
- [ ] `medium/nbykOccurence/revision/MoreThanNByKOccurrencesRevision.java`

---

## 6) Sorting with Hashing (Medium)
Use a frequency map / index map as the basis for a custom sort order.

- [ ] `medium/practice/SortAccordingToArray.java`
- [ ] `medium/practice/SortElementsByDecreasingOrder.java`

---

## 7) Consecutive Subsequence / Sequence Detection (Medium)
Use a HashSet to find the longest run of consecutive numbers in O(n).

- [ ] `medium/subsequence/LongestConsecutiveSubsequence.java`
- [ ] `medium/subsequence/revision/LongestConsecutiveSubsequenceRevision.java`

---

## Notes
- Revision files (`revision/`) shadow the main problem file — always revise them as a pair.
- Concepts 3 (Prefix Sum + Hashing) and 4 (Sliding Window + Hashing) are often confused — the key distinction:
  - **Prefix Sum**: cumulative sum stored in map; you look *back* to find a target difference.
  - **Sliding Window**: a moving window; you track the *current window's* state in a map.
- Moore's Voting Algorithm (Concept 5) is the space-O(1) alternative to the HashMap frequency approach — know both.
- **Problem links** are extracted directly from class files — click them to access resources instantly without switching files.
- Topic checkbox is a parent tracker: if you mark a topic as checked, mark all problems under that topic as checked too.
- **Revision order suggestion**: 1 → 2 → 3 → 4 → 5 → 6 → 7.

