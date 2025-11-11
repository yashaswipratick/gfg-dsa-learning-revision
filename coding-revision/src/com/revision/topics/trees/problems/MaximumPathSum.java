package com.revision.topics.trees.problems;

// PL - https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
public class MaximumPathSum {

    /**
     * Approach
     * To find the maximum sum path in a binary tree, we treat every node as a possible turning point. At each node, we calculate the maximum path sum by adding the node’s value to the maximum path sums from its left and right subtrees.
     * We can solve the maximum path sum problem using recursively traversing the tree and treating each node as a possible turning point. At every node, we calculate two things:
     *      . The maximum path sum that passes through the current node (left + right + node value). This is used to update our global maximum.
     *      . The maximum path sum from the current node down one side (either left or right), which we return to the parent call.
     * If a node is null, we return 0 since it doesn’t contribute to the path. This way, we explore all possible paths and keep track of the highest one found.
     *    . Use a recursive function that explores each node in the tree, calculating the best path sum from its left and right branches. If a node is null, treat its path sum as zero.
     *    . For each node, calculate the total path sum by adding the current node's value and the sums from both its left and right branches.
     *    . Update the tracked maximum path sum if this total is larger than what we had before.
     *    . Return the best one-sided path (either left or right plus the current node) to be used in calculations above in the recursion.
     */
    public int maxPathSum(Node root) {
        int[] maxValue = new int[1];
        maxValue[0] = Integer.MIN_VALUE;
        maxPath(root, maxValue);
        return maxValue[0];
    }

    private int maxPath(Node root, int[] maxValue) {
        if (root == null) return 0;

        int left = Math.max(0, maxPath(root.left, maxValue));
        int right = Math.max(0, maxPath(root.right, maxValue));

        maxValue[0] = Math.max(maxValue[0], left + right + root.element);
        return Math.max(left, right) + root.element;
    }


}
