package leetcode 

import "testing"

func TestSumOfLeftLeaves(t *testing.T) {
    
    buildTree := func(vals []int) *TreeNode {
        nodes := make([]*TreeNode, len(vals))
        for i := len(vals) - 1; i >= 0; i-- {
            val := vals[i]
            if val == -1 {
                nodes[i] = nil
                continue
            }
            nodes[i] = new(TreeNode)
            nodes[i].Val = val
            nodes[i].Left = nil
            nodes[i].Right = nil
            
            j := (i+1)*2-1
            if j < len(vals) {
                nodes[i].Left = nodes[j]
            }
            j += 1
            if j < len(vals) {
                nodes[i].Right = nodes[j]
            }
        }
        return nodes[0]
    }
    
    root := buildTree([]int{3, 9, 20, -1, -1, 15, 7})
    r := 24
    
    a := sumOfLeftLeaves(root)
    
    if a != r {
        t.Error(a, r)
    }
}
