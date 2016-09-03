package leetcode 

import (
    "testing"
)

func TestReverseInterger(t *testing.T) {
    i := -12300
    r := -321
    
    a := reverse(i)
    
    if r != a {
        t.Error(r, a)
    }
}
