package leetcode 

import "testing" 

func Test14LongestCommonPrefix(t *testing.T) {
    strs := []string {
        "abcdefg",
        "abcdeaabcd",
        "abcdeaababefg",
        "abcdeeff",
    }
    ans := "abcde"
    
    r := longestCommonPrefix(strs)
    if r != ans {
        t.Error(r, ans)
    }
}