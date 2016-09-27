/*
https://leetcode.com/contest/6/problems/sum-of-left-leaves/

404. Sum of Left Leaves

Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
*/

package leetcode

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
 
type TreeNode struct {
    Val int
    Left *TreeNode
    Right *TreeNode
}
 
func sumOfLeftLeaves(root *TreeNode) int {
    if root == nil {
        return 0
    }
    if root.Left == nil && root.Right == nil {
        return 0
    }
    
    var sum int = 0
    
    if root.Left != nil {
        if root.Left.Left == nil && root.Left.Right == nil {
            sum += root.Left.Val
        } else {
            sum += sumOfLeftLeaves(root.Left)    
        }
    }

    if root.Right != nil {
        sum += sumOfLeftLeaves(root.Right)
    }
    
    return sum
}

