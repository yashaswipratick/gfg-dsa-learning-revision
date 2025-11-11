package com.revision.topics.trees.problems;

// PL - https://leetcode.com/problems/diameter-of-binary-tree/
public class LeetCode_543 {

    //Diameter of Binary Tree - variation of height of BT
    /**
     * Give me approach for the below solution in java comment without code
     *
     * class Solution {
     *     public int diameterOfBinaryTree(TreeNode root) {
     *         int[] diameter = new int[1];
     *         int height = height(root, diameter);
     *         return diameter[0];
     *     }
     *
     *     private int height(TreeNode root, int[] diameter) {
     *         if (root == null) {
     *             return 0;
     *         }
     *
     *         int left = height(root.left, diameter);
     *         int right = height(root.right, diameter);
     *         diameter[0] = Math.max(diameter[0], left + right);
     *         return 1+ Math.max(left, right);
     *     }
     * }
     * @param root
     * @return
     */
    public static int diameterOfBinaryTree(Node root) {
        int[] diameter = new int[1];
        int height = height(root, diameter);
        return diameter[0];
    }

    private static int height(Node root, int[] diameter) {
        if (root == null) {
            return 0;
        }

        int left = height(root.left, diameter);
        int right = height(root.right, diameter);
        diameter[0] = Math.max(diameter[0], left + right);
        return 1+ Math.max(left, right);
    }

    public static void main(String[] args) {
        Node node = new Node(null, null, 1);
        node.left = new Node(null, null, 2);
        node.right = new Node(null, null, 3);
        node.right.right = new Node(null, null, 6);
        node.right.right.right = new Node(null, null, 8);
        System.out.println(diameterOfBinaryTree(node));
    }
}
