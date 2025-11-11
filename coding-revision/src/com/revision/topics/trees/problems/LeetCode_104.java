package com.revision.topics.trees.problems;

//PL - https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
public class LeetCode_104 {

    //Maximum Depth of Binary Tree - variation of height of BT
    public static int maxDepth(Node root) {

        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return 1 + Math.max(left, right);
    }

    //TODO - try finding height using level order traversal

    public static void main(String[] args) {
        Node node = new Node(null, null, 1);
        node.left = new Node(null, null, 2);
        node.right = new Node(null, null, 3);
        System.out.println(maxDepth(node));
    }
}
