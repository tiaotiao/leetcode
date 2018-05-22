

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


class Solution {
    
        private void toList(TreeNode root, List<Integer> list) {
            if (root == null) {
                return;
            }
            
            toList(root.left, list);
            
            list.add(root.val);
            
            toList(root.right, list);
        }
        
        public boolean findTarget(TreeNode root, int k) {
            List<Integer> list = new ArrayList<>();
            
            toList(root, list);
            int n = list.size();
            if (n < 2) {
                return false;
            }
            
            int p = 0, q = n-1;
            
            while(p < q) {
                int sum = list.get(p) + list.get(q);
                if (sum == k) {
                    return true;
                }
                if (sum < k) {
                    p++;
                } else {
                    q--;
                }
            }
            
            return false;
        }
    }
    
    