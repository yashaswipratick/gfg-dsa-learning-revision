package com.revision.topics.trees.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// PL - https://leetcode.com/problems/binary-tree-preorder-traversal/description/
// VL - https://www.youtube.com/watch?v=RlUu72JrOCQ&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=5
public class PreOrderTraversal {

    static void preOrderRecursive(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.element);
        preOrderRecursive(root.left);
        preOrderRecursive(root.right);
    }

    /**
     * 
     * @param root
     * @return
     */
    static List<Integer> preOrderIterative(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            Node temp = stack.pop();
            list.add(temp.element);
            if (temp.right != null) stack.push(temp.right);
            if (temp.left != null) stack.push(temp.left);
        }
        return list;
    }

    public static void main(String[] args) {
        Node node = new Node(null, null, 1);
        node.left = new Node(null, null, 2);
        node.right = new Node(null, null, 3);
        preOrderRecursive(node);
        System.out.println(preOrderIterative(node));
    }
}
