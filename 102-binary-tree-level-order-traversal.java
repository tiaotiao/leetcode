import java.awt.List;

/*
https://leetcode.com/problems/binary-tree-level-order-traversal/description/

102. Binary Tree Level Order Traversal

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
*/

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

////////////////////////////////////////////////////////////

class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<TreeNode>> levels = new ArrayList<>();

        if (root == null) {
            return ConvertToIntArray(levels);
        }

        // init
        List<TreeNode> level = new ArrayList<>();
        level.add(root);
        levels.add(level);

        // BFS
        while(level != null && level.size() > 0) {
            List<TreeNode> nextLevel = new ArrayList<>();
            for (TreeNode node: level) {
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
            }

            if (nextLevel.size() == 0) {
                break;
            }
            
            // prepare for the next loop
            levels.add(nextLevel);
            level = nextLevel;
        }

        return ConvertToIntArray(levels);
    }

    private List<List<Integer>> ConvertToIntArray(List<List<TreeNode>> levels) {
        List<List<Integer>> intLevels = new ArrayList<>();

        if (levels == null) {
            return intLevels;
        }

        for (List<TreeNode> level: levels) {
            List<Integer> intLevel = new ArrayList<>();
            for (TreeNode node: level) {
                intLevel.add(node.val);
            }
            intLevels.add(intLevel);
        }
        
        return intLevels;
    }
}