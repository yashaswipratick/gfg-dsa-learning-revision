package com.revision.topics.trees.problems;

import java.util.*;

// PL - https://www.geeksforgeeks.org/problems/left-view-of-binary-tree/1
public class LeftViewOfBinaryTree {

    /**
     * Iterate with level order traversal
     * since this is left view so always store first node value in the list at every level
     * @param root
     * @return
     */

    int maxLevel = 0;
    public static List<Integer> leftSideView(Node root) {
        if (root == null) return new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node temp = queue.poll();

                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);

                if (i == 0) {
                    list.add(temp.element);
                }
            }
        }
        return list;
    }

    static ArrayList<Integer> addLeftNode(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(root.element);
        Node cur = root.left;
        while (cur != null) {
            list.add(cur.element);
            if (cur.left != null) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return list;
    }

    public void printLeftViewRecursive(Node root, int level) {
        if (root == null) return;

        if (maxLevel < level) {
            System.out.println(root.element);
            maxLevel = level;
        }

        printLeftViewRecursive(root.left, level+1);
        printLeftViewRecursive(root.right, level+1);
    }

    public static void main(String[] args) {
        Node node = new Node(null, null, 1);
        node.left = new Node(null, null, 2);
        node.right = new Node(null, null, 3);
        node.left.left = new Node(null, null, 4);
        node.left.right = new Node(null, null, 5);
        System.out.println(addLeftNode(node));
    }
}
