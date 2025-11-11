package com.revision.topics.trees.problems;

import java.util.*;

// PL - https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1
public class TopViewOfBinaryTree {
    //variation - based on vertical order traversal
            /*
        Approach to find the Top View of a Binary Tree:

        1. Concept:
           - The top view of a binary tree is the set of nodes visible when the tree is viewed from the top.
           - Each vertical line of the tree has one visible node (the first one encountered from the top).

        2. Idea:
           - Use a level order traversal (BFS) to visit all nodes level by level.
           - Keep track of each node’s horizontal distance (HD) from the root.
               -> Root node has HD = 0
               -> Left child has HD = parent’s HD - 1
               -> Right child has HD = parent’s HD + 1
           - For each HD, store the first node encountered — this represents the topmost node at that vertical line.

        3. Data Structures Used:
           - A Queue<Pair> for BFS traversal, where Pair stores the node and its HD.
           - A TreeMap<Integer, Integer> to store HD → node value mapping.
             (TreeMap maintains sorted order of keys, ensuring left-to-right order in final output.)

        4. Steps:
           a) Initialize an empty queue and add the root node with HD = 0.
           b) While the queue is not empty:
                - Remove one node (current node and its HD).
                - If this HD is not already in the map, store it (first occurrence only).
                - Add the left child to the queue with HD - 1.
                - Add the right child to the queue with HD + 1.
           c) After traversal, the TreeMap will have the topmost nodes for each HD in sorted order.
           d) Collect all the node values from the TreeMap — this gives the top view from left to right.

        5. Time Complexity:
           - O(N log N) because each insertion in TreeMap takes O(log N).

        6. Space Complexity:
           - O(N) for the queue and TreeMap combined.

        Result:
           - The resulting list contains node values as seen from the top of the tree, from leftmost to rightmost.
        */

    public static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();


        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair tempPair = queue.poll();
            int level = tempPair.level;
            Node temp = tempPair.node;

            if (map.get(level) == null) map.put(level, temp.element);

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
        System.out.println(topView(node));
    }
}
