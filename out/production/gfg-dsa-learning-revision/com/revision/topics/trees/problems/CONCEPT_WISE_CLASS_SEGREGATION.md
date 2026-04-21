# Trees — Concept-wise Segregation

> All files are under `trees/problems/`

---

## How to Identify the Tree Concept in a Problem
1. **Traversal order asked?** → DFS (Pre/In/Post) or BFS (Level order) or Variant (ZigZag, Boundary, Views)
2. **Single value computed across the whole tree?** → Tree-level Properties (height, diameter, path sum)
3. **Comparing two trees?** → Structural / Identity checks
4. **Finding a node or path?** → Path problems
5. **Relating nodes by position?** → View / Vertical / Coordinate problems
6. **Special tree type (Complete)?** → Count / Structural constraint

---

---

# T-1 · Basic DFS Traversals
> Core recursive / iterative traversals — the building blocks for almost every other tree concept.
> Order matters: Pre (Root→L→R), In (L→Root→R), Post (L→R→Root).

| File | Problem |
|------|---------|
| `PreOrderTraversal.java` | Leetcode 144 — Binary Tree Preorder Traversal |
| `InOrderTraversal.java` | Leetcode 94 — Binary Tree Inorder Traversal |
| `PostOrderTraversal.java` | Leetcode 145 — Binary Tree Postorder Traversal |

---

# T-2 · BFS / Level Order Traversals
> Process nodes level by level using a **Queue**. Foundation for all view and vertical problems.

| File | Problem |
|------|---------|
| `LevelOrderTraversal.java` | Leetcode 102 — Binary Tree Level Order Traversal |
| `ZigZagTraversal.java` | Leetcode 103 — Binary Tree Zigzag Level Order Traversal (alternate direction per level) |

---

# T-3 · Tree Views  *(What is visible from a specific direction?)*
> All view problems are **BFS with a selection rule** — left-most, right-most, top-most, or bottom-most visible node at each vertical column or level.

| File | Problem | Direction |
|------|---------|-----------|
| `LeftViewOfBinaryTree.java` | GFG — Left View | First node of each BFS level |
| `RightViewOfBinaryTree.java` | Leetcode 199 — Right Side View | Last node of each BFS level |
| `TopViewOfBinaryTree.java` | GFG — Top View | First node at each vertical column (horizontal distance) |
| `BottomViewOfBinaryTree.java` | GFG — Bottom View | Last node at each vertical column |

---

# T-4 · Vertical & Boundary Traversals  *(Coordinate-based ordering)*
> Assign `(row, col)` coordinates to each node. Sort/group by column, then row.

| File | Problem |
|------|---------|
| `VerticalOrderTraversalOfBinaryTree.java` | Leetcode 987 — Vertical Order Traversal (sort by col → row → value) |
| `BoundaryOrderTraversal.java` | GFG — Boundary Traversal (left boundary + leaves + right boundary, no duplicates) |

---

# T-5 · Tree-level Properties  *(Height, Depth, Diameter, Balance)*
> Computed bottom-up via **post-order DFS**. Return value from recursion carries the metric up the tree.

| File | Problem | Metric |
|------|---------|--------|
| `LeetCode_104.java` | Leetcode 104 — Maximum Depth of Binary Tree | Height |
| `LeetCode_110.java` | Leetcode 110 — Balanced Binary Tree | Height difference ≤ 1 at every node |
| `LeetCode_543.java` | Leetcode 543 — Diameter of Binary Tree | Longest path through any node (left height + right height) |
| `MaximumWidthOfBinaryTree.java` | Leetcode 662 — Maximum Width of Binary Tree | Max nodes between leftmost and rightmost at any level |
| `CountCompleteTreeNodes.java` | Leetcode 222 — Count Complete Tree Nodes | Exploit complete tree structure for O(log²n) |
| `ChildrenSumPropertyBinaryTree.java` | GFG — Children Sum Property | Every node value = sum of its children |

---

# T-6 · Structural / Identity Checks  *(Comparing two trees)*
> DFS on two trees simultaneously, checking structural and value equality at each node.

| File | Problem |
|------|---------|
| `LeetCode_100.java` | Leetcode 100 — Same Tree (identical structure + values) |
| `LeetCode_101.java` | Leetcode 101 — Symmetric Tree (mirror image of itself) |

---

# T-7 · Path Problems  *(Root-to-node, node-to-node, maximum sum paths)*
> DFS that tracks the current path or propagates sub-results upward.

| File | Problem |
|------|---------|
| `RootToNodePath.java` | Find the path from root to a given target node (backtracking DFS) |
| `MaximumPathSum.java` | Leetcode 124 — Binary Tree Maximum Path Sum (any node to any node, post-order) |
| `LowestCommonAncestor.java` | Leetcode 236 — Lowest Common Ancestor of a Binary Tree (LCA via DFS) |
| `AlNodesDistanceK.java` | GFG / Leetcode 863 — All nodes at distance K from target (parent-map + BFS) |

---

# T-8 · Utility / Support Classes
> Shared data structures used across all tree problem files.

| File | Purpose |
|------|---------|
| `Node.java` | Binary tree node definition (`int data`, `Node left`, `Node right`) |
| `Pair.java` | Generic pair helper used by BFS-coordinate problems |

---

---

## Pattern Decision Tree

```
What is the problem asking?
 │
 ├─ Visit all nodes in a specific order?
 │   ├─ Pre / In / Post order?         → T-1  (DFS Traversals)
 │   └─ Level by level?                → T-2  (BFS / Level Order)
 │
 ├─ What is "visible" from a direction?
 │   ├─ Left / Right side view?        → T-3  (Tree Views)
 │   ├─ Top / Bottom view?             → T-3  (Tree Views)
 │   └─ Vertical column ordering?      → T-4  (Vertical / Boundary)
 │
 ├─ Compute a single value for the tree?
 │   ├─ Height / Depth / Balance?      → T-5  (Tree Properties)
 │   ├─ Diameter / Width?              → T-5  (Tree Properties)
 │   └─ Complete tree node count?      → T-5  (Tree Properties)
 │
 ├─ Compare two trees?                 → T-6  (Structural Checks)
 │
 └─ Find a path or ancestor?
     ├─ Root-to-node path?             → T-7  (Path Problems)
     ├─ Max sum path?                  → T-7  (Path Problems)
     ├─ LCA?                           → T-7  (Path Problems)
     └─ Nodes at distance K?           → T-7  (Path Problems)
```

---

## Key Concept Notes
- **T-3 and T-4** both use BFS + a `(horizontal distance, level)` coordinate — difference is in what you *select* per column.
- **T-5 diameter / max path sum**: both follow the same post-order pattern — `leftResult + rightResult` at each node, update a global `max`.
- **T-7 LCA** is the prerequisite for `AlNodesDistanceK` (you need to find the target node and map parents before BFS).
- **Revision order suggestion**: T-1 → T-2 → T-3 → T-5 → T-6 → T-4 → T-7.

