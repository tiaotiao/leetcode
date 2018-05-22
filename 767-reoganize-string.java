

class Solution {
    public String reorganizeString(String s) {
        int maxChar = 0;
        int max = 0;
        int[] count = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            int k = s.charAt(i) - 'a';
            count[k] += 1;
            if (max < count[k]) {
                max = count[k];
                maxChar = k;
            }
        }
        
        // check
        int rest = 0;
        for (int k = 0; k < 26; k++) {
            if (k != maxChar) {
                rest += count[k];
            }
        }
        
        if (rest < max-1) {
            return "";
        }
        
        StringBuilder[] gaps = new StringBuilder[max];
        for (int i = 0; i < max; i++) {
            gaps[i] = new StringBuilder();
        }
        
        // construct string
        int gapidx = 0;
        for (int k = 0; k < 26; k++) {
            if (k == maxChar) continue;
            if (count[k] == 0) continue;
            
            for (int i = 0; i < count[k]; i++) {
                gaps[gapidx].append((char)('a' + k));
                gapidx = (gapidx+1) % max;
            }
        }
        
        // merge
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < max; i++) {
            sb.append((char)('a' + maxChar));
            sb.append(gaps[i].toString());
        }
        
        return sb.toString();
    }
}

