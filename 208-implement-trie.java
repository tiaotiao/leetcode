

class Trie {

    Node root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node node =  _insert(root, word, 0);
        node.word = word;
    }

    private Node _insert(Node node, String word, int index) {
        if (index >= word.length()) return node;

        char ch = word.charAt(index);
        Node child = node.child(ch);

        return _insert(child, word, index + 1);
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node node = _search(root, word, 0);
        if (node == null || node.word == null) return false;
        return true;
    }
    public Node _search(Node node, String word, int index) {
        if (index >= word.length()) {
            return node;
        }
        char ch = word.charAt(index);
        Node child = node.get(ch);
        if (child == null) return null;
        return _search(child, word, index + 1);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node node = _search(root, prefix, 0);
        if (node == null) return false;
        return true;
    }

    ////////////////////////////////
    
    class Node {
        Map<Character, Node> children;
        String word;

        Node() {
            children = new HashMap<>();
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

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */