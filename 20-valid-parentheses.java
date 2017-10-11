/*
https://leetcode.com/problems/valid-parentheses/description/

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all 
valid but "(]" and "([)]" are not.
*/

import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (leftSide(c)) {
                stack.push(c);
            } else {
                if (stack.size() <= 0) {
                    return false;
                }
                char l = stack.pop();
                if (!match(l, c)) {
                    return false;
                }
            }
        }

        if (stack.size() > 0) {
            return false;
        }

        return true;
    }

    private boolean leftSide(char c) {
        if (c == '(' || c == '[' || c == '{') {
            return true;
        }
        return false;
    }

    private boolean match(char l, char r) {
        if ((l == '(' && r == ')') || (l == '[' && r == ']') || (l == '{' && r == '}')) {
            return true;
        }
        return false;
    } 
}

