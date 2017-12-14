/*
https://leetcode.com/problems/longest-valid-parentheses/description/

32. Longest Valid Parentheses

Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
*/

package leetcode

func longestValidParentheses(s string) int {
	n := len(s)
	a := make([]int, n)
	top := 0
	current := 0
	max := 0
	for _, c := range s {
		if c == '(' {
			a[top] = current
			current = 0
			top += 1
		} else {
			if top > 0 {
				current = current + a[top-1] + 2
				top -= 1
				if max < current {
					max = current
				}
			} else {
				current = 0
			}
		}
	}
	return max
}
