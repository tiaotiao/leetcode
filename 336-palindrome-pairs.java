
import java.util.*;

class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> results = new ArrayList<>();
        if (words.length <= 1) return results;

        // reversed
        String[] reversed = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            StringBuilder sb = new StringBuilder(w);
            sb.reverse();
            reversed[i] = sb.toString();
        }

        Trie trieForward = new Trie();
        Trie trieBackward = new Trie();

        // build trie
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            String r = reversed[i];
            trieForward.insert(w, i);
            trieBackward.insert(r, i);
        }

        // search trie
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            String r = reversed[i];

            List<Node> prefix = trieForward.search(r);
            processPrefix(r, i, prefix, results, true);

            List<Node> suffix = trieBackward.search(w);
            processPrefix(w, i, suffix, results, false);
        }

        return results;
    }

    private void processPrefix(String s, int index, List<Node> prefix, List<List<Integer>> results, boolean order) {
        for (Node node: prefix) {
            String pre = node.word;
            String remain = s.substring(pre.length());
            if (index == node.position) continue;
            if (isPalindrome(remain)) {
                if (order) {
                    results.add(Arrays.asList(node.position, index));
                } else if (remain.length() > 0) {
                    results.add(Arrays.asList(index, node.position));
                }
            }
        }
    }

    private boolean isPalindrome(String s) {
        if (s.length() == 0) return true;
        for (int i = 0; i < s.length() / 2; i++) {
            int j = s.length() - i - 1;
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }

    class Trie {
        Node root;

        Trie() { root = new Node(); }

        // search for all words which are the prefix of the word
        public List<Node> search(String word) {
            List<Node> res = new ArrayList<>();
            _search(root, word, 0, res);
            return res;
        }

        private void _search(Node node, String word, int index, List<Node> res) {
            if (node.word != null) {
                res.add(node);
            }
            if (index >= word.length()) {
                return;
            }
            char ch = word.charAt(index);
            Node child = node.get(ch);
            if (child == null) return;
            _search(child, word, index + 1, res);
        }

        public Node insert(String word, int position) {
            Node node =  _insert(root, word, 0);
            node.position = position;
            node.word = word;
            return node;
        }

        private Node _insert(Node node, String word, int index) {
            if (index >= word.length()) return node;

            char ch = word.charAt(index);
            Node child = node.child(ch);

            return _insert(child, word, index + 1);
        }
    }

    class Node {
        Map<Character, Node> children;
        String word;
        int position;

        Node() {
            children = new HashMap<>();
            this.position = -1;
            this.word = null;
        }

        Node get(char c) {
            return children.getOrDefault(c, null);
        }

        Node child(char c) {
            Node ch = get(c);
            if (ch == null) {
                ch = new Node();
                children.put(c, ch);
            }
            return ch;
        }
    }
}


