
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode node = root;
        if (node == null) return null;
        if (key < node.val) {
            node.left = deleteNode(node.left, key);
            return node;
        }
        if (node.val < key) {
            node.right = deleteNode(node.right, key);
            return node;
        }
        // delete this node
        if (node.left == null && node.right == null) {
            return null;
        }

        if (node.left != null) {
            TreeNode pseudo = new TreeNode(-1);
            pseudo.right = node.left;
            TreeNode leftLargest = deleteLargest(pseudo.right, pseudo);
            leftLargest.left = pseudo.right;
            leftLargest.right = node.right;
            return leftLargest;
        }

        return node.right;
    }

    private TreeNode deleteLargest(TreeNode node, TreeNode parent) {
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            return deleteLargest(node.right, node);
        }
        // node.right == null
        // delete this node
        parent.right = node.left;
        node.left = null;
        node.right = null;
        return node;
    }
}


