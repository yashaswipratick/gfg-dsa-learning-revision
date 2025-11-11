package com.revision.topics.trees.problems;

// PL - https://leetcode.com/problems/same-tree/description/
public class LeetCode_100 {

    public static boolean isSameTree(Node p, Node q) {
        if (p == null || q == null) {
            return p == q;
        }

        return (p.element == q.element) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    public static void main(String[] args) {
        Node node = new Node(null, null, 1);
        node.left = new Node(null, null, 2);
        node.right = new Node(null, null, 3);
        node.right.right = new Node(null, null, 6);
        node.right.right.right = new Node(null, null, 8);
        System.out.println(isSameTree(node, node));
    }
}
