/*
https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/

17. Letter Combinations of a Phone Number

Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

1:?     2:abc   3:def   4:ghi   5:jkl    6:mno
7:pqrs  8:tuv   9:wxyz  *:+     0:space  #:up

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.
*/

import java.util.*;

class Solution {
    ArrayList<String> combinations;
    HashMap<Character, String> mapping;

    public Solution() {
        mapping = new HashMap<Character, String>();
        mapping.put('1', "");
        mapping.put('2', "abc");
        mapping.put('3', "def");
        mapping.put('4', "ghi");
        mapping.put('5', "jkl");
        mapping.put('6', "mno");
        mapping.put('7', "pqrs");
        mapping.put('8', "tuv");
        mapping.put('9', "wxyz");
        mapping.put('0', " ");
        mapping.put('*', "+");
        mapping.put('#', "");
    }

    public List<String> letterCombinations(String digits) {
        combinations = new ArrayList<String>();
        StringBuilder combination = new StringBuilder(digits);

        if (digits.length() <= 0) {
            return combinations;
        }

        combine(digits, combination, 0);
        
        return combinations;
    }

    private void combine(String digits, StringBuilder combination, int index) {
        int n = digits.length();
        if (index >= n) {
            String comb = combination.toString();
            combinations.add(comb);
            return;
        }

        //System.out.println("combine " + index + " " + combination.toString());

        char ch = digits.charAt(index);
        String letters = mapping.get(ch);
        for (char letter: letters.toCharArray()) {
            combination.setCharAt(index, letter);

            combine(digits, combination, index+1);
        }
    }
}

///////////////////////////////////////////////////////////////////////////////////////
// test

class Main {
    public static class testCase {
        String input;
        List<String> expect;
        
        public testCase(String i, List<String> e) {
            this.input = i;
            this.expect = e;
        }

        public boolean compare(List<String> output) {
            if (output.size() != expect.size()) {
                return false;
            }
            for (String s: expect) {
                int i = output.indexOf(s);
                if (i < 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String [] args) {
        List<testCase> cases = new ArrayList<testCase>();
        cases.add(new testCase("23", new ArrayList<String>(Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"))));
        cases.add(new testCase("", new ArrayList<String>()));

        Solution s = new Solution();

        boolean ok = true;
        for (testCase c: cases) {
            List<String> output = s.letterCombinations(c.input);
            
            if (!c.compare(output)) {
                ok = false;
                System.out.println("failed: input " + c.input + ", expect " + c.expect.size() + 
                    c.expect.toString() + ", output " + output.size() + output.toString());
            }
        }

        if (ok) {
            System.out.println("ok");
        }
    }
}