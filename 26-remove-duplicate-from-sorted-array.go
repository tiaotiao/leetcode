/*
https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/

Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example:

Given nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
It doesn't matter what you leave beyond the new length.
*/
package leetcode

func removeDuplicates(nums []int) int {
	if len(nums) <= 1 {
		return len(nums)
	}

	count := 1
	currentIdx := 0
	current := nums[currentIdx]

	for i, x := range nums {
		if i == 0 {
			continue
		}
		if x == current {
			continue
		}
		current = x
		nums[count] = x
		count += 1
	}

	return count
}
