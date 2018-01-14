/*
https://leetcode.com/problems/wildcard-matching/description/

44. Wildcard Matching

Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") �� false
isMatch("aa","aa") �� true
isMatch("aaa","aa") �� false
isMatch("aa", "*") �� true
isMatch("aa", "a*") �� true
isMatch("ab", "?*") �� true
isMatch("aab", "c*a*b") �� false
*/


import java.util.*;

/* Wrong answer */
class Solution {
    
    class Item {
        char ch;
        int least;
        boolean multiple;
        Item(char c) {
            ch = c;
        }
    }
    
    public boolean isMatch(String s, String p) {
        Item[] items = new Item[p.length()];

        for (int i = p.length()-1; i >= 0; i--) {
            char ch = p.charAt(i);
            Item item = new Item(ch);

            item.least = 1;
            item.multiple = false;
            if (i != p.length()-1) {
                item.least = items[i+1].least + 1;
                item.multiple = items[i+1].multiple;
            }
            
            if (ch == '*') {
                item.multiple = true;
                item.least -= 1;
            }

            items[i] = item;
        }

        // verify
        int i = 0, j = 0;
        while (i < p.length() && j < s.length()) {
            Item item = items[i];
            char ch = s.charAt(j);
            int remain = s.length() - j;

            //System.out.println(i + ": " + item.ch + " "+ item.least + " " + remain + " " + item.multiple + " j:" + j + " " + ch);

            if (item.least > remain) {
                return false;
            }
            if (item.least != remain && !item.multiple) {
                return false;
            }

            if (item.ch == '?') {
                i++; j++;
                continue;
            }
            if (item.ch == '*') {
                i++;
                if (i < p.length() && items[i].multiple == false) {
                    j = s.length() - items[i].least;
                }
                continue;
            }
            if (item.ch == ch) {
                i++; j++;
                continue;
            }
            j++;
        }

        if (i >= p.length()) {
            return true;
        }
        return false;
    }
}




/////////////////////////////////////////////////////////

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abefcdgiescdfimde";
        String p = "ab*cd?i*de";

        boolean result = solution.isMatch(s, p);
        System.out.println(result);
    }
}
