

class Solution {
    public int maxProduct(String[] words) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        
        for (String word: words) {
            int h = hash(word);
            int l = word.length();
            
            int len = map.getOrDefault(h, 0);
            len = Math.max(l, len);
            
            for (int x: map.keySet()) {
                if ((x & h) != 0) {
                    continue;
                }
                
                int len2 = map.get(x);
                
                max = Math.max(max, len * len2);
            }
            
            
            map.put(h, len);
        }
        
        return max;
    }
    
    private int hash(String word) {
        int h = 0;
        for (char c: word.toCharArray()) {
            int i = c - 'a';
            h |= 1 << i;
        }
        return h;
    }
}