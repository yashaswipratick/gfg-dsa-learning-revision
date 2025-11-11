package com.revision.topics.trees.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// PL - https://leetcode.com/problems/binary-tree-inorder-traversal/description/
// VL - Striver tree series
public class InOrderTraversal {

    static void inOrderRecursive(Node root) {
        if (root == null) {
            return;
        }
        inOrderRecursive(root.left);
        System.out.println(root.element);
        inOrderRecursive(root.right);
    }

    /**
     * Initialize
     *
     * Create a stack to manage nodes (simulating recursion)
     * Create a result list to store traversal order
     * Start from the root node
     *
     *
     * Traverse left subtree
     *
     * While current node is not null:
     * Push current node onto stack
     * Move to left child (continue leftward)
     *
     *
     * Process node
     *
     * When left subtree exhausted (current node becomes null):
     * Pop the top node from stack (this is the leftmost unprocessed node)
     * Add its value to the result list (this is the "root" in left-root-right)
     * Move to the right subtree of the popped node
     *
     *
     * Repeat
     *
     * Continue steps 2-3 until:
     * Stack is empty (all nodes processed)
     * Current node is null and stack is empty (traversal complete)
     * @param root
     * @return
     */
    static List<Integer> inOrderIterative(Node root) {
        // Step 1: Initialize data structures
        // Stack to simulate recursive call stack for iterative traversal
        Stack<Node> stack = new Stack<>();
        // List to store the traversal result
        List<Integer> list = new ArrayList<>();
        // Start with the root node as the current node
        Node node = root;

        // Step 2: Iterative traversal using stack
        while (true) {
            // Step 2.1: Traverse left subtree as far as possible
            // Push current node to stack and move to left child
            if (node != null) {
                stack.push(node);
                node = node.left;
            }
            // Step 2.2: Process node after left subtree
            // When no left child exists (node is null), pop from stack
            else {
                // Exit condition: stack is empty means traversal complete
                if (stack.isEmpty()) {
                    break;
                }
                // Pop the top node (leftmost unprocessed node)
                node = stack.pop();
                // Add node value to result (inorder: left-root-right)
                list.add(node.element);
                // Move to right subtree to process it next
                node = node.right;
            }
        }
        // Step 3: Return the final inorder traversal result
        return list;
    }

    public static void main(String[] args) {
        Node node = new Node(null, null, 1);
        node.left = new Node(null, null, 2);
        node.right = new Node(null, null, 3);
        inOrderRecursive(node);
    }
}
