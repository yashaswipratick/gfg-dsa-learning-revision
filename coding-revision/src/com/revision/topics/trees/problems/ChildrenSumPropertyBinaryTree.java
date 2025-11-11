package com.revision.topics.trees.problems;

public class ChildrenSumPropertyBinaryTree {

    // TODO - Revisit
    // Approach - https://takeuforward.org/data-structure/check-for-children-sum-property-in-a-binary-tree/
    public void changeTree(Node root) {
        // Base case: If the current node
        // is null, return and do nothing.
        if (root == null) {
            return;
        }

        // Calculate the sum of the values of
        // the left and right children, if they exist.
        int child = 0;
        if (root.left != null) {
            child += root.left.element;
        }
        if (root.right != null) {
            child += root.right.element;
        }

        // Compare the sum of children with
        // the current node's value and update
        if (child >= root.element) {
            root.element = child;
        } else {
            // If the sum is smaller, update the
            // child with the current node's value.
            if (root.left != null) {
                root.left.element = root.element;
            } else if (root.right != null) {
                root.right.element = root.element;
            }
        }

        // Recursively call the function
        // on the left and right children.
        changeTree(root.left);
        changeTree(root.right);

        // Calculate the total sum of the
        // values of the left and right
        // children, if they exist.
        int tot = 0;
        if (root.left != null) {
            tot += root.left.element;
        }
        if (root.right != null) {
            tot += root.right.element;
        }

        // If either left or right child
        // exists, update the current node's
        // value with the total sum.
        if (root.left != null || root.right != null) {
            root.element = tot;
        }
    }

    public static void inorderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.element + " ");
        inorderTraversal(root.right);
    }

    public static void main(String[] args) {
        // Create the binary tree
        Node root = new Node(null, null, 3);
        root.left = new Node(null, null, 5);
        root.right = new Node(null, null, 1);
        root.left.left = new Node(null, null, 6);
        root.left.right = new Node(null, null, 2);
        root.right.left = new Node(null, null, 0);
        root.right.right = new Node(null, null, 8);
        root.left.right.left = new Node(null, null, 7);
        root.left.right.right = new Node(null, null, 4);

        ChildrenSumPropertyBinaryTree sol = new ChildrenSumPropertyBinaryTree();

        // Print the inorder traversal
        // of tree before modification
        System.out.print("Binary Tree before modification: ");
        inorderTraversal(root);
        System.out.println();

        // Call the changeTree function
        // to modify the binary tree
        sol.changeTree(root);

        // Print the inorder traversal
        // after modification
        System.out.print("Binary Tree after Children Sum Property: ");
        inorderTraversal(root);
        System.out.println();
    }
}