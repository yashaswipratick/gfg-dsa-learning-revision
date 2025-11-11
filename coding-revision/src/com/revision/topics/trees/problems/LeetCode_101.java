package com.revision.topics.trees.problems;

import java.util.LinkedList;
import java.util.Queue;

// PL - https://leetcode.com/problems/symmetric-tree/
public class LeetCode_101 {

    // variation - Similar problem as same tree.
    /**
     * similar problem as same tree.
     * Just split the tree into two halves
     * check left node with right node and right node with left node.
     * if both values are equal return true else return false
     * @param root
     * @return
     */
    public static boolean isSymmetricTree(Node root) {
        return symetric(root.left, root.right);
    }

    private static boolean symetric(Node p, Node q) {
        if (p == null || q == null) {
            return p == q;
        }

        return (p.element == q.element) && symetric(p.left, q.left) && symetric(p.right, q.right);
    }

    //iterative solution
    private boolean isMirrorIterative(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(root);

        while(!q.isEmpty()) {
            Node t1 = q.poll();
            Node t2 = q.poll();

            if(t1 == null && t2 == null) continue;
            if(t1 == null || t2 == null) return false;
            if(t1.element != t2.element) return false;

            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }

    public static void main(String[] args) {
        Node node = new Node(null, null, 1);
        node.left = new Node(null, null, 2);
        node.right = new Node(null, null, 2);
        /*node.right.right = new Node(null, null, 6);*/
        /*node.right.right.right = new Node(null, null, 8);*/
        System.out.println(isSymmetricTree(node));
    }
}
