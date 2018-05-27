---
title: 118 - Pascal's Triangle
url: https://leetcode.com/problems/pascals-triangle/
tags: [easy, 2D-array]
---

#### [Problem](https://leetcode.com/problems/pascals-triangle/)


Given a non-negative integer numRows, generate the first numRows of Pascal's Triangle. 

In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:
```
Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
```

#### [Solution](https://github.com/tiaotiao/leetcode/blob/master/118-pascals-triangle.java)

This problem is very straightforward. We don't need any particular algorithm, but we still need to deal with the boundaries carefully.

To generate a triangle, we need two nested loops. The outer loop i takes control of the number row. And the inner loop j takes control of the index of the row. 

```java
for (int i = 0; i < numRows; i++) {
    for (int j = 0; j <= i; j++) {
        // generate the value at (i,j)
    }
}
```

Note that the inner loop j is end up with ```j <= i```. It's because the row number is start from 0, not 1. That's to say, the length of row i is i+1. For example, for the first row (i=0), the length for the row is 1. We can also rewrite it as ```j < i+1```.

Let's consider the value of (i, j). For each value in the triangle, there are only two cases: boundary or non-boundary. We know value of (i, j) is the sum of (i-1, j-1) and (i-1, j) by the definition, except the boundaries. To deal with the boundaries, we can simply use if condition.

```java
int val = 1;
if (i != 0 && i != 1        // first two rows
    && j != 0 && j != i) {  // beginning and end of the row is boundary
    // val(i, j) = (i-1, j-1) + (i-1, j)
}
```

Note the first two conditions ```i != 0 && i != 1```, are included in the last tow conditions. So we simplify it by removing the first two conditions:

```java
if (j != 0 && j != i) {     // beginning and end of the row is boundary
    // val(i, j) = (i-1, j-1) + (i-1, j)
}
``` 

This is my final solution:

```java
class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> tran = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                int val = 1;
                if (j != 0 && j != i) {
                    val = tran.get(i-1).get(j-1) + tran.get(i-1).get(j);
                }
                row.add(val);
            }
            tran.add(row);
        }

        return tran;
    }
}
```

For corner cases, we consider numRows equals to 0, 1 and 2. For numRows is 0, it wouldn't enter the for loop. So we will get a empty list, which is expected. For 1 and 2, the if statement will never be satisfied. That's to say all the values are 1, which is correct too.
