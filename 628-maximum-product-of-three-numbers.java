
import java.util.*;

class Solution {
    public int maximumProduct(int[] nums) {
        ArrayList<Integer> pos = new ArrayList<Integer>();
        ArrayList<Integer> neg = new ArrayList<Integer>();

        Arrays.sort(nums);

        for (int i = nums.length-1; i >=0; i--) {
            int num = nums[i];
            if (num > 0) {
                pos.add(num);
            } else {
                neg.add(num);
            }
        }

        // System.out.println(pos.size() + " " + neg.size());

        int max = nums[0] * nums[1] * nums[2];
        int prodi = 1;
        for (int i = 0; i < 4; i++) {
            if (pos.size() < i) break;

            if (i > 0) {
                prodi *= pos.get(i-1);
            }

            // System.out.println("  :" + i + " " + (4-i-1));
            
            if (neg.size() < 4-i-1) continue;
            
            int prodj = prodi;
            for (int j = 0; j < 4-i-1; j++) {
                prodj *= neg.get(neg.size() - j - 1);
            }

            // System.out.println("  >" + prodj);

            if (max < prodj) {
                max = prodj;
            }
        }

        return max;
    }
}




class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{-1,-2,-3};
        
        int res = s.maximumProduct(nums);

        System.out.println(res);
    }
}