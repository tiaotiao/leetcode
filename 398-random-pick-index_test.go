package leetcode

import "testing"

func TestRandomPickIndex(t *testing.T) {
    s := Constructor([]int{10, 20, 30, 20})
    a := s.Pick(30)
    if a != 2 {
        t.Error(a)
    }
}