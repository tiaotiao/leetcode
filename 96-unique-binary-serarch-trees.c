#include <stdio.h>
#include <stdlib.h>

int numTrees(int n) {
    if (n <= 1) {
        return 1;
    }
    
    int* p = (int*)malloc((n+1)*sizeof(int));
    
    
    p[0] = 1;
    p[1] = 1;
    
    for (int i = 2; i <= n; i++) {
        p[i] = 0;
        for (int j = 0; j < i; j++) {
            int k = i-j-1;
            p[i] += p[j] * p[k];
        }
    }
    
    int ans = p[n];
    free(p);
    
    return ans;
}

int main() {
    int tests[][2] = {
        {3, 5},
        {5, 42}
    };

    int m = sizeof(tests) / sizeof(int[2]);

    for (int i = 0; i < m; i++) {
        int n = tests[i][0];
        int e = tests[i][1];
        int ans = numTrees(n);
        if (ans != e) {
            printf("error %d: n=%d, ans=%d, expect=%d\n", i, n, ans, e);
        }
    }
    printf("Done");
}