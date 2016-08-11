/*
https://leetcode.com/problems/longest-palindromic-substring/

5. Longest Palindromic Substring

Given a string S, find the longest palindromic substring in S. 

You may assume that the maximum length of S is 1000, and there exists 
one unique longest palindromic substring.
*/

package leetcode

func longestPalindrome(s string) string {
    
    expand := func(i, j int) (int, int, int) {
        length := 0
        for i >= 0 && j < len(s) {
            if s[i] != s[j] {
                break
            }
            length = j - i + 1
            i -= 1
            j += 1
        }
        return length, i+1, j-1
    }
    
    var max, maxi, maxj int = 0, 0, 0
    var length, li, lj int
    
    for i := 0; i < len(s); i++ {
        length, li, lj  = expand(i, i)
        if length > max {
            max, maxi, maxj = length, li, lj
        }
        length, li, lj = expand(i, i+1)
        if length > max {
            max, maxi, maxj = length, li, lj
        }
    }
    
    return s[maxi: maxj+1]
}
