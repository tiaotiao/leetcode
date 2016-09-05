/*
https://leetcode.com/problems/decode-string/

394. Decode String

Given an encoded string, return it's decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
*/

package leetcode

func decodeString(s string) string {
	u, _ := repeatString(s, 0)
	return u
}

func repeatString(s string, i int) (string, int) {
	var u, r string
	var k int

	for ; i < len(s); i++ {
		c := byte(s[i])

		if '0' <= c && c <= '9' {
			k = k*10 + int(c) - '0'
		} else if c == '[' {
			r, i = repeatString(s, i+1)
			for j := 0; j < k; j++ {
				u += r
			}
			k = 0
		} else if c == ']' {
			return u, i
		} else {
			u += string(c)
		}
	}

	return u, i
}
