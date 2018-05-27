---
title: 119 - Pascal's Triangle II
url: https://leetcode.com/problems/pascals-triangle-ii/
tags: [easy]
---

#### [Problem](https://leetcode.com/problems/pascals-triangle-ii/)

Given a non-negative index k where k <= 33, return the kth index row of the Pascal's triangle.

Example:

```
Input: 3
Output: [1,3,3,1]
```

Follow up:

Could you optimize your algorithm to use only **O(k) extra space**?

#### [Solution](https://github.com/tiaotiao/leetcode/blob/master/119-pascals-triangle-II.java)

Similar to previous problem ([118 - Pascal's Triangle](https://leetcode.com/problems/pascals-triangle/)), we can solve this problem by generating the whole triangle and only return the kth row of it.

We are gonna focus on the follow up question. The space for a whole triangle is (k*k)/2, which is O(k^2). 

Since each row only dependents on the previous row, we only need to keep the previous row to generate the next row. Everything before is useless.

The straightforward pseudo code for this idea is like this:

```java
prev = new ArrayList<>();   // empty
for (int i = 0; i <= k; i++) {
    row = new ArrayList<>();    // create a new array
    generate row i from prev
    prev = row; // discard previous row
}
```

Note that we create a new array and discard the previous one in each iteration. It looks like we only have two arrays in memory at the same time. But for the garbage collection mechanism in Java, the discarded variables are still keet in memory until the next garbage collection executed, which is not under our control. That's to say it may accumulate unused variables in memory for a period of time.

To avoid that, we can improve it by reusing the previous row for the next row. We keep two arrays in memory and keep rolling them in each iteration to represent previous row and current row alternatively.

```java
for (int i = 0; i <= k; i++) {
    exchange prev and row
    clear row
    generate row i from prev
}
```

This is my final solution:

```java
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>(rowIndex + 1);
        List<Integer> prev = new ArrayList<>(rowIndex + 1), tmp;

        for (int i = 0; i <= rowIndex; i++) {
            tmp = row;
            row = prev;
            prev = tmp;
            row.clear();
            for (int j = 0; j <= i; j++) {
                int val = 1;
                if (j != 0 && j != i) {
                    val = prev.get(j-1) + prev.get(j);
                }
                row.add(val);
            }
        }

        return row;
    }
}
```
