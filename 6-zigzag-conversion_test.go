package leetcode

import (
    "testing"
)

func TestZigzagConversion(t *testing.T) {
    s := "PAYPALISHIRING"
    rows := 3
    
    a := "PAHNAPLSIIGYIR"
    
    r := convert(s, rows)
    
    if r != a {
        t.Error(r, a)
    }
}