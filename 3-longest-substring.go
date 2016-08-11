/*
https://leetcode.com/problems/longest-substring-without-repeating-characters/

3. Longest Substring Without Repeating Characters

Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

package leetcode

func lengthOfLongestSubstring(s string) int {
    var m = make([]int, 256)
    
    exist := func(c byte) (bool, int) {
        pos := m[c]
        if pos == 0 {
            return false, 0
        }
        return true, pos - 1
    }
    
    var length, max, j int = 0, 0, 0
    
    for i := 0; i < len(s); i++ {
        c := s[i]
        ok, pos := exist(c)
        if ok {
            for ; j <= pos; j++ {
                m[s[j]] = 0
            }
            m[c] = i + 1
            continue
        }
        
        m[c] = i + 1
        
        length = i - j + 1
        if length > max {
            max = length
        }
    }
    
    return max
}

