package com.revision.topics.trees.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// PL - https://leetcode.com/problems/binary-tree-postorder-traversal/description/
public class PostOrderTraversal {

    static void postOrderRecursive(Node root) {
        if (root == null) {
            return;
        }

        postOrderRecursive(root.left);
        postOrderRecursive(root.right);
        System.out.println(root.element);
    }

    /**
     * Here's the conceptual approach for the two-stack postorder traversal:
     *
     * 1. **Initialization**
     *    - Use two stacks: `stack1` (to process nodes) and `stack2` (to reverse order)
     *    - Initialize result list to store traversal order
     *    - Handle empty tree case immediately (return empty list)
     *
     * 2. **Process Nodes in Root-Right-Left Order**
     *    - Push root to `stack1`
     *    - While `stack1` isn't empty:
     *      - Pop node from `stack1`
     *      - Push popped node to `stack2` (this reverses the processing order)
     *      - Push left child to `stack1` (if exists)
     *      - Push right child to `stack1` (if exists)
     *    *Result: Nodes are added to `stack2` in Root-Right-Left order*
     *
     * 3. **Reverse to Get Postorder**
     *    - Pop all nodes from `stack2` (which now contains Root-Right-Left)
     *    - Add each popped node's value to result list
     *    *Result: Values are added to list in Left-Right-Root order (correct postorder)*
     *
     * 4. **Key Insight**
     *    - Postorder (Left-Right-Root) is the reverse of Root-Right-Left
     *    - `stack2` acts as a reversal mechanism: processing order (Root-Right-Left) → popped order (Left-Right-Root)
     * @param root
     * @return
     */
    static List<Integer> postOrderIterativeTwoStack(Node root) {
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        List<Integer> list = new ArrayList<>();

        if(root == null) return list;

        stack1.push(root);
        while (!stack1.isEmpty()) {
            root = stack1.pop();
            stack2.push(root);
            if (root.left != null) stack1.push(root.left);
            if (root.right != null) stack1.push(root.right);
        }

        while (!stack2.isEmpty()) {
            list.add(stack2.pop().element);
        }
        return list;
    }

    //TODO - implement using one stack

    public static void main(String[] args) {
        Node node = new Node(null, null, 1);
        node.left = new Node(null, null, 2);
        node.right = new Node(null, null, 3);
        postOrderRecursive(node);
    }
}
