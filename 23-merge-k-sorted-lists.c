/*
https://leetcode.com/problems/merge-k-sorted-lists/description/

23. Merge k Sorted Lists

Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
*/


struct ListNode {
    int val;
    struct ListNode *next;
};

typedef struct ListNode* Node;

void heapifyUp(Node* heap, int position) {
    Node x = heap[position];
    while(position > 1) {
        int parent = position / 2;
        if (heap[parent]->val <= x->val) {
            break;
        }
        
        heap[position] = heap[parent];
        position = parent;
    }
    heap[position] = x;
}

void heapifyDown(Node* heap, int size, int position) {
    Node x = heap[position];
    while(position <= size / 2) {
        int left = position * 2;
        int right = position * 2 + 1;
        int child = left;
        if (right <= size && heap[left]->val > heap[right]->val) {
            child = right;
        }
        
        if (x->val <= heap[child]->val) {
            break;
        }
        
        heap[position] = heap[child];
        position = child;
    }
    heap[position] = x;
}

void heapInsert(Node p, Node* heap, int size) {
    heap[size+1] = p;
    heapifyUp(heap, size+1);
}

Node heapPop(Node* heap, int size) {
    if (size <= 0) {
        return NULL;
    }
    
    Node x = heap[1];
    heap[1] = heap[size--];
    
    if (size > 1) {
        heapifyDown(heap, size, 1);
    }
    return x;
}


struct ListNode* mergeKLists(struct ListNode** lists, int listsSize) {
    if (listsSize <= 0) {
        return NULL;
    }
    
    Node head = NULL, p = NULL;
    
    Node* heap = malloc((listsSize+1) * sizeof(Node));
    int heapSize = 0;
    for (int i = 0; i < listsSize; i++) {
        if (lists[i] != NULL) {
            heapInsert(lists[i], heap, heapSize++);
        }
    }
    
    while(1) {
        Node minNode = NULL;
        int minIdx = 0;
        
        /*
        for (int i = 0; i < listsSize; i++) {   // use heap to improve performance
            if (lists[i] != NULL && (minNode == NULL || minNode->val > lists[i]->val)) {
                minNode = lists[i];
                minIdx = i;
            }
        }
        */
        minNode = heapPop(heap, heapSize--);
        
        if (minNode == NULL) {
            break;
        }
        
        //lists[minIdx] = minNode->next;
        if (minNode->next != NULL) {
            heapInsert(minNode->next, heap, heapSize++);
        }
        
        if (head == NULL) {
            head = minNode;
            p = minNode;
        } else {
            p->next = minNode;
            p = p->next;
        }
    }
    
    return head;
}