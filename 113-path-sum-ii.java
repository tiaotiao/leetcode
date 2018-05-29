/*
https://leetcode.com/problems/path-sum-ii/description/

113. Path Sum II

Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:

[
   [5,4,11,2],
   [5,8,4,5]
]
*/

// public class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode(int x) { val = x; }
// }

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> reslut = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        pathSum(root, sum, path, reslut);

        return reslut;
    }

    private void pathSum(TreeNode node, int sum, List<Integer> path, List<List<Integer>> result) {
        
        if (node == null) {
            return;
        }
        
        sum = sum - node.val;
        path.add(node.val);

        if (node.left == null && node.right == null) {
            if (sum == 0) { // found a path
                result.add(new ArrayList<>(path));
            }
        } else {
            pathSum(node.left, sum, path, result);
            pathSum(node.right, sum, path, result);
        }

        path.remove(path.size() - 1);
    }
}
