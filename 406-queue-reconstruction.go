/*
https://leetcode.com/contest/6/problems/queue-reconstruction-by-height/

406. Queue Reconstruction by Height

User Accepted: 247
User Tried: 300
Total Accepted: 256
Total Submissions: 614
Difficulty: Medium

Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.

Note:
The number of people is less than 1,100.

Example

Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
*/

package leetcode 

import "sort"

func reconstructQueue(people [][]int) [][]int {
    sortedPeople := sortableQueue(people)
    sort.Sort(sortedPeople)
    
    queue := make([][]int, 0, len(people))
    
    insert := func(queue [][]int, p []int) [][]int {
        queue = append(queue, nil)
        pos := p[1]
        for i := len(queue) - 1; i > pos; i-- {
            queue[i] = queue[i-1]
        }
        queue[pos] = p
        return queue
    }
    
    for _, p := range sortedPeople {
        queue = insert(queue, p)
    }
    
    return queue
}

type sortableQueue [][]int

func (q sortableQueue) Len() int {
    return len(q)
}

func (q sortableQueue) Less(i, j int) bool {
    if q[i][0] == q[j][0] {
        return q[i][1] < q[j][1]
    }
    return q[i][0] > q[j][0]
}

func (q sortableQueue) Swap(i, j int) {
    q[i], q[j] = q[j], q[i]
}