/*
https://leetcode.com/problems/minimum-depth-of-binary-tree/description/

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
*/

package leetcode

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func minDepth(root *TreeNode) int {
	queue := make([]*TreeNode, 0)
	head, tail := 0, 0

	numCurrentLevel := 0
	numNextLevel := 0
	depth := 0

	push := func(p *TreeNode) {
		queue = append(queue, p)
		head += 1
		numNextLevel += 1
	}

	pop := func() *TreeNode {
		if tail >= head {
			return nil
		}
		p := queue[tail]
		tail += 1

		if numCurrentLevel <= 0 {
			numCurrentLevel = numNextLevel
			numNextLevel = 0
			depth += 1
		}
		numCurrentLevel -= 1
		return p
	}

	push(root)

	for {
		p := pop()
		if p == nil {
			break
		}

		if p.Left == nil && p.Right == nil {
			return depth
		}

		if p.Left != nil {
			push(p.Left)
		}
		if p.Right != nil {
			push(p.Right)
		}
	}

	return 0
}
