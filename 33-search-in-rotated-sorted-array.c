/*
https://leetcode.com/problems/search-in-rotated-sorted-array/description/

33. Search in Rotated Sorted Array

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
*/

int offsetBsearch(int* nums, int numsSize, int offset, int left, int right, int target) {
    if (left > right) {
        return -1;
    }
    
    int mid = (left + right) / 2;
    int k = (offset + mid) % numsSize;
    
    if (nums[k] == target) {
        return k;
    }
    
    if (nums[k] > target) {
        return offsetBsearch(nums, numsSize, offset, left, mid-1, target);
    }
    return offsetBsearch(nums, numsSize, offset, mid+1, right, target);
}

int search(int* nums, int numsSize, int target) {
    int offset = 0;
    for (int i = 0; i < numsSize-1; i++) {
        if (nums[i] > nums[i+1]) {
            offset = i+1;
            break;
        }
    }
    
    return offsetBsearch(nums, numsSize, offset, 0, numsSize-1, target);
}