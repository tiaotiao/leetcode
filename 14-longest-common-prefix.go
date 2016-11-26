/*
https://leetcode.com/problems/longest-common-prefix/

14. Longest Common Prefix

Total Accepted: 136041
Total Submissions: 449658
Difficulty: Easy
Contributors: Admin

Write a function to find the longest common prefix string amongst an array of strings.
*/

package leetcode 

func longestCommonPrefix(strs []string) string {
    if len(strs) <= 0 {
        return ""
    }
    
    n := 0
    for {
        ok := true
        
        for _, s := range strs {
            if len(s) <= n || s[n] != strs[0][n] {
                ok = false
                break
            }
        }
        
        if !ok {
            break
        }
        n += 1
    }
    
    return strs[0][:n]
}
