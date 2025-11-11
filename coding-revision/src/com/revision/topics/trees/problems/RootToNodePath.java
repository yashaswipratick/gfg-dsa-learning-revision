package com.revision.topics.trees.problems;

import java.util.ArrayList;

public class RootToNodePath {

    //variation - Root to leaf path

    /**
     * To find the path from the root to the given node in the tree we use a Depth-First Traversal. We initialise a vector to store the current path and recursively travel to each node in the tree. At each step, we check if the current node is null, if it is we return false and if the data value of the current node is equal to the given node, we return true signifying the end of the traversal search.
     *
     * During the recursive calls, we append the current node’s data value to the vector and explore the left and right children. We backtrack if the target value is not found as the children return ‘false’ and remove the last node from the path vector. In the end, we return the vector containing the path from the root to the given node.
     * Start a recursive DFS traversal from the root node. Maintain a list (or vector) that keeps track of the current path from the root to the current node during traversal.
     * At each node, add its value to the current path list. Then, check if this node is the target leaf node by verifying both that it's a leaf (no left or right child) and that its value matches the given target.
     * If the current node is not the target leaf, recursively search in the left and right subtrees. If either recursive call returns true, it means the target leaf is found through that path, so continue returning true.
     * If the leaf is not found in either subtree, backtrack by removing the current node from the path list before returning false, ensuring the path list only contains valid nodes on the path to the leaf.
     */
    public static ArrayList<Integer> solve(Node root, int val) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;
        getPath(root, list, val);
        return list;
    }

    private static boolean getPath(Node root, ArrayList<Integer> list, int val) {
        if (root == null) {
            return false;
        }

        list.add(root.element);
        if (root.element == val) {
            return true;
        }

        if (getPath(root.left, list, val) || getPath(root.right, list, val)) {
            return true;
        }
        list.remove(list.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        Node node = new Node(null, null, 1);
        node.left = new Node(null, null, 2);
        node.right = new Node(null, null, 3);
        node.left.left = new Node(null, null, 4);
        node.left.right = new Node(null, null, 6);
        node.right.left = new Node(null, null, 5);
        node.right.right = new Node(null, null, 7);
        System.out.println(solve(node, 5));
    }
}
