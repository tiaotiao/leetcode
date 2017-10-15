/*
https://leetcode.com/problems/generate-parentheses/description/

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
*/

import java.util.*;

class Solution {
    private HashMap<Integer, List<String>> tmap = new HashMap<Integer, List<String>>();
    private HashMap<Integer, List<String>> fmap = new HashMap<Integer, List<String>>();

    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<String>();
        }
        return generate(n, false);
    }

    private List<String> generate(int n, boolean b) {
        List<String> l = getHash(n, b);
        if (l != null) {
            return l;
        }

        l= new ArrayList<String>();
        if (n == 0) {
            l.add("");
            setHash(n, b, l);
            return l;
        }

        if (b) {
            List<String> inside = generate(n-1, false);
            for (String s: inside) {
                l.add("(" + s + ")");
            }
            setHash(n, b, l);
            return l;
        }

        for (int i = n; i >= 1; i--) {
            List<String> left = generate(i, true);
            
            List<String> right = generate(n-i, false);

            for (String ls: left) {
                for (String rs: right) {
                    l.add(ls + rs);
                }
            }
        }
        setHash(n, b, l);
        return l;
    }

    private List<String> getHash(int n, boolean b) {
        if (b) {
            if (tmap.containsKey(n)) {
                return tmap.get(n);
            }
        } else {
            if (fmap.containsKey(n)) {
                return fmap.get(n);
            }
        }
        return null;
    }

    private void setHash(int n, boolean b, List<String> l) {
        if (b) {
            tmap.put(n, l);
        } else {
            fmap.put(n, l);
        }
    }
}

//////////////////////////////////////////////////////////////////////

class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();
        for (int n = 4; n >= 0; n--) {
            List<String> l = solution.generateParenthesis(n);
            System.out.printf("n = %d, len = %d\n", n, l.size());
            for (String s: l) {
                System.out.println(s);
            }
        }
    }
}