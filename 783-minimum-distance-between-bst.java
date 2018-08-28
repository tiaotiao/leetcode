

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
    public int minDiffInBST(TreeNode root) {
        Item item = minDiff(root);
        return item.diff;
    }

    private Item minDiff(TreeNode root) {
        if (root == null) return null;

        Item item = new Item(root.val, root.val, Integer.MAX_VALUE);
        if (root.left == null && root.right == null) {
            return item;
        }

        Item left = minDiff(root.left);
        Item right = minDiff(root.right);

        if (left != null) {
            item.min = left.min;
            item.diff = Math.min(item.diff, left.diff);
            item.diff = Math.min(item.diff, Math.abs(root.val - left.max));
        }

        if (right != null) {
            item.max = right.max;
            item.diff = Math.min(item.diff, right.diff);
            item.diff = Math.min(item.diff, Math.abs(right.min - root.val));
        }
        return item;
    }

    private class Item {
        int min, max, diff;
        Item(int min, int max, int diff) {
            this.min = min; this.max = max; this.diff = diff;
        }
    }
}

