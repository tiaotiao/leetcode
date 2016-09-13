/*
https://leetcode.com/contest/4/problems/integer-replacement/

397. Integer Replacement

User Accepted: 360
User Tried: 527
Total Accepted: 473
Total Submissions: 3366
Difficulty: Easy

Given a positive integer n and you can do operations as follow:

If n is even, replace n with n/2.
If n is odd, you can replace n with either n + 1 or n - 1.
What is the minimum number of replacements needed for n to become 1?

Example 1:

Input:
8

Output:
3

Explanation:
8 -> 4 -> 2 -> 1

Example 2:

Input:
7

Output:
4

Explanation:
7 -> 8 -> 4 -> 2 -> 1
or
7 -> 6 -> 3 -> 2 -> 1
*/

package leetcode

func integerReplacement(n int) int {
    var f func(n int) int
    f = func(n int) int {
        if n <= 1 {
            return 0
        }
        
        c := 0
        for n % 2 == 0 {
            n /= 2
            c += 1
        }
            
        if c > 0 {
            return f(n) + c
        } else {
            p := f(n - 1)
            q := f(n + 1)
            if p > q {
                return q + 1
            } else {
                return p + 1
            }
        }
    }
    
    return f(n)
}


