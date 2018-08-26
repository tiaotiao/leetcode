
class Solution {

    List<TreeNode>[] cache = new List[21];

    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> res = new ArrayList<>();
        if (N % 2 == 0) return new ArrayList<>();
        if (cache[N] != null) return cache[N];
        if (N == 1) {
            res.add(new TreeNode(0));
            cache[N] = res;
            return res;
        }

        for (int leftN = 1; leftN < N; leftN += 2) {
            int rightN = N - 1 - leftN;

            List<TreeNode> leftTrees = allPossibleFBT(leftN);
            List<TreeNode> rightTrees = allPossibleFBT(rightN);

            // combination
            for (TreeNode left: leftTrees) {
                for (TreeNode right: rightTrees) {
                    TreeNode newTree = new TreeNode(0);
                    newTree.left = left;
                    newTree.right = right;
                    res.add(newTree);
                }
            }
        }
        cache[N] = res;
        return res;
    }
}