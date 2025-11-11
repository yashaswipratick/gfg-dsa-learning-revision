package com.revision.topics.trees.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// PL - https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
public class ZigZagTraversal {

    /**
     * Approach
     *
     * Take a queue and follow the process for inserting into queue as level order traversal.
     * take a count as 0
     * if count is even then insert into inner list in reverse way. Linked list gives that functionality to addLast().
     * if count is of then insert into inner list from front. Linked list gives that functionality to addFirst().
     * in end of inner for loop just add in the result list.
     * @param root
     * @return
     */
    public static List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                Node temp = queue.poll();
                if (count % 2 == 0) {
                    list.addLast(temp.element);
                } else {
                    list.addFirst(temp.element);
                }

                if (temp.left != null) {
                    queue.add(temp.left);
                }

                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            count++;
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        Node node = new Node(null, null, 1);
        node.left = new Node(null, null, 2);
        node.right = new Node(null, null, 3);
        System.out.println(zigzagLevelOrder(node));
    }
}
