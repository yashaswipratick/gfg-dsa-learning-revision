package com.revision.topics.trees.problems;

import java.util.*;

// PL - https://www.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
// VL - https://www.youtube.com/watch?v=4w2Ri4VhgZo&list=PLjhq5EHRYAeJc6-oMw43yxY6LtieTNV9a&index=15
// solution provided by leetcode c++ converted to java
public class VerticalOrderTraversalOfBinaryTree {
    //variation - based on vertical order traversal

            /*
        💡 APPROACH: Vertical Order Traversal of a Binary Tree
        -------------------------------------------------------

        🔹 Goal:
        We need to print the vertical traversal of a binary tree, where:
        1. Nodes are grouped by their horizontal distance (x-axis).
        2. For nodes with the same horizontal distance, we order them by level (y-axis, top to bottom).
        3. If multiple nodes share the same (x, y), they must appear in ascending order of their values.

        -------------------------------------------------------
        🔹 INTUITION:
        Each node in the tree can be assigned coordinates (x, y):
           - Root node is at (x = 0, y = 0)
           - Left child  → (x - 1, y + 1)
           - Right child → (x + 1, y + 1)

        We perform a **level-order traversal (BFS)** to visit all nodes and record their (x, y, value) mapping.

        -------------------------------------------------------
        🔹 DATA STRUCTURES USED:
        1. **TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map**
           - Outer TreeMap (x): Keeps vertical columns sorted from left to right.
           - Inner TreeMap (y): Keeps nodes at each column sorted from top to bottom.
           - PriorityQueue<Integer>: Ensures nodes with same (x, y) are sorted by value.

        2. **Queue<Tuple> queue**
           - Used for BFS traversal.
           - Each Tuple stores a node and its coordinates (x, y).

        -------------------------------------------------------
        🔹 ALGORITHM:
        1. Initialize `map` (TreeMap) to store (x → y → node values).
        2. Start BFS traversal with the root node at (0, 0).
        3. For each node dequeued:
           a. Insert its value into `map[x][y]`.
           b. If left child exists → enqueue (x-1, y+1)
           c. If right child exists → enqueue (x+1, y+1)
        4. After BFS completes:
           - The `map` now contains all nodes grouped by (x, y) with proper order.
        5. Traverse the map:
           - For each `x` in ascending order (TreeMap ensures this automatically)
           - For each `y` in ascending order
           - Extract all node values from PriorityQueue and add to result list.
        6. Return the list of lists.

        -------------------------------------------------------
        🔹 TIME COMPLEXITY:
        O(N log N)
           - Each insertion and traversal into TreeMaps (sorted maps) takes log N time.
           - BFS visits every node once.

        🔹 SPACE COMPLEXITY:
        O(N)
           - For storing nodes in map and queue.

        -------------------------------------------------------
        🔹 EXAMPLE WALKTHROUGH:

        Tree:
                1
               / \
              2   3
             / \ / \
            4  6 5  7

        Coordinates (x, y):
          4 → (-2, 2)
          2 → (-1, 1)
          6 → (0, 2)
          1 → (0, 0)
          5 → (0, 2)
          3 → (1, 1)
          7 → (2, 2)

        Vertical columns (x = -2 → 2):
          [-2]: [4]
          [-1]: [2]
          [0]:  [1,5,6]
          [1]:  [3]
          [2]:  [7]

        Final Output → [[4], [2], [1,5,6], [3], [7]]

        -------------------------------------------------------
        ✅ Summary:
        - Use BFS with coordinates (x, y)
        - Use TreeMap for vertical + level order
        - Use PriorityQueue to handle tie cases
        - Extract final sorted result column-wise
        */

    //TODO - Most important
    public static List<List<Integer>> verticalOrderTraversal(Node root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<>();

        // Start BFS with root at (x=0, y=0)
        queue.offer(new Tuple(root, 0, 0));

        while (!queue.isEmpty()) {
            Tuple t = queue.poll();
            Node node = t.node;
            int x = t.x; // horizontal distance
            int y = t.y; // level (depth)

            // Maintain TreeMap for sorting by x, then y, and PriorityQueue for node values
            map.computeIfAbsent(x, k -> new TreeMap<>())
                    .computeIfAbsent(y, k -> new PriorityQueue<>())
                    .offer(node.element);

            if (node.left != null) queue.offer(new Tuple(node.left, x - 1, y + 1));
            if (node.right != null) queue.offer(new Tuple(node.right, x + 1, y + 1));
        }

        // Build result list
        List<List<Integer>> result = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
            List<Integer> col = new ArrayList<>();
            for (PriorityQueue<Integer> pq : ys.values()) {
                while (!pq.isEmpty()) {
                    col.add(pq.poll());
                }
            }
            result.add(col);
        }

        return result;
    }

    // Helper class for BFS traversal with coordinates
    static class Tuple {
        Node node;
        int x, y;
        Tuple(Node node, int x, int y) {
            this.node = node;
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Node node = new Node(null, null, 1);
        node.left = new Node(null, null, 2);
        node.right = new Node(null, null, 3);
        node.left.left = new Node(null, null, 4);
        node.left.right = new Node(null, null, 6);
        node.right.left = new Node(null, null, 5);
        node.right.right = new Node(null, null, 7);
        System.out.println(verticalOrderTraversal(node));
    }
}
