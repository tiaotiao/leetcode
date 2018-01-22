
import java.util.*;

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
    
    // return -1 if not balanced
    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = depth(root.left);
        if (left < 0) {
            return -1;
        }
        int right = depth(root.right);
        if (right < 0) {
            return -1;
        }
        
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
    
    public boolean isBalanced(TreeNode root) {
        int d = depth(root);
        if (d < 0) {
            return false;
        }
        return true;
    }
}