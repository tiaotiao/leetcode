/*
Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

Example:

Input: 
words = ["oath","pea","eat","rain"] and board =
[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]

Output: ["eat","oath"]
Note:
You may assume that all inputs are consist of lowercase letters a-z.
*/

import java.util.*;

class Solution {
    char[][] board;
    boolean[][] mark;
    int n, m;
    List<String> results = new ArrayList<>();
    Trie trie;
    int[][] dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};

    public List<String> findWords(char[][] board, String[] words) {
        if (board == null) {
            return results;
        }
        if (words == null) {
            return results;
        }
        n = board.length;
        if (n == 0) {
            return results;
        }
        m = board[0].length;
        if (m == 0) {
            return results;
        }
        this.board = board;

        // build trie tree
        trie = new Trie();
        for (String word: words) {
            trie.insert(word);
        }

        // bfs
        mark = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bfs(i, j, trie.root);
            }
        }
        return results;
    }

    // search if p contains the char of [x][y]
    private void bfs(int x, int y, Node p) {
        if (p == null) {
            // TODO
            return;
        }
        char c = board[x][y];

        if (p.next(c) == null) {
            // TODO not found
            return;
        }

        Node node = p.next(c);

        // if node is leaf, found a word
        if (node.word != null) {
            if (!results.contains(node.word)) {
                results.add(node.word);
            }
        }

        mark[x][y] = true;
        for (int[] dir: dirs) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (newX < 0 || n <= newX
            || newY < 0 || m <= newY) {
                continue;
            }

            if (mark[newX][newY]) {
                continue;
            }

            bfs(newX, newY, node);
        }
        mark[x][y] = false;
    }

    //////////////////////////////////////////

    private class Trie {
        public Node root = new Node();
        
        public void insert(String word) {
            Node p = root;
            for (char c: word.toCharArray()) {
                p = p.insert(c);
            }
            p.word = word;
        } 
    }

    private class Node {
        public Node[] children = new Node[26];
        public String word;
        
        public Node insert(char c) {
            int index = c - 'a';
            if (children[index] == null) {
                children[index] = new Node();
            }
            return children[index]; 
        }

        public Node next(char c) {
            int index = c - 'a';
            return children[index]; 
        }
    }
}