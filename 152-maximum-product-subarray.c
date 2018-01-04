/*
https://leetcode.com/problems/maximum-product-subarray/description/

152. Maximum Product Subarray

Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
*/

int maxProduct(int* nums, int numsSize) {
    int start = 0;
    int product = 1;
    int max = nums[0];
    for (int i = 0; i <= numsSize; i++) {
        if (i == numsSize || nums[i] == 0) {
            if (i < numsSize && nums[i] == 0 && max < 0) {
                max = 0;
            }
            
            for (int j = start; j < i-1; j++) {
                product = product / nums[j];
                if (product > max) {
                    max = product;
                }
                if (nums[j] < 0) {
                    break;
                }
            }

            start = i+1;
            product = 1;
            continue;
        }

        product = product * nums[i];
        if (product > max) {
            max = product;
        }
    }

    return max;
}
