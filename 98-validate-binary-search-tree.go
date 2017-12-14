
/*
https://leetcode.com/problems/validate-binary-search-tree/description/
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:
    2
   / \
  1   3
Binary tree [2,1,3], return true.
Example 2:
    1
   / \
  2   3
Binary tree [1,2,3], return false.
*/
package leetcode
type TreeNode struct {
    Val int
    Left *TreeNode
    Right *TreeNode
}


 import "math"
 
 func isValidBST(root *TreeNode) bool {
	 
	 var isvalid func (p *TreeNode, min, max int) bool
	 
	 isvalid = func (p *TreeNode, min, max int) bool {
		 if p == nil {
			 return true
		 }
		 if p.Val < min || max < p.Val {
			 return false
		 }
		 return isvalid(p.Left, min, p.Val-1) && isvalid(p.Right, p.Val+1, max)
	 }
	 
	 return isvalid(root, math.MinInt32, math.MaxInt32)
 }