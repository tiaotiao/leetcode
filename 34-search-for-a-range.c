/*
https://leetcode.com/problems/search-for-a-range/description/

34. Search for a Range

Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/

int bsearchEx(int* nums, int left, int right, int target, int maching) {
    if (left > right) {
        return -1;
    }
    
    int mid = (left + right) / 2;
    
    int found = 0;
    if (nums[mid] == target) {
        if (maching == 0) {
            return mid;
        }
        found = 1;
    }
    
    if (found == 0) {
        if (nums[mid] > target) {
            return bsearchEx(nums, left, mid-1, target, maching);
        } else {
            return bsearchEx(nums, mid+1, right, target, maching);
        }
    } else {
        int other;
        if (maching == 0) {
            return mid;
        }
        if (maching < 0) {
            other = bsearchEx(nums, left, mid-1, target, maching);
        } else {
            other = bsearchEx(nums, mid+1, right, target, maching);
        }
        
        if (other != -1) {
            return other;
        }
        return mid;
    }
}


/**
 * Return an array of size *returnSize.
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* searchRange(int* nums, int numsSize, int target, int* returnSize) {
    int start = bsearchEx(nums, 0, numsSize-1, target, -1);
    int end = bsearchEx(nums, 0, numsSize-1, target, 1);
    
    int* ret = malloc(2 * sizeof(int));
    ret[0] = start;
    ret[1] = end;
    
    *returnSize = 2;
    return ret;
}