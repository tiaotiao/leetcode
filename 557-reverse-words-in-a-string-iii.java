

class Solution {
    public String reverseWords(String s) {
        String[] ss = s.trim().split("\\s+");
        
        for (int i = 0; i < ss.length; i++) {
            String w = ss[i];
            StringBuilder b = new StringBuilder(w);
            ss[i] = b.reverse().toString();
        }
        
        return String.join(" ", ss);
    }
}