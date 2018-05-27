---
title: 102 - Binary Tree Level Order Traversal
url: https://leetcode.com/problems/binary-tree-level-order-traversal/
tags: [medium, binary tree, BFS]
---

#### [Problem](https://leetcode.com/problems/binary-tree-level-order-traversal/)

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example: 
Given binary tree `[3,9,20,null,null,15,7]`,

```
    3
   / \
  9  20
    /  \
   15   7
```

return its level order traversal as:

```
[
  [3],
  [9,20],
  [15,7]
]
```

#### [Solution](https://github.com/tiaotiao/leetcode/blob/master/102-binary-tree-level-order-traversal.java)

The problem is described as a binary tree traversal, but essentially a **BFS** (breadth-first search).

It is an easy variation of BFS. We don't need to deal with loops of a graph, since binary tree is divided into levels naturally. And we only need to extend all nodes in BFS without any extra process. So it just requires some basic understanding of BFS.

To make it more general, I'm gonna describe a typical process of BFS:

```java
// init
Q = Empty queue;
Q.add(start node);                  // put the start node in Q

// BFS
while (Q is not Empty) {
    node = Q.pop();                 // pop one node from head of Q
    for (neighbor of node) {        // extend this node
        if (neighbor is not in Q) { // make sure not loop back
            Q.add(neighbor);        // found a new node
        }
    }
}
```

For this problem, we create an array with the root node as the first level. In each loop, we scan all the nodes of current level and to extend their children to the next level.

Also we need to consider the corner cases. If the root node is null, we are going to return an empty array. If the root node has no child, we should return one level with the root node only.

```java
// init
List<TreeNode> level = new ArrayList<>();
level.add(root);
levels.add(level);

// BFS
while(level != null && level.size() > 0) {
    List<TreeNode> nextLevel = new ArrayList<>();
    // extend current level
    for (TreeNode node: level) {
        if (node.left != null) {
            nextLevel.add(node.left);
        }
        if (node.right != null) {
            nextLevel.add(node.right);
        }
    }

    if (nextLevel.size() == 0) {
        break;
    }
    
    // prepare for the next loop
    levels.add(nextLevel);
    level = nextLevel;
}
```

[Full Solution](https://github.com/tiaotiao/leetcode/blob/master/102-binary-tree-level-order-traversal.java)
