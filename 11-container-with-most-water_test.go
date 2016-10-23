package leetcode

import "testing"

func Test11ContainerWithMaxWater(t *testing.T) {
    cases := []struct {
        height []int
        ans int
    }{
        {[]int{1, 10, 15, 10, 5}, 20},
        {[]int{2, 1, 1, 1, 1, 5, 1, 5, 1, 1, 2}, 20},
    }
    
    for i, c := range cases {
        height := make([]int, len(c.height))
        copy(height, c.height)
        r := maxArea(height)
        if r != c.ans {
            t.Error(i, r, c.height, c.ans)
        }
    }
}