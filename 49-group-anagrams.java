/*
https://leetcode.com/problems/group-anagrams/description/

49. Group Anagrams

Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note: All inputs will be in lower-case.
*/

import java.util.*;

class Solution {
    
    public String encode(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c - 'a'] += 1;
        }

        String r = "";
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                r += String.format("%c%d", 'a'+i, count[i]);
            }
        }
        return r;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            String key = encode(s);
            List<String> list = map.get(key);
            if (list == null) {
                list = new ArrayList<String>();
                map.put(key, list);
            }
            list.add(s);
        }
        
        List<List<String>> ret = new ArrayList<>();
        for (List<String> list : map.values()) {
            ret.add(list);
        }
        return ret;
    }
}

class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        List<List<String>> result = s.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(result.size());
        for (int i = 0; i < result.size(); i++) {
            List<String> group = result.get(i);
            for (int j = 0; j < group.size(); j++) {
                System.out.print(group.get(j) + " ");
            }
            System.out.println();
        }
    }
}
