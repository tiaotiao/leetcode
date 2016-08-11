/*
1. Two Sum  QuestionEditorial Solution  My Submissions
Total Accepted: 271107
Total Submissions: 1066531
Difficulty: Easy
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/

package leetcode

func twoSum(nums []int, target int) []int {
	m := make(map[int]int, len(nums)) // definition: m[remain] = index

	for i, v := range nums {
		idx, ok := m[v]
		if ok {
			return []int{idx, i}
		}

		remain := target - v
		m[remain] = i
	}
	return nil
}
