package com.revision.topics.trees.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// PL - https://leetcode.com/problems/binary-tree-level-order-traversal/description/
public class LevelOrderTraversal {

    public static List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node temp = queue.poll();
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
                list.add(temp.element);
            }
            res.add(list);
        }
        return res;
    }
    public static void main(String[] args) {
        Node node = new Node(null, null, 1);
        node.left = new Node(null, null, 2);
        node.right = new Node(null, null, 3);
        System.out.println(levelOrder(node));
    }
}
