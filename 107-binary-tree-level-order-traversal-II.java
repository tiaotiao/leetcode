/*
https://leetcode.com/problems/binary-tree-level-order-traversal-ii/discuss/119276/Java-solution-using-HashMap-2ms-beats-96-of-submissions

107. Binary Tree Level Order Traversal II

Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
*/


public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

////////////////////////////////////////////////////////////////

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();

        dfs(root, 0, results);

        return results;
    }

    private void dfs(TreeNode node, int depth, List<List<Integer>> results) {
        if (node == null) {
            return;
        }
        
        // add current node to the correct position of result 
        addToResults(node.val, depth, results);

        // visit child nodes recursively
        dfs(node.left, depth + 1, results);
        dfs(node.right, depth + 1, results);
    }

    private void addToResults(int value, int depth, List<List<Integer>> results) {
        List<Integer> level;
        if (depth < results.size()) {   // current level is already in resluts
            level = results.get(results.size() - depth - 1);
        } else {                        // we reached a new level
            level = new ArrayList<>();  // create new list for current level
            results.add(0, level);      // add it to the front
        }
        level.add(value);               // add value of node to current level
    }
}