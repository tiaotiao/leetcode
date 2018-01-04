/*
https://leetcode.com/problems/combination-sum/description/

39. Combination Sum

Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[
  [7],
  [2, 2, 3]
]
*/

struct Item {
    int** combi;
    int* len;
    int size;
    int cap;
};

typedef struct Item* E;

E newItem() {
    E item = malloc(sizeof(struct Item));
    item->cap = 8;
    item->combi = malloc(item->cap * sizeof(int*));
    item->len = malloc(item->cap * sizeof(int));
    item->size = 0;
    return item;
}

void resizeItem(E item) {
    int cap = item->cap * 2;
    int** newCombi = malloc(cap * sizeof(int*));
    int* newLen = malloc(cap * sizeof(int));
    
    for (int i = 0; i < item->size; i++) {
        newCombi[i] = item->combi[i];
        newLen[i] = item->len[i];
    }
    
    free(item->combi);
    free(item->len);
    
    item->combi = newCombi;
    item->len = newLen;
    item->cap = cap;
}

void addCombination(E item, int* combi, int len) {
    if (item->size >= item->cap) {
        resizeItem(item);
    }
    int pos = item->size;
    item->combi[pos] = combi;
    item->len[pos] = len;
    item->size++;
}

int* createCombination(int* combi, int len, int candidate) {
    int* c = malloc((len+1) * sizeof(int));
    for (int i = 0; i < len; i++) {
        c[i] = combi[i];
    }
    c[len] = candidate;
    return c;
}

void combine(E destItem, E targetItem, int candidate) {
    for (int i = 0; i < destItem->size; i++) {
        int newLen = destItem->len[i] + 1;
        int* newCombi = createCombination(destItem->combi[i], destItem->len[i], candidate);
        addCombination(targetItem, newCombi, newLen);
    }
}

void freeItem(E item) {
    for (int i = 0; i < item->size; i++) {
        free(item->combi[i]);
    }
    if (item->size > 0) {
        free(item->combi);
        free(item->len);
    }
    free(item);
}

/**
 * Return an array of arrays of size *returnSize.
 * The sizes of the arrays are returned as *columnSizes array.
 * Note: Both returned array and *columnSizes array must be malloced, assume caller calls free().
 */
int** combinationSum(int* candidates, int candidatesSize, int target, int** columnSizes, int* returnSize) {
    E* a = malloc((target+1) * sizeof(E));
    for (int i = 0; i <= target; i++) {
        a[i] = newItem();
    }
    
    addCombination(a[0], NULL, 0);
    
    for (int k = 0; k < candidatesSize; k++) {
        for (int i = 0; i < target; i++) {
            int j = i + candidates[k];
            if (j > target) {
                break;
            }
            
            // add combinations [i] to [j]
            combine(a[i], a[j], candidates[k]);
        }
    }
    
    for (int i = 0; i < target; i++) {
        freeItem(a[i]);
    }
    
    *columnSizes = a[target]->len;
    *returnSize = a[target]->size;
    return a[target]->combi;
}
