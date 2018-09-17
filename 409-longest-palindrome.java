
class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        // add up
        for (char ch: s.toCharArray()) {
            int count = map.getOrDefault(ch, 0);
            map.put(ch, count + 1);
        }
        
        // count
        int length = 0;
        boolean odd = false;
        
        for (char ch: map.keySet()) {
            int count = map.get(ch);
            if (count % 2 == 1) {
                odd = true;
                count -= 1;
            }
            
            length += count;
        }
        
        if (odd) length += 1;
        return length;
    }
}