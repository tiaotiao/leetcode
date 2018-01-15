/*
https://leetcode.com/problems/simplify-path/description/

71. Simplify Path

Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
*/

import java.util.*;

class Solution {
    public String simplifyPath(String path) {
        String[] names = path.split("/");
        Stack<String> s = new Stack();
        
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            System.out.println(name);
            if (name.equals(".") || name.equals("")) {
                continue;
            } else if (name.equals("..")) {
                if (!s.isEmpty()) {
                    s.pop();
                }
                continue;
            } else {
                s.push(name);
            }
        }

        if (s.isEmpty()) {
            return "/";
        }

        String newPath = "";
        while (!s.isEmpty()) {
            String name = s.pop();
            newPath = "/" + name + newPath;
        }

        return newPath;
    }
}

class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        
        String path = "/aba/ab/../bcd/e/./efg/.";
        
        String newPath = s.simplifyPath(path);

        System.out.println(newPath);
    }
}