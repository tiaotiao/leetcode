/*
https://leetcode.com/problems/count-and-say/description/

38. Count and Say

The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

Example 1:

Input: 1
Output: "1"
Example 2:

Input: 4
Output: "1211"
*/


char* countAndSay(int n) {
    if (n < 1) {
        return NULL;
    }
    
    int LEN = 10000;
    char *s = malloc(LEN * sizeof(char));
    char *t = malloc(LEN * sizeof(char));
    int sn = 1, tn = 0;
    s[0] = '1';
    
    for (int k = 0; k < n-1; k++) {
        int start = 0;
        int count = 0;
        s[sn] = '.';
        for (int i = 0; i <= sn; i++) {
            if (s[start] == s[i]) {
                count += 1;
                continue;
            }
            
            t[tn++] = '0' + count;
            t[tn++] = s[start];
            start = i;
            count = 1;
        }
        
        char* tmp = s;
        s = t;
        t = tmp;
        sn = tn;
        tn = 0;
    }
    
    free(t);
    s[sn] = 0;
    return s;
}
