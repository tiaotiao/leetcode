/*
https://leetcode.com/problems/swap-nodes-in-pairs/description/

24. Swap Nodes in Pairs

Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
*/

struct ListNode {
    int val;
    struct ListNode *next;
};

typedef struct ListNode* Node;

struct ListNode* swapPairs(struct ListNode* head) {
    Node p, q, next;
    
    Node* prev = &head;
    
    next = head;
    
    while(next != NULL) {
        p = next;
        
        if (p->next == NULL) {
            break;
        }
        q = p->next;
        
        next = q->next;
        
        *prev = q;
        
        q->next = p;
        p->next = next;
        
        prev = &p->next;
    }
    
    return head;
}