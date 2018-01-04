/*
https://leetcode.com/problems/implement-strstr/description/

28. Implement strStr()

Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
*/


#include<string.h>

int* calcNext(char* p, int size) {
    int* next = malloc(size * sizeof(int));
    
    int i = 1, j = 0;
    next[0] = 0;
    
    while(i < size && j < size) {
        if (p[i] == p[j]) {
            next[i] = j + 1;
            i += 1;
            j += 1;
        } else {
            if (j == 0) {
                next[i] = 0;
                i += 1;
            } else {
                j = next[j-1];
            }
        }
    }
    
    return next;
}


int strStr(char* haystack, char* needle) {
    int n = strlen(haystack);
    int m = strlen(needle);
    
    if (m > n) {
        return -1;
    }
    
    int* next = calcNext(needle, m);
    
    int i = 0, j = 0;
    while(i < n && j < m) {
        if (haystack[i] == needle[j]) {
            i += 1;
            j += 1;
        } else {
            if (j == 0) {
                i += 1;
            } else {
                j = next[j-1];
            }
        }
    }
    
    free(next);
    
    if (j >= m) {
        return i - m;
    }
    return -1;
}


