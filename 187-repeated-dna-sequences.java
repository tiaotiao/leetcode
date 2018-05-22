import java.util.*;

class Solution {
    
    private int toInt(char ch) {
        switch (ch) {
            case 'A': return 0;
            case 'C': return 1;
            case 'G': return 2;
            case 'T': return 3;
        }
        return 0; // never reach here
    }

    private char toChar(int c) {
        switch (c) {
            case 0: return 'A'; 
            case 2: return 'G'; 
            case 1: return 'C'; 
            case 3: return 'T';
        }
        return ' '; // never reach here
    }

    private String toStr(int code) {
        char[] c = new char[10];
        for (int i = 0; i < 10; i++) {
            int r = code % 4;
            code = code / 4;
            c[9-i] = toChar(r); // put char from end to front
        }
        return String.valueOf(c);
    }

    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int SIZE = 10;

        int code = 0;
        for (int i=0; i < s.length(); i++) {

            code = code * 4 + toInt(s.charAt(i)); // add a new digit

            code = code & 0xFFFFF;  // remove the overflowed digit

            if (i < 9) continue;

            
            // System.out.printf("coding %c %d: %s %s\n", s.charAt(i), code, Integer.toBinaryString(code), toStr(code));

            if (!map.containsKey(code)) {
                map.put(code, 1);
            } else {
                map.put(code, 1+map.get(code));
            }
        }

        List<String> res = new ArrayList<>();
        for (int c : map.keySet()) {
            int count = map.get(c);
            if (count > 1) {
                String k = toStr(c);
                res.add(k);
            }
        }
        return res;
    }

    public List<String> _findRepeatedDnaSequences(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= s.length()-10; i++) {
            String sub = s.substring(i, i + 10);
            if (!map.containsKey(sub)) {
                map.put(sub, 1);
            } else {
                map.put(sub, 1+map.get(sub));
            }
        }
        
        List<String> res = new ArrayList<>();
        for (String k : map.keySet()) {
            int count = map.get(k);
            if (count > 1) {
                res.add(k);
            }
        }
        return res;
    }
}

class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> l = s.findRepeatedDnaSequences("GAGAGAGAGAGA");
        for (String v : l) {
            System.out.println(v);
        }
    }
}