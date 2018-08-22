
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
    int sum;

    public int sumNumbers(TreeNode root) {
        sum = 0;
        sumPaths(root, 0);
        return sum;
    }

    private void sumPaths(TreeNode node, int num) { 
        if (node == null) return;

        num = num * 10 + node.val;
        if (node.left == null && node.right == null) {
            sum += num;
            return;
        }

        sumPaths(node.left, num);
        sumPaths(node.right, num);
    }
}