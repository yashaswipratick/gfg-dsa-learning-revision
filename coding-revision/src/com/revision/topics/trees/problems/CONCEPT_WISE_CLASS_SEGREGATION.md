# Trees — Concept-wise Segregation

> All files are under `trees/problems/` with direct problem links

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

- [ ] `PreOrderTraversal.java` - Binary Tree Preorder Traversal - [Problem](https://leetcode.com/problems/binary-tree-preorder-traversal/description/)
- [ ] `InOrderTraversal.java` - Binary Tree Inorder Traversal - [Problem](https://leetcode.com/problems/binary-tree-inorder-traversal/description/)
- [ ] `PostOrderTraversal.java` - Binary Tree Postorder Traversal - [Problem](https://leetcode.com/problems/binary-tree-postorder-traversal/description/)

---

# T-2 · BFS / Level Order Traversals
> Process nodes level by level using a **Queue**. Foundation for all view and vertical problems.

- [ ] `LevelOrderTraversal.java` - Binary Tree Level Order Traversal - [Problem](https://leetcode.com/problems/binary-tree-level-order-traversal/description/)
- [ ] `ZigZagTraversal.java` - Binary Tree Zigzag Level Order Traversal - [Problem](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/)

---

# T-3 · Tree Views  *(What is visible from a specific direction?)*
> All view problems are **BFS with a selection rule** — left-most, right-most, top-most, or bottom-most visible node at each vertical column or level.

- [ ] `LeftViewOfBinaryTree.java` - Left View (first node of each BFS level) - [Problem](https://www.geeksforgeeks.org/problems/left-view-of-binary-tree/1)
- [ ] `RightViewOfBinaryTree.java` - Right Side View (last node of each BFS level) - [Problem](https://leetcode.com/problems/binary-tree-right-side-view/)
- [ ] `TopViewOfBinaryTree.java` - Top View (first node at each vertical column) - [Problem](https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1)
- [ ] `BottomViewOfBinaryTree.java` - Bottom View (last node at each vertical column) - [Problem](https://www.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1)

---

# T-4 · Vertical & Boundary Traversals  *(Coordinate-based ordering)*
> Assign `(row, col)` coordinates to each node. Sort/group by column, then row.

- [ ] `VerticalOrderTraversalOfBinaryTree.java` - Vertical Order Traversal - [Problem](https://www.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1)
- [ ] `BoundaryOrderTraversal.java` - Boundary Traversal - [Problem](https://www.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1)

---

# T-5 · Tree-level Properties  *(Height, Depth, Diameter, Balance)*
> Computed bottom-up via **post-order DFS**. Return value from recursion carries the metric up the tree.

- [ ] `LeetCode_104.java` - Maximum Depth of Binary Tree (Height) - [Problem](https://leetcode.com/problems/maximum-depth-of-binary-tree/description/)
- [ ] `LeetCode_110.java` - Balanced Binary Tree (height difference <= 1 at every node) - [Problem](https://leetcode.com/problems/balanced-binary-tree/description/)
- [ ] `LeetCode_543.java` - Diameter of Binary Tree (longest path through any node) - [Problem](https://leetcode.com/problems/diameter-of-binary-tree/)
- [ ] `MaximumWidthOfBinaryTree.java` - Maximum Width of Binary Tree (max nodes between leftmost and rightmost at any level) - [Problem](https://leetcode.com/problems/maximum-width-of-binary-tree/)
- [ ] `CountCompleteTreeNodes.java` - Count Complete Tree Nodes (exploit complete tree structure for O(log^2 n)) - [Problem](https://leetcode.com/problems/count-complete-tree-nodes/)
- [ ] `ChildrenSumPropertyBinaryTree.java` - Children Sum Property (every node value = sum of its children) - No link available

---

# T-6 · Structural / Identity Checks  *(Comparing two trees)*
> DFS on two trees simultaneously, checking structural and value equality at each node.

- [ ] `LeetCode_100.java` - Same Tree - [Problem](https://leetcode.com/problems/same-tree/description/)
- [ ] `LeetCode_101.java` - Symmetric Tree - [Problem](https://leetcode.com/problems/symmetric-tree/)

---

# T-7 · Path Problems  *(Root-to-node, node-to-node, maximum sum paths)*
> DFS that tracks the current path or propagates sub-results upward.

- [ ] `RootToNodePath.java` - Root to Node Path - No link available
- [ ] `MaximumPathSum.java` - Binary Tree Maximum Path Sum - [Problem](https://leetcode.com/problems/binary-tree-maximum-path-sum/description/)
- [ ] `LowestCommonAncestor.java` - Lowest Common Ancestor of a Binary Tree - [Problem](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/)
- [ ] `AlNodesDistanceK.java` - All Nodes at Distance K - [Video](https://youtu.be/i9ORlEy6EsI)

---

# T-8 · Utility / Support Classes
> Shared data structures used across all tree problem files.

- [ ] `Node.java` - Binary tree node definition (`int data`, `Node left`, `Node right`)
- [ ] `Pair.java` - Generic pair helper used by BFS-coordinate problems

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
- **Problem links** are extracted directly from class files — click them to access resources instantly without switching files.
- Topic checkbox is a parent tracker: if you mark a topic as checked, mark all problems under that topic as checked too.

