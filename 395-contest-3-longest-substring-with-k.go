/*
https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/

395. Longest Substring with At Least K Repeating Characters

Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.

Example 1:

Input:
s = "aaabb", k = 3

Output:
3

The longest substring is "aaa", as 'a' is repeated 3 times.
Example 2:

Input:
s = "ababbc", k = 2

Output:
5

The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
*/

package leetcode

func longestSubstring(s string, k int) int {
	var count = make([]int, 26)

	for _, r := range s {
		c := byte(r) - 'a'
		count[c] += 1
	}

	var longest = 0
	var long = 0
	var cc = make([]int, 26)
	var ct, cv = 0, 0

	for _, r := range s {
		c := byte(r) - 'a'

		if count[c] < k {
			cc = make([]int, 26)
			ct, cv = 0, 0
			long = 0
			continue
		}

		cc[c]++
		if cc[c] == 1 {
			ct++
		}
		if cc[c] == k {
			cv++
		}

		//println(string(r), ct, cv, long)
		long += 1
		if ct == cv {
			if long > longest {
				longest = long
			}
		}
	}

	return longest
}
