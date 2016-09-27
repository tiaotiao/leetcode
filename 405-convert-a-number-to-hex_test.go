package leetcode

import "testing"

func Test405ConvertToHex(t *testing.T) {
    num := 26
    r := "1a"
    a := toHex(num)
    if a != r {
        t.Error(a, r)    
    }
    
}