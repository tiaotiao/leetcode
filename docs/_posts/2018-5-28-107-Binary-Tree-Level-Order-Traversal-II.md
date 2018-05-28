---
title: 107 - Binary Tree Level Order Traversal II
url: https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
tags: [medium, binary tree, DFS]
---

#### [Problem](https://leetcode.com/problems/binary-tree-level-order-traversal-ii/)

Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example: 
Given binary tree `[3,9,20,null,null,15,7]`,
```
    3
   / \
  9  20
    /  \
   15   7
```

return its bottom-up level order traversal as:
```
[
  [15,7],
  [9,20],
  [3]
]
```

#### [Solution](https://github.com/tiaotiao/leetcode/blob/master/107-binary-tree-level-order-traversal-II.java)

Similar to the previous problem [102 - Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/), we can solve this problem by simply reversing the order of results of the previous problem.

I'm going to use another approach to solve it. **DFS** is the most convenient way to do tree traversal. The idea is we want to put every node to the correct position of the result list during the DFS traversal. 

```java
void dfs(TreeNode node, int depth, List<List<Integer> resluts) {
    if (node == null) return;

    // add current node to the correct position of result 
    addToResults(node.val, depth, results);

    // visit child nodes recursively
    dfs(node.left, depth + 1, resluts);
    dfs(node.right, depth + 1, resluts);
}
``` 

How to add the node to it's correct position? The fist thing is to find the list of level of current depth from the resluts. We use `List<List<Integer>> results` to represent the levels of the tree. We start from an empty list of resluts. During the DFS, if current depth is larger than the size of resluts, which means we reached a new level, we create a new list for this level and add it to resluts. If the depth of current node is smaller than the size of results, which means there is already a list for the level, we just get it from resluts.

After we found the list of current level, we simply append the value of current node to the level. We can make sure the order of each level is correct (from left to right) because we are doing preorder visiting. For each node we visit the left subtree first, which guaranteed the left node is always visited before the right node.

```java
private void addToResults(int value, int depth, List<List<Integer>> results) {
    List<Integer> level;
    if (depth < results.size()) {   // current level is already in resluts
        level = results.get(results.size() - depth - 1);
    } else {                        // we reached a new level
        level = new ArrayList<>();  // create new list for current level
        results.add(0, level);      // add it to the front
    }
    level.add(value);               // add value of node to current level
}
```

[Full Solution](https://github.com/tiaotiao/leetcode/blob/master/107-binary-tree-level-order-traversal-II.java)

