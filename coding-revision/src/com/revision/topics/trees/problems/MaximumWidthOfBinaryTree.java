package com.revision.topics.trees.problems;

import java.util.LinkedList;
import java.util.Queue;

// PL - https://leetcode.com/problems/maximum-width-of-binary-tree/
public class MaximumWidthOfBinaryTree {

    /**
     * Approach
     * To determine the maximum width of a tree, an effective strategy would be to assign and identify indexes for the leftmost and rightmost nodes at each level. Using these indexes, we can calculate the width for each level by subtracting the index of the leftmost node from that of the rightmost node.
     * Start by assigning an index to the root node as 0. For each level, the left child gets an index equal to 2 * parent index, and the right child gets an index equal to 2 * parent index + 1. Using a level order traversal, we use the leftmost and rightmost nodes at each level to get the width at that level. Keep track of the maximum width encountered during the traversal. Whenever a wider level is found, update the maximum width.
     * Use level-order traversal (BFS) and track each node’s position as if the tree were a complete binary tree.
     * For each level in the tree, note the position of the first and last node and compute the width as the difference between these two positions.
     * For the next level, assign positions to children. After processing all levels, return the maximum width recorded.
     *
     */
    public static int widthOfBinaryTree(Node root) {
        if (root == null) return 0;
        int ans = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            int size = queue.size();
            int min = queue.peek().level;
            int first = 0;
            int last = 0;

            for (int i = 0; i < size; i++) {
                int cur = queue.peek().level - min;
                Node temp = queue.poll().node;
                if (i == 0) first = cur;
                if (i == size - 1) last = cur;
                if (temp.left != null) {
                    queue.add(new Pair(temp.left, 2 * cur + 1));
                }
                if (temp.right != null) {
                    queue.add(new Pair(temp.right, 2 * cur + 2));
                }
            }
            ans = Math.max(ans, last - first + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Node node = new Node(null, null, 1);
        node.left = new Node(null, null, 2);
        node.right = new Node(null, null, 3);
        node.left.left = new Node(null, null, 4);
        node.left.right = new Node(null, null, 6);
        node.right.left = new Node(null, null, 5);
        node.right.right = new Node(null, null, 7);
        System.out.println(widthOfBinaryTree(node));
    }
}
