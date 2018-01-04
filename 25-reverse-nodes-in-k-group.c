/*
https://leetcode.com/problems/reverse-nodes-in-k-group/description/

25. Reverse Nodes in k-Group

Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
*/

struct ListNode {
    int val;
    struct ListNode *next;
};

typedef struct ListNode* Node;

struct ListNode* reverseKGroup(struct ListNode* head, int k) {
    if (k <= 1) {
        return head;
    }
    
    Node p, q, next = head;
    Node* prev = &head;
    int i;
    
    while(next != NULL) {
        p = next;
        q = p;
        for (i = 0; i < k-1; i++) {
            q = q->next;
            if (q == NULL) {
                break;
            }
        }
        if (i < k-1) {
            break;
        }
        
        next = q->next;
        Node nextPrev = p;
        
        Node h = next, t;
        for (i = 0; i < k; i++) {
            t = p->next;
            p->next = h;
            h = p;
            p = t;
        }
        *prev = h;
        prev = &nextPrev->next;
    }
    
    return head;
}