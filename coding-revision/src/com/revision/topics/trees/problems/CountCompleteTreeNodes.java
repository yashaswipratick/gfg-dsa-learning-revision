package com.revision.topics.trees.problems;

// PL - https://leetcode.com/problems/count-complete-tree-nodes/
public class CountCompleteTreeNodes {

    public static int countNodes(Node root) {
        int[] c = new int[1];
        count(root, c);
        return c[0];
    }

    private static void count(Node root, int[] c) {
        if(root == null) {
            return;
        }
        c[0] += 1;

        count(root.left, c);
        count(root.right, c);
    }
    public static void main(String[] args) {
        Node node = new Node(null, null, 1);
        node.left = new Node(null, null, 2);
        node.right = new Node(null, null, 3);
        node.left.left = new Node(null, null, 4);
        node.left.right = new Node(null, null, 6);
        node.right.left = new Node(null, null, 5);
        node.right.right = new Node(null, null, 7);
        System.out.println(countNodes(node));
    }
}
