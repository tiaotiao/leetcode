/*
https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/

30. Substring with Concatenation of All Words

You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

For example, given:
s: "barfoothefoobarman"
words: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter).
*/

#define NUM_CHILD 256

struct KMPTrie {
    int level;
    int count;
    char* str;
    struct KMPTrie* next;
    struct KMPTrie* child[NUM_CHILD];
};

typedef struct KMPTrie Node;

Node* newNode(int level) {
    Node* node = malloc(sizeof(Node));
    node->next = NULL;
    node->level = level;
    node->count = 0;
    memset(node->child, 0, NUM_CHILD * sizeof(Node*));
    return node;
}

void TrieInsert(Node* root, char* str) {
    Node* p = root;
    int i = 0;
    while(str[i] != 0) {
        if (p->child[str[i]] == NULL) {
            p->child[str[i]] = newNode(p->level + 1);
        }
        p = p->child[str[i]];
        i += 1;
    }
    p->count += 1;
    p->str = str;
}

void KMPTrieCalcNext(Node* root) {

}


/**
 * Return an array of size *returnSize.
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* findSubstring(char* s, char** words, int wordsSize, int* returnSize) {
    
}

