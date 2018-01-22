
import java.util.*;

public class Solution {
    
    private void reverse(char[] c, int left, int right) {
        while (left < right) {
            char tmp = c[left];
            c[left] = c[right];
            c[right] = tmp;
            left ++;
            right --;
        }
    }
    
    private int moveTo(char[] c, int index, int left, int right) {
        int i;
        for (i = 0; left + i <= right; i++) {
            c[index + i] = c[left + i];
        }
        if (index + i < c.length) {
            c[index+i] = ' ';
        }
        return index+i+1;
    }
    
    public String reverseWords(String s) {
        char[] c = s.toCharArray();
        int left = -1, right = -1;
        int index = 0;
        
        for (int i = 0; i < c.length; i++) {
            if (c[i] == ' ') {
                if (left != -1) {
                    reverse(c, left, right);
                    index = moveTo(c, index, left, right);
                }
                left = -1;
                right = -1;
            } else {
                if (left == -1) {
                    left = i;
                }
                right = i;
            }
        }
        
        if (left != -1) {
            reverse(c, left, right);
            index = moveTo(c, index, left, right);
        }
        
        int m = index - 1;
        
        if (m > 0) { 
            reverse(c, 0, m-1);
        }
        
        String str = String.valueOf(c);
        if (m > 0) {
            str = str.substring(0, m);
        }
        
        return str.trim();
    }
}