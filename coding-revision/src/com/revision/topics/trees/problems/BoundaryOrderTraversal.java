package com.revision.topics.trees.problems;

import java.util.ArrayList;

// PL - https://www.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1
public class BoundaryOrderTraversal {

    /**
     * Approach
     * Add the root node in the list
     * Add the left nodes of the tree in the list(Left view of binary tree)
     * Add the leaf node of the tree in the list(using preorder traversal)
     * Add the right node of the tree in the list(Right view of binary tree)
     * @param root
     * @return
     */
    static ArrayList<Integer> boundaryTraversal(Node root) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        if (!isLeaf(root)) list.add(root.element);
        addLeftNode(root, list);
        addLeaf(root, list);
        addRightNode(root, list);
        return list;
    }

    static void addLeftNode(Node root, ArrayList<Integer> list) {
        Node cur = root.left;
        while (cur != null) {
            if (!isLeaf(cur)) list.add(cur.element);
            if (cur.left != null) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
    }

    static void addRightNode(Node root, ArrayList<Integer> arrayList) {
        Node cur = root.right;
        ArrayList<Integer> tempList = new ArrayList<>();
        while (cur != null) {
            if (!isLeaf(cur)) {
                tempList.add(cur.element);
            }
            if (cur.right != null) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        for (int i = tempList.size() - 1; i >= 0; --i) {
            arrayList.add(tempList.get(i));
        }
    }

    static void addLeaf(Node root, ArrayList<Integer> list) {
        if (isLeaf(root)) {
            list.add(root.element);
            return;
        }
        if (root.left != null) addLeaf(root.left, list);
        if (root.right != null) addLeaf(root.right, list);
    }

    public static boolean isLeaf(Node root) {
        return root.left == null && root.right == null;
    }

    public static void main(String[] args) {
        Node node = new Node(null, null, 1);
        node.left = new Node(null, null, 2);
        node.right = new Node(null, null, 3);
        node.left.left = new Node(null, null, 4);
        node.left.right = new Node(null, null, 5);
        System.out.println(boundaryTraversal(node));

        Node nodeq = new Node(null, null, 1);
        nodeq.right = new Node(null, null, 2);
        nodeq.right.right = new Node(null, null, 3);
        nodeq.right.right.right = new Node(null, null, 4);
        System.out.println(boundaryTraversal(nodeq));
    }
}
