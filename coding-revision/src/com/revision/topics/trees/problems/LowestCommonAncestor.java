package com.revision.topics.trees.problems;

// PL - https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
public class LowestCommonAncestor {

    // What is LCA ?
    //Lowest Common Ancestor(LCA): The lowest common ancestor is defined between two nodes x and y as the lowest node in T that has both x and y as descendants (where we allow a node to be a descendant of itself.

    /*
    Approach:

        If root is null or if root is x or if root is y then return root
        Made a recursion call for both
        i) Left subtree

        ii)Right subtree

        Because we would find LCA in the left or right subtree only.

        If the left subtree recursive call gives a null value that means we haven’t found LCA in the left subtree, which means we found LCA on the right subtree. So we will return right.
        If the right subtree recursive call gives null value, that means we haven’t found LCA on the right subtree, which means we found LCA on the left subtree. So we will return left .
         If both left & right calls give values (not null)  that means the root is the LCA.
        Let’s take an example and will try to understand the approach more clearly:

        LCA of (x,y) = > (4,5) = ? (from above given example)
        Root is 1 which is not null and x,y is not equal to root, So the 1st statement in approach  will not execute.
        i) Call left subtree, While calling recursively it will find 4 and this call will return 4 to its parent
        Point to Note: At present, the root is 2 ( Look at below recursion tree for better understanding)

        i) Call the right subtree ( i.e right of 2), While calling recursively it will find 5  and this call will return 5 to its parent.

        Now the left recursive  call returns value (not null) i.e 4 and also the right recursive call returns value (not null) i.e 5 to its root ( at present root is 2) , and this 2 will return itself to its root i.e to 1 (main root).
        Point to Note: At present, the root is 1 ( Look at below recursion tree for better understanding)

        Now, the left subtree gives a value i.e 2.
        Right recursive call will give null value .because x,y are not present in the right subtree.
        As we know if the right recursive call gives null then we return the answer which we got from the left call, So we will return 2.
         Hence LCA of (4,5) is 2.

    */
    public static Node lowestCommonAncestor(Node root, Node p, Node q) {
        //Either root is null or root is equal to any of the p and q then we have LCA
        if (root == null || root == p || root == q) {
            return root;
        }

        // Traverse the tree left and traverse the tree right and try to find any of the on node.
        Node left = lowestCommonAncestor(root.left, p, q);
        Node right = lowestCommonAncestor(root.right, p, q);

        // If left(p) is not found return right(q)
        // If right(q) is not found return left(p)
        //else nothing found then return root.
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }

    public static void main(String[] args) {
        Node node = new Node(null, null, 1);
        node.left = new Node(null, null, 2);
        node.right = new Node(null, null, 3);
        node.left.left = new Node(null, null, 4);
        node.left.right = new Node(null, null, 6);
        node.right.left = new Node(null, null, 5);
        node.right.right = new Node(null, null, 7);
        System.out.println(lowestCommonAncestor(node, node, node));
    }
}
