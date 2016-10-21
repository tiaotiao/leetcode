/*
https://leetcode.com/problems/regular-expression-matching/

10. Regular Expression Matching

Total Accepted: 98910
Total Submissions: 431157
Difficulty: Hard

Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
*/

package leetcode

func isMatch(s string, p string) bool {
    
    isStar := func(p string, j int) bool {
        if j >= len(p) {
            return false
        } 
        return p[j] == '*'
    }
    
    lengthRange := func(p string, j int) (int, int) {
        c := 0
        for i := j; i < len(p); i++ {
            if p[i] == '*' {
                c++
            }
        }
        if c == 0 {
            return len(p) - j, len(p) - j
        }
        return len(p) - j - c*2, -1
    }
    
    var match func(i, j int) bool
    
    match = func(i, j int) (ok bool) {
        //println("matching:", s[i:], p[j:])
        
        if i >= len(s) && j >= len(p) {
            return true
        }
        if j >= len(p) {
            return false
        }
        
        cp := p[j]
        star := isStar(p, j+1)
        
        if !star {
            if i >= len(s) {
                return false
            }
            cs := s[i]
            if cp != '.' && cs != cp {
                return false
            }
            return match(i+1, j+1)
        }
        
        // matching star
        var farthest int
        if cp == '.' {
            farthest = len(s)
        } else {
            for farthest = i; farthest < len(s); farthest++ {
                if s[farthest] != cp {
                    break
                }
            }
        }
        
        minLen, maxLen := lengthRange(p, j+1)
        if maxLen == -1 {
            maxLen = len(s) - i
        }
        
        if minLen > maxLen {
            return false
        }
        
        if len(s) - minLen < farthest {
            farthest = len(s) - minLen
        }
        
        nearest := i
        if nearest < len(s) - maxLen {
            nearest = len(s) - maxLen
        }
        
        for k := farthest; k >= nearest; k-- {
            if match(k, j+2) {
                return true
            }
        }
        
        return false
    }

    return match(0, 0)
}