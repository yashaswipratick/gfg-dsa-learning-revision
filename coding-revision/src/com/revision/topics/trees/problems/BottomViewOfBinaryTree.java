package com.revision.topics.trees.problems;

import java.util.*;

// PL - https://www.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
public class BottomViewOfBinaryTree {
    //variation - based on vertical order traversal

        /*
        Approach to find the Bottom View of a Binary Tree:

        1. Objective:
           - The bottom view of a binary tree consists of the nodes visible when the tree is viewed from the bottom.
           - For each vertical line (horizontal distance from the root),
             we must select the **last node** seen from top to bottom (deepest node at that horizontal distance).

        2. Core Idea:
           - Perform a **level order traversal (BFS)** using a queue to visit every node in top-to-bottom order.
           - Maintain a **horizontal distance (HD)** for each node:
                → The root has HD = 0.
                → For the left child, HD = parent’s HD - 1.
                → For the right child, HD = parent’s HD + 1.

        3. Use a **TreeMap<Integer, Integer>** (sorted by HD):
           - Key = Horizontal Distance (HD)
           - Value = Node’s value (element)
           - During traversal, if another node is found at the same HD, it **overwrites** the previous one.
             (This ensures the bottom-most node at that HD is stored.)

        4. After BFS traversal completes:
           - The TreeMap will contain one node per horizontal distance — representing the bottom view.
           - Extract all values from the TreeMap in ascending HD order to get the final bottom view sequence.

        5. Time and Space Complexity:
           - Time: O(N log N) → because of TreeMap insertions for N nodes.
           - Space: O(N) → for queue and map storage.
        */

    public static ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();


        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair tempPair = queue.poll();
            int level = tempPair.level;
            Node temp = tempPair.node;

            map.put(level, temp.element);

            if (temp.left != null) {
                queue.add(new Pair(temp.left, level-1));
            }

            if (temp.right != null) {
                queue.add(new Pair(temp.right, level + 1));
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(entry.getValue());
        }
        return list;
    }

    public static void main(String[] args) {
        Node node = new Node(null, null, 1);
        node.left = new Node(null, null, 2);
        node.right = new Node(null, null, 3);
        /*node.left.left = new Node(null, null, 4);
        node.left.right = new Node(null, null, 5);*/
        System.out.println(bottomView(node));
    }
}
