

class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        BST bst = new BST();
        long sum = 0;
        int count = 0;
        bst.insert(0);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            
            int right = bst.lessThan(sum - lower, true);
            int left = bst.lessThan(sum - upper, false);
            
            count += right - left;
            // System.out.printf("%d: sum=%d, left %d right %d, count %d\n", i, sum, left, right, count);
            bst.insert(sum);
        }
        
        return count;
    }
    
    /////////////////////////////////
    
    class BST {
        Node root;
        
        BST() {
            root = null;    
        }
        
        public Node insert(long val) {
            // System.out.println("+++ insert " + val);
            if (root == null) {
                root = new Node(val);
                return root;
            }
            return _insert(root, val);
        }
        
        private Node _insert(Node node, long val) {
            node.total += 1;
            
            if (node.val == val) {
                node.count += 1;
                return node;
            }
            
            if (val < node.val) {
                if (node.left == null) {
                    node.left = new Node(val);
                    return node;
                } else {
                    return _insert(node.left, val);
                }
            } else {
                if (node.right == null) {
                    node.right = new Node(val);
                    return node;
                } else {
                    return _insert(node.right, val);
                }
            }
        }
        
        public int lessThan(long val, boolean equal) {
            // System.out.println("<<< less " + val);
            return _lessThan(root, val, 0, equal);
        }
        
        private int _lessThan(Node node, long val, int less, boolean equal) {
            if (node == null) return less;
            
            // System.out.printf("    less %d: %d, %d\n", val, node.val, less);
                
            if (val < node.val) return _lessThan(node.left, val, less, equal);
            
            less += total(node.left);
            if (node.val == val) {
                if (equal) less += node.count;
                return less;
            }
            
            less += node.count;
            return _lessThan(node.right, val, less, equal);
        }
        
        private int total(Node node) {
            if (node == null) return 0;
            return node.total;
        }
        
        class Node {
            long val;
            int count;
            int total;
            Node left, right;
            Node (long val) {
                this.val = val; count = 1; total = 1;
                left = null; right = null;
            }
        }
    }
}