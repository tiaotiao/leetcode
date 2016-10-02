package leetcode 

import "testing"

func Test409LongestPalindrome(t *testing.T) {
    args := []string{
        "abccccdd",
    }
    results := []int {
        7,
    }
    
    for i, arg := range args {
        r := results[i]
        a := longestPalindrome409(arg)
        
        if r != a {
            t.Error(arg, r, a)
        }
    }
}