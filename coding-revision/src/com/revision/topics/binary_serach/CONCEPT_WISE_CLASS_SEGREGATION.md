# Binary Search — Concept-wise Segregation

This file groups all binary search classes by core revision concept with direct problem links.

---

## How to Identify a Binary Search Problem
1. **Array or value range problem** — searching for something.
2. **Monotonic property** — once a condition becomes true/false, it stays that way.
3. **O(log n) time complexity** expected or achievable via binary search.
4. **Search space can be an array, a numeric range, or even a condition space** (predicate-based BS).

---

---

# [ ] BS-1 · Classic Binary Search on Sorted Array
> Direct search for a target value or insert position in a sorted array.

- [ ] `easy/Leetcode_704.java` - Binary Search - [Problem](https://leetcode.com/problems/binary-search/description/)
- [ ] `easy/Leetcode_35.java` - Search Insert Position - [Problem](https://leetcode.com/problems/search-insert-position/description/)
- [ ] `easy/Leetcode_744.java` - Find Smallest Letter Greater Than Target - [Problem](https://leetcode.com/problems/find-smallest-letter-greater-than-target/)
- [ ] `easy/Leetcode_2089.java` - Find Target Indices After Sorting Array - [Problem](https://leetcode.com/problems/find-target-indices-after-sorting-array/description/)

---

# [ ] BS-2 · Find First / Last Occurrence (Boundary Problems)
> Find the first position where a condition becomes true, or the last position where it's still true.

- [ ] `medium/Leetcode_34.java` - Find First and Last Position of Element in Sorted Array - [Problem](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/)

---

# [ ] BS-3 · Peak Element & Boundary Crossing
> Find a peak (or valley) — a point where the element is greater/less than its neighbors.

- [ ] `medium/peak_element/Leetcode_162.java` - Find Peak Element - [Problem](https://leetcode.com/problems/find-peak-element/description)
- [ ] `medium/peak_element/Leeetcode_852.java` - Peak Index in a Mountain Array - [Problem](https://leetcode.com/problems/peak-index-in-a-mountain-array/description)
- [ ] `medium/peak_element/Leetcode_852.java` - Peak Index in a Mountain Array (alternate) - [Problem](https://leetcode.com/problems/peak-index-in-a-mountain-array)
- [ ] `medium/peak_element/Leetcode_1300.java` - Sum of Mutated Array Closest to Target - [Problem](https://leetcode.com/problems/sum-of-mutated-array-closest-to-target/description/)

---

# [ ] BS-4 · Rotated Sorted Array
> Array is sorted but rotated at some pivot. Find the pivot, search in a rotated array, or handle duplicates.

- [ ] `medium/rotated_sorted_array/Leetcode_33.java` - Search in Rotated Sorted Array - [Problem](https://leetcode.com/problems/search-in-rotated-sorted-array/)
- [ ] `medium/rotated_sorted_array/Leetcode_81.java` - Search in Rotated Sorted Array II (with duplicates) - [Problem](https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description)
- [ ] `medium/rotated_sorted_array/Leetcode_153.java` - Find Minimum in Rotated Sorted Array - [Problem](https://leetcode.com/problems/search-a-2d-matrix/description)
- [ ] `medium/rotated_sorted_array/revision_multiple_times/Leetcode_33.java` - Search in Rotated Sorted Array (revision) - [Problem](https://leetcode.com/problems/search-in-rotated-sorted-array/)
- [ ] `medium/rotated_sorted_array/revision_multiple_times/Leetcode_81.java` - Search in Rotated Sorted Array II (revision) - [Problem](https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description)
- [ ] `medium/rotated_sorted_array/revision_multiple_times/Leetcode_153.java` - Find Minimum in Rotated Sorted Array (revision) - [Problem](https://leetcode.com/problems/search-a-2d-matrix/description)

---

# [ ] BS-5 · 2D Matrix Search
> Search in a 2D matrix that is sorted (row-wise / column-wise or both).

- [ ] `medium/matrix/Leetcode_74.java` - Search a 2D Matrix (sorted row-wise and column-wise) - [Problem](https://leetcode.com/problems/search-a-2d-matrix/description)
- [ ] `medium/matrix/Leetcode_240.java` - Search a 2D Matrix II (integers > prev row and left) - [Problem](https://leetcode.com/problems/search-a-2d-matrix-ii/description/)

---

# [ ] BS-6 · Single Element (XOR / Parity-based)
> Find the single element or odd-occurrence element in a sorted array using parity observation.

- [ ] `medium/revision_multiple_time/Leetcode_540.java` - Single Element in a Sorted Array - [Problem](https://leetcode.com/problems/single-element-in-a-sorted-array/description/)

---

# [ ] BS-7 · Duplicate Element (Hare-Tortoise / Floyd Cycle)
> Detect or find duplicate elements in an array (often with implicit linked-list interpretation).

- [ ] `medium/hare_tortoise/Leetcode_287.java` - Find the Duplicate Number - No link available

---

# [ ] BS-8 · Predicate-Based Binary Search (Optimize a Condition)
> Binary search on the answer space — find the minimum value where a condition is satisfied, or maximum before it fails.

- [ ] `medium/koko_eating_banana_variation/Leetcode_875.java` - Koko Eating Bananas - [Problem](https://leetcode.com/problems/koko-eating-bananas/description)
- [ ] `medium/koko_eating_banana_variation/Leetcode_2187.java` - Minimum Time to Complete Trips - [Problem](https://leetcode.com/problems/minimum-time-to-complete-trips/description/)
- [ ] `medium/koko_eating_banana_variation/Leetcode_1283.java` - Find the Smallest Divisor Given a Threshold - [Problem](https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/description)

---

# [ ] BS-9 · Interval Problems (Predicate-Based)
> Find relationships between intervals (e.g., smallest interval containing a point, right interval for a start point).

- [ ] `medium/interval/Leetcode_436.java` - Find Right Interval - [Problem](https://leetcode.com/problems/find-right-interval/description/)

---

# [ ] BS-10 · Interactive Binary Search
> Binary search guided by query responses (e.g., "is your guess higher/lower?").

- [ ] `easy/interactive/Leetcode_278.java` - First Bad Version - [Problem](https://leetcode.com/problems/first-bad-version/)
- [ ] `easy/interactive/Leetcode_374.java` - Guess Number Higher or Lower - [Problem](https://leetcode.com/problems/guess-number-higher-or-lower/)

---

# [ ] BS-11 · Design Problems with Binary Search
> Data structure design with binary search as a core operation (e.g., time-based lookups).

- [ ] `medium/design_based_problem/Leetcode_981.java` - Time Based Key-Value Store - [Problem](https://leetcode.com/problems/time-based-key-value-store/description/)
- [ ] `medium/design_based_problem/Leetcode_528.java` - Random Pick with Weight - [Problem](https://leetcode.com/problems/random-pick-with-weight/description)

---

# [ ] BS-12 · Non-trivial Array Queries (Approximation & Threshold)
> Find missing numbers, closest values, or apply binary search on computed properties.

- [ ] `easy/Leetcode_268.java` - Missing Number - [Problem](https://leetcode.com/problems/missing-number/)
- [ ] `easy/Leetcode_69.java` - Sqrt(x) - No link available
- [ ] `easy/Leetcode_2529.java` - Distinct Prime Factors - No link available
- [ ] `medium/Leetcode_1482.java` - Minimum Number of Days to Make m Bouquets - [Problem](https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/?envType=problem-list-v2&envId=rktnezq3)
- [ ] `medium/Leetcode_475.java` - Heaters - [Problem](https://leetcode.com/problems/heaters/description)
- [ ] `medium/Leetcode_274.java` - H-Index - [Video](https://www.youtube.com/watch?v=fVAR6SiATgI)

---

---

## Pattern Decision Tree

```
Binary Search Problem?
 │
 ├─ Search for a target in a sorted array?
 │   ├─ Simple array?               → BS-1  (Classic BS)
 │   ├─ First/Last occurrence?      → BS-2  (Boundary)
 │   └─ Rotated array?              → BS-4  (Rotated)
 │
 ├─ Find an extreme (peak / valley)?
 │   └─ Peak / Mountain?            → BS-3  (Peak Element)
 │
 ├─ 2D matrix search?               → BS-5  (2D Matrix)
 │
 ├─ Odd occurrence / duplicate?
 │   ├─ Single element?             → BS-6  (Single Element)
 │   └─ Find duplicate?             → BS-7  (Hare-Tortoise)
 │
 ├─ Binary search on answer space?
 │   ├─ Optimize consumption/cost?  → BS-8  (Predicate-Based, e.g., Koko)
 │   ├─ Find best interval?         → BS-9  (Interval Problems)
 │   └─ Missing / threshold query?  → BS-12 (Non-trivial Queries)
 │
 ├─ Interactive query-based?        → BS-10 (Interactive BS)
 │
 └─ Design with BS lookup?          → BS-11 (Design Problems)
```

---

## Key Concept Notes
- **BS-1, 2, 4, 5**: Direct array searches — identify the monotonic property and apply standard BS template.
- **BS-3**: Peak / valley searches exploit **slope changes** — no need for full sorted array.
- **BS-4**: Rotated arrays require checking which half is sorted, then eliminating the unsorted half.
- **BS-6**: Single element uses **parity observation** — mid is at even or odd index?
- **BS-8, 9, 12**: The hardest category — binary search on the **answer space**, not on array indices. Write a predicate checker, then BS to find the optimal answer.
- **Revision note**: Files in `revision_multiple_times/` are clean re-solves — always revise main + revision together.
- **Problem links** are extracted directly from class files — click them to access resources instantly without switching files.
- Topic checkbox is a parent tracker: if you mark a topic as checked, mark all problems under that topic as checked too.
- **Revision order suggestion**: BS-1 → BS-2 → BS-4 → BS-3 → BS-5 → BS-6 → BS-10 → BS-11 → BS-8 → BS-9 → BS-12 → BS-7.

