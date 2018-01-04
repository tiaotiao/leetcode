/*
https://leetcode.com/problems/search-insert-position/description/

35. Search Insert Position

Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Example 1:

Input: [1,3,5,6], 5
Output: 2
Example 2:

Input: [1,3,5,6], 2
Output: 1
Example 3:

Input: [1,3,5,6], 7
Output: 4
Example 1:

Input: [1,3,5,6], 0
Output: 0
*/

int bsearchPosition(int * nums, int left, int right, int target) {
    int mid = (left + right) / 2;
    
    if (nums[mid] == target) {
        return mid;
    }
    
    if (nums[mid] < target) {
        if (mid == right) return mid+1;
        return bsearchPosition(nums, mid+1, right, target);
    } else {
        if (left == mid) return mid;
        return bsearchPosition(nums, left, mid-1, target);
    }
}

int searchInsert(int* nums, int numsSize, int target) {
    return bsearchPosition(nums, 0, numsSize-1, target);
}