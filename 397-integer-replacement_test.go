package leetcode

import "testing"

func TestIntegerReplacement(t *testing.T) {
    n := 31
    r := 6
    
    a := integerReplacement(n)
    if a != r {
        t.Error(a, r)
    }
}