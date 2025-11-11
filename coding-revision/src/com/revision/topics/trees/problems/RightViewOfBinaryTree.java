package com.revision.topics.trees.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// PL - https://leetcode.com/problems/binary-tree-right-side-view/
public class RightViewOfBinaryTree {

    /**
     * Iterate with level order traversal
     * since this is right view so always store last node value in the list at every level
     * @param root
     * @return
     */
    public static List<Integer> rightSideView(Node root) {
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

                if (i == size-1) {
                    list.add(temp.element);
                }
            }
        }
        return list;
    }

    static ArrayList<Integer> addRightNode(Node root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        rightView(root, arrayList, 0);
        return arrayList;
    }

    private static void rightView(Node root, ArrayList<Integer> arrayList, int level) {
        if (root == null) {
            return;
        }

        if (level == arrayList.size()) {
            arrayList.add(root.element);
        }

        rightView(root.right, arrayList, level + 1);
        rightView(root.left, arrayList, level + 1);
    }

    public static void main(String[] args) {
        Node node = new Node(null, null, 1);
        node.left = new Node(null, null, 2);
        node.right = new Node(null, null, 3);
        node.left.left = new Node(null, null, 4);
        node.left.right = new Node(null, null, 5);
        System.out.println(rightSideView(node));
    }
}
