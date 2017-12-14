/*
https://leetcode.com/problems/binary-tree-level-order-traversal/description/

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

package leetcode

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func levelOrder(root *TreeNode) [][]int {
	queue := make([]*TreeNode, 0)
	head, tail := 0, 0

	push := func(p *TreeNode) {
		queue = append(queue, p)
		head += 1
	}

	pop := func() *TreeNode {
		if tail >= head {
			return nil
		}
		p := queue[tail]
		tail += 1
		return p
	}

	results := make([][]int, 0)
	r := make([]int, 0)

	push(root)
	numCurrentLevel := 1
	numNextLevel := 0

	for {
		p := pop()
		if p == nil {
			break
		}
		r = append(r, p.Val)
		if p.Left != nil {
			push(p.Left)
			numNextLevel += 1
		}
		if p.Right != nil {
			push(p.Right)
			numNextLevel += 1
		}

		numCurrentLevel -= 1
		if numCurrentLevel <= 0 {
			numCurrentLevel = numNextLevel
			numNextLevel = 0

			results = append(results, r)
			r = make([]int, 0)
		}
	}

	return results
}
