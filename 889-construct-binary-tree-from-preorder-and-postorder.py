# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def constructFromPrePost(self, pre, post):
        n = len(pre)
        if n == 0:
            return None
        if n == 1:
            return TreeNode(pre[0])

        node = TreeNode(pre[0])

        leftroot = pre[1]
        leftroot_in_post = post.index(leftroot)
        left_length = leftroot_in_post + 1

        node.left = self.constructFromPrePost(pre[1:1+left_length], post[:left_length])
        node.right = self.constructFromPrePost(pre[1+left_length:], post[left_length:-1])

        return node

