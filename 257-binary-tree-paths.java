
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> results = new ArrayList<>();
        List<TreeNode> path = new ArrayList<>();

        treePaths(root, path, results);

        return results;
    }

    private void treePaths(TreeNode node, List<TreeNode> path, List<String> results) {
        if (node == null) {
            return;
        }

        path.add(node);
        
        if (node.left == null && node.right == null) {
            results.add(pathToString(path));
            path.remove(path.size() - 1);
            return;
        }

        treePaths(node.left, path, results);
        treePaths(node.right, path, results);

        path.remove(path.size() - 1);
        return;
    }

    private String pathToString(List<TreeNode> path) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < path.size(); i++) {
            if (i > 0) {
                sb.append("->");
            }
            sb.append(path.get(i).val);
        }

        return sb.toString();
    }
}