# Heap Classes - Concept-wise Segregation

This file groups all classes under `heap/` by core revision concept with direct problem links.
Files span: root-level GFG problems, `code_story_with_MIK/medium/`, `practise/easy/`, `practise/medium/`.

---

## [ ] 1) Kth Largest / Kth Smallest Element
Use a min-heap of size K (for Kth largest) or max-heap (for Kth smallest). Classic heap-size trick.

**Root / GFG**
- [ ] `KthLargestElementArray.java` — [Problem](https://leetcode.com/problems/kth-largest-element-in-an-array)
- [ ] `KthSmallestElementArray.java` — [Problem](https://www.geeksforgeeks.org/problems/kth-smallest-element5635/1)
- [ ] `KthLargest.java` — [No link available]
- [ ] `ElementsSumBetweenk1k2smallest.java` — [Problem](https://www.geeksforgeeks.org/problems/sum-of-elements-between-k1th-and-k2th-smallest-elements3133/1)

**code_story_with_MIK/medium**
- [ ] `Leetcode_215.java` — Kth Largest Element in an Array — [Problem](https://leetcode.com/problems/kth-largest-element-in-an-array/description/) | [Video](https://www.youtube.com/watch?v=cI0shWNnB4o&list=PLpIkg8OmuX-IkxvvfOeZp-Ot0UWHMGAT-&index=12)
- [ ] `Leetcode_703.java` — Kth Largest Element in a Stream — [Problem](https://leetcode.com/problems/kth-largest-element-in-a-stream/description/)

**practise/medium**
- [ ] `Leetcode_215.java` — Kth Largest Element in an Array — [Video](https://www.youtube.com/watch?v=cI0shWNnB4o&list=PLpIkg8OmuX-IkxvvfOeZp-Ot0UWHMGAT-&index=12)
- [ ] `Leetcode_378.java` — Kth Smallest Element in a Sorted Matrix — [Problem](https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/)
- [ ] `Leetcode_786.java` — K-th Smallest Prime Fraction — [Problem](https://leetcode.com/problems/k-th-smallest-prime-fraction/)

---

## [ ] 2) Top K Frequent Elements / Sort by Frequency
Use a HashMap to count frequencies, then a heap of size K to extract top elements.

**Root / GFG**
- [ ] `TopKFrequentElements.java` — [Problem](https://leetcode.com/problems/top-k-frequent-elements/)
- [ ] `SortArrayByIncreasingFrequency.java` — [Problem](https://leetcode.com/problems/sort-array-by-increasing-frequency/)

**code_story_with_MIK/medium**
- [ ] `Leetcode_347.java` — Top K Frequent Elements — [Problem](https://leetcode.com/problems/top-k-frequent-elements/description/)
- [ ] `Leetcode_451.java` — Sort Characters By Frequency — [Problem](https://leetcode.com/problems/sort-characters-by-frequency/)

**practise/medium**
- [ ] `Leetcode_347.java` — Top K Frequent Elements — [Problem](https://leetcode.com/problems/top-k-frequent-elements/description/)
- [ ] `Leetcode_451.java` — Sort Characters By Frequency — [Problem](https://leetcode.com/problems/sort-characters-by-frequency/description/)
- [ ] `Leetcode_1338.java` — Reduce Array Size to The Half — [Problem](https://leetcode.com/problems/reduce-array-size-to-the-half/description/)

---

## [ ] 3) K Closest / Nearest Points
Use a max-heap of size K to keep the K nearest candidates by distance or value.

**Root / GFG**
- [ ] `KClosestPointToOrigin.java` — [Problem](https://leetcode.com/problems/k-closest-points-to-origin/)
- [ ] `FindKClosestElements.java` — [Problem](https://leetcode.com/problems/find-k-closest-elements/submissions/1840671611/)

**code_story_with_MIK/medium**
- [ ] `Leetcode_373.java` — Find K Pairs with Smallest Sums — [Video](https://www.youtube.com/watch?v=eptC4nUL_2A&list=PLpIkg8OmuX-IkxvvfOeZp-Ot0UWHMGAT-&index=10)

**practise/medium**
- [ ] `Leetcode_973.java` — K Closest Points to Origin — [Problem](https://leetcode.com/problems/k-closest-points-to-origin/description/)
- [ ] `Leetcode_1337.java` — The K Weakest Rows in a Matrix — [Problem](https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/description/)

---

## [ ] 4) Greedy Simulation with Heap (Operate on Max/Min Repeatedly)
Repeatedly pick the largest or smallest element, apply an operation, and push back.

**Root / GFG**
- [ ] `MinimumCostOfRopes.java` — [Problem](https://www.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1)
- [ ] `MaximumSumCombination.java` — [No link available]

**code_story_with_MIK/medium**
- [ ] `Leetcode_1046.java` — Last Stone Weight — [Problem](https://leetcode.com/problems/last-stone-weight/description/)
- [ ] `Leetcode_1962.java` — Remove Stones to Minimize the Total — [Problem](https://leetcode.com/problems/remove-stones-to-minimize-the-total/)
- [ ] `Leetcode_2530.java` — Maximal Score After Applying K Operations — [Problem](https://leetcode.com/problems/maximal-score-after-applying-k-operations/)
- [ ] `Leetcode_3066.java` — Minimum Operations to Exceed Threshold Value II — [Problem](https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-ii/description/)

**practise/easy**
- [ ] `Leetcode_2335.java` — Minimum Amount of Time to Fill Cups — [Problem](https://leetcode.com/problems/minimum-amount-of-time-to-fill-cups/)
- [ ] `Leetcode_2558.java` — Take Gifts From the Richest Pile — [Problem](https://leetcode.com/problems/take-gifts-from-the-richest-pile/description/)
- [ ] `Leetcode_3264.java` — Final Array State After K Multiplication Operations I — [Problem](https://leetcode.com/problems/final-array-state-after-k-multiplication-operations-i/description/)

**practise/medium**
- [ ] `Leetcode_1753.java` — Maximum Score From Removing Stones — [Problem](https://leetcode.com/problems/maximum-score-from-removing-stones/)
- [ ] `Leetcode_2593.java` — Find Score of an Array After Marking All Elements — [Problem](https://leetcode.com/problems/find-score-of-an-array-after-marking-all-elements/)

**code_story_with_MIK/medium/learning_concepts**
- [ ] `Leetcoe_2593.java` — Find Score of an Array — [Problem](https://leetcode.com/problems/find-score-of-an-array-after-marking-all-elements/description/)

---

## [ ] 5) Two-Heap Pattern (Running Median / Balanced Partition)
Maintain a max-heap for the lower half and a min-heap for the upper half to answer median queries in O(log n).

**code_story_with_MIK/medium**
- [ ] `Leetcode_295.java` — Find Median from Data Stream — [Problem](https://leetcode.com/problems/find-median-from-data-stream/submissions/1856505462/)

---

## [ ] 6) Nearly Sorted / External Sort via Heap
Use a fixed-size min-heap to sort an array where each element is at most K positions away from its sorted position.

**Root / GFG**
- [ ] `NearlySorted.java` — [Problem](https://www.geeksforgeeks.org/problems/nearly-sorted-1587115620/1)

---

## [ ] 7) Heap with Custom Comparator / Priority Problems
Problems that require a custom Pair/comparator or a heap-based priority score that is non-trivial.

**Root / GFG**
- [ ] `RankTransformOfAnArray.java` — [Problem](https://leetcode.com/problems/rank-transform-of-an-array/)
- [ ] `HandOfStraights.java` — [No link available]

**code_story_with_MIK/medium**
- [ ] `Leetcode_2464.java` — Total Cost to Hire K Workers — [Problem](https://leetcode.com/problems/total-cost-to-hire-k-workers/description/)

**practise/easy**
- [ ] `Leetcode_2974.java` — Minimum Number Game — [Problem](https://leetcode.com/problems/minimum-number-game/description/)
- [ ] `Leetcode_2500.java` — Delete Greatest Value in Each Row — [Problem](https://leetcode.com/problems/delete-greatest-value-in-each-row/)

**practise/medium**
- [ ] `Leetcode_1792.java` — Maximum Average Pass Ratio — [Problem](https://leetcode.com/problems/maximum-average-pass-ratio/)
- [ ] `Leetcode_2285.java` — Maximum Total Importance of Roads — [Problem](https://leetcode.com/problems/maximum-total-importance-of-roads/description/)
- [ ] `Leetcode_3767.java` — [No link available]

---

## [ ] 8) Sliding Window + Heap
Heap used over a fixed window — combine sliding-window concept with heap maintenance.

**practise/easy**
- [ ] `Leetcode_3318.java` — Find X-Sum of All K-Long Subarrays I — [Problem](https://leetcode.com/problems/find-x-sum-of-all-k-long-subarrays-i/)

**practise/medium**
- [ ] `Leetcode_2336.java` — Smallest Number in Infinite Set — [Problem](https://leetcode.com/problems/smallest-number-in-infinite-set/description/)

---

## [ ] 9) Heap + Hashing / Index Tracking
Problems where a heap is combined with a frequency map or index tracking.

**Root / GFG**
- [ ] `TaskScheduler.java` — [Problem](https://leetcode.com/problems/task-scheduler/)

---

## Utility / Support Classes
- `Pair.java` *(root)* — shared utility pair class
- `practise/easy/Leetcode_3264Pair` and similar inner `Pair` classes — scoped helpers

---

## Notes
- **Min-heap of size K** is the canonical pattern for "Kth largest" — O(n log K) vs O(n log n) sort.
- **Two-heap pattern** (Concept 5) is a must-know for any dynamic median question.
- Concepts 4 and 9 overlap slightly: whenever you "repeatedly pick max and push back", confirm if a frequency count (TaskScheduler-style) or direct simulation (Last Stone Weight-style) applies.
- **Problem links** are extracted directly from class files — click them to access resources instantly without switching files.
- Topic checkbox is a parent tracker: if you mark a topic as checked, mark all problems under that topic as checked too.
- **Revision order suggestion**: 1 → 3 → 2 → 4 → 6 → 5 → 7 → 8 → 9.
- **Problem links** are extracted directly from class files — click them to access resources instantly without switching files.

