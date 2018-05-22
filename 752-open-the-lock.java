
import java.util.*;

class Solution {

    private boolean putin(Queue<Integer> q, int newNum, int[] deads, boolean[] visited) {
        if (visited[newNum]) {
            return false;
        }
        boolean dead = false;
        for (int k = 0; k < deads.length; k++) {
            if (deads[k] == newNum) {
                dead = true;
                break;
            }
        }
        if (dead) {
            return false;
        }
        q.add(newNum);
        visited[newNum] = true;
        return true;
    }

    public int openLock(String[] deadends, String target) {
        
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[10000];
        int[] dir = new int[]{1, -1};

        int dest = Integer.parseInt(target);
        int[] deads = new int[deadends.length];
        for (int i = 0; i < deadends.length; i++) {
            deads[i] = Integer.parseInt(deadends[i]);
        }
        
        int step;
        int count;
        int prevCount;
        
        // init
        putin(q, 0, deads, visited);

        step = 0;
        count = 0;
        prevCount = 1;

        while(!q.isEmpty()) {
            int num = q.remove();

            // extend curr
            int hi = num;
            int low = 0;
            int tens = 1;
            for (int i = 0; i < 4; i++) {
                int digit = hi % 10;

                for (int d : dir) {
                    int newDigit = digit + d;
                    if (newDigit < 0) newDigit += 10;
                    if (newDigit >= 10) newDigit -= 10;

                    int newNum = (hi - digit + newDigit) * tens + low;

                    boolean ok = putin(q, newNum, deads, visited);
                    if (!ok) {
                        continue;
                    }
                    count += 1;

                    //System.out.printf("%d: %d -> %d, hi=%d, low=%d, d=%d, digit=%d, newDigit=%d, prev=%d count=%d\n", step, num, newNum, hi, low, d, digit, newDigit, prevCount, count);

                    if (newNum == dest) {
                        return step+1;
                    }
                    
                }

                low += digit*tens;
                hi /= 10;
                tens *= 10;
            }

            prevCount -= 1;
            if (prevCount <= 0) {
                prevCount = count;
                step += 1;
                count = 0;
            }
        }
        return -1;
    }
}


class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int step = s.openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202");
        System.out.println(step);
    }
}