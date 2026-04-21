# Heap Classes - Concept-wise Segregation

This file groups all classes under `heap/` by core revision concept.
Files span: root-level GFG problems, `code_story_with_MIK/medium/`, `practise/easy/`, `practise/medium/`.

---

## 1) Kth Largest / Kth Smallest Element
Use a min-heap of size K (for Kth largest) or max-heap (for Kth smallest). Classic heap-size trick.

**Root / GFG**
- `KthLargestElementArray.java`
- `KthSmallestElementArray.java`
- `KthLargest.java` *(Kth largest in a stream — design problem)*
- `ElementsSumBetweenk1k2smallest.java`

**code_story_with_MIK/medium**
- `Leetcode_215.java` — Kth Largest Element in an Array
- `Leetcode_703.java` — Kth Largest Element in a Stream

**practise/medium**
- `Leetcode_215.java` — Kth Largest Element in an Array
- `Leetcode_378.java` — Kth Smallest Element in a Sorted Matrix
- `Leetcode_786.java` — K-th Smallest Prime Fraction

---

## 2) Top K Frequent Elements / Sort by Frequency
Use a HashMap to count frequencies, then a heap of size K to extract top elements.

**Root / GFG**
- `TopKFrequentElements.java`
- `SortArrayByIncreasingFrequency.java`

**code_story_with_MIK/medium**
- `Leetcode_347.java` — Top K Frequent Elements
- `Leetcode_451.java` — Sort Characters By Frequency

**practise/medium**
- `Leetcode_347.java` — Top K Frequent Elements
- `Leetcode_451.java` — Sort Characters By Frequency
- `Leetcode_1338.java` — Reduce Array Size to The Half

---

## 3) K Closest / Nearest Points
Use a max-heap of size K to keep the K nearest candidates by distance or value.

**Root / GFG**
- `KClosestPointToOrigin.java`
- `FindKClosestElements.java`

**code_story_with_MIK/medium**
- `Leetcode_373.java` — Find K Pairs with Smallest Sums

**practise/medium**
- `Leetcode_973.java` — K Closest Points to Origin
- `Leetcode_1337.java` — The K Weakest Rows in a Matrix

---

## 4) Greedy Simulation with Heap (Operate on Max/Min Repeatedly)
Repeatedly pick the largest or smallest element, apply an operation, and push back.

**Root / GFG**
- `MinimumCostOfRopes.java` *(always merge the two smallest — min-heap greedy)*
- `MaximumSumCombination.java`

**code_story_with_MIK/medium**
- `Leetcode_1046.java` — Last Stone Weight
- `Leetcode_1962.java` — Remove Stones to Minimize the Total
- `Leetcode_2530.java` — Maximal Score After Applying K Operations
- `Leetcode_3066.java` — Minimum Operations to Exceed Threshold Value II

**practise/easy**
- `Leetcode_2335.java` — Minimum Amount of Time to Fill Cups
- `Leetcode_2558.java` — Take Gifts From the Richest Pile
- `Leetcode_3264.java` — Final Array State After K Multiplication Operations I

**practise/medium**
- `Leetcode_1753.java` — Maximum Score From Removing Stones
- `Leetcode_2593.java` — Find Score of an Array After Marking All Elements

**code_story_with_MIK/medium/learning_concepts**
- `Leetcoe_2593.java` — Find Score of an Array (concept walkthrough variant)

---

## 5) Two-Heap Pattern (Running Median / Balanced Partition)
Maintain a max-heap for the lower half and a min-heap for the upper half to answer median queries in O(log n).

**code_story_with_MIK/medium**
- `Leetcode_295.java` — Find Median from Data Stream

---

## 6) Nearly Sorted / External Sort via Heap
Use a fixed-size min-heap to sort an array where each element is at most K positions away from its sorted position.

**Root / GFG**
- `NearlySorted.java`

---

## 7) Heap with Custom Comparator / Priority Problems
Problems that require a custom Pair/comparator or a heap-based priority score that is non-trivial.

**Root / GFG**
- `RankTransformOfAnArray.java`
- `HandOfStraights.java`

**code_story_with_MIK/medium**
- `Leetcode_2464.java` — Total Cost to Hire K Workers

**practise/easy**
- `Leetcode_2974.java` — Minimum Number Game
- `Leetcode_2500.java` — Delete Greatest Value in Each Row

**practise/medium**
- `Leetcode_1792.java` — Maximum Average Pass Ratio *(gain-based custom comparator)*
- `Leetcode_2285.java` — Maximum Total Importance of Roads
- `Leetcode_3767.java`

---

## 8) Sliding Window + Heap
Heap used over a fixed window — combine sliding-window concept with heap maintenance.

**practise/easy**
- `Leetcode_3318.java` — Find X-Sum of All K-Long Subarrays I

**practise/medium**
- `Leetcode_2336.java` — Smallest Number in Infinite Set *(design + ordered structure)*

---

## 9) Heap + Hashing / Index Tracking
Problems where a heap is combined with a frequency map or index tracking.

**Root / GFG**
- `TaskScheduler.java` *(frequency count + greedy with max-heap)*

---

## Utility / Support Classes
- `Pair.java` *(root)* — shared utility pair class
- `practise/easy/Leetcode_3264Pair` and similar inner `Pair` classes — scoped helpers

---

## Notes
- **Min-heap of size K** is the canonical pattern for "Kth largest" — O(n log K) vs O(n log n) sort.
- **Two-heap pattern** (Concept 5) is a must-know for any dynamic median question.
- Concepts 4 and 9 overlap slightly: whenever you "repeatedly pick max and push back", confirm if a frequency count (TaskScheduler-style) or direct simulation (Last Stone Weight-style) applies.
- Revision order suggestion: 1 → 3 → 2 → 4 → 6 → 5 → 7 → 8 → 9.

