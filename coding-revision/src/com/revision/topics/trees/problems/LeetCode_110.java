package com.revision.topics.trees.problems;

// PL - https://leetcode.com/problems/balanced-binary-tree/description/
public class LeetCode_110 {
    // Balanced Binary Tree - variation of height of BT

    /**
     * Here's the conceptual approach for the isBalanced problem:
     *
     * 1. **Recursive Height Check**
     *    - The solution uses a helper function `height` that returns the height of a subtree or `-1` if the subtree is unbalanced.
     *    - This combines height calculation and balance check in a single pass.
     *
     * 2. **Base Case Handling**
     *    - If a node is `null`, return `0` (height of empty tree is `0`).
     *
     * 3. **Left Subtree Validation**
     *    - Recursively compute left subtree height.
     *    - If left subtree is unbalanced (`height` returns `-1`), immediately return `-1`.
     *
     * 4. **Right Subtree Validation**
     *    - Recursively compute right subtree height.
     *    - If right subtree is unbalanced, immediately return `-1`.
     *
     * 5. **Balance Check**
     *    - At each node, check if absolute difference between left and right subtree heights exceeds `1`.
     *    - If yes, return `-1` (unbalanced).
     *
     * 6. **Height Calculation**
     *    - If balanced, return `1 + max(left_height, right_height)` (current node adds `1` to the height).
     *
     * 7. **Final Check**
     *    - The main function `isBalanced` calls `height(root)`.
     *    - Returns `true` if `height` returns a non-negative value (balanced), `false` otherwise.
     *
     * **Key Insight**:
     * Early termination of recursion upon detecting imbalance avoids unnecessary traversal, making the solution efficient (O(n) time, O(h) space). The `-1` return value acts as a flag to propagate imbalance upward without additional flags or state.
     * @param root
     * @return
     */
    public static boolean isBalanced(Node root) {

        return height(root) != -1;
    }

    private static int height(Node root) {
        if (root == null) {
            return 0;
        }

        int left = height(root.left);
        if (left == -1) return -1;
        int right = height(root.right);
        if (right == -1) return -1;

        if (Math.abs(left - right) > 1) return -1;
        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        Node node = new Node(null, null, 1);
        node.left = new Node(null, null, 2);
        node.right = new Node(null, null, 3);
        //if you uncomment below two lines and run it should return false.
//        node.right.right = new Node(null, null, 6);
//        node.right.right.right = new Node(null, null, 8);
        System.out.println(isBalanced(node));
    }
}
