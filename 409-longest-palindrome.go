/*
https://leetcode.com/contest/7/problems/longest-palindrome/

409. Longest Palindrome

User Accepted: 91
User Tried: 127
Total Accepted: 92
Total Submissions: 175
Difficulty: Easy

Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
*/

package leetcode 

func longestPalindrome409(s string) int {
    var count  = make(map[byte]int)
    bytes := []byte(s)
    
    for _, c := range bytes {
        count[c] += 1
    }
    
    odd := false
    sum := 0
    for _, v := range count {
        if v % 2 == 1 {
            odd = true
        }
        sum += (v / 2) * 2
    }
    
    if odd {
        sum += 1
    }
    return sum
}