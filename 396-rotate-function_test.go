package leetcode

import "testing"

func TestRotateFunction(t *testing.T) {
    A := []int{4, 3, 2, 6}
    r := 26
    
    a := maxRotateFunction(A)
    if a != r {
        t.Error(a, r)
    }
}