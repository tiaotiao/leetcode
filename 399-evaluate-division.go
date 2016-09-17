/*
https://leetcode.com/problems/evaluate-division/

399. Evaluate Division  

Total Accepted: 1548
Total Submissions: 4512
Difficulty: Medium

Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.

Example:
Given a / b = 2.0, b / c = 3.0. 
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? . 
return [6.0, 0.5, -1.0, 1.0, -1.0 ].

The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries , where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.

According to the example above:

equations = [ ["a", "b"], ["b", "c"] ],
values = [2.0, 3.0],
queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]. 
The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.
*/

package leetcode

func calcEquation(equations [][]string, values []float64, queries [][]string) []float64 {
    n := 0
    idx := make(map[string]int)
    for _, eq := range equations {
        for _, a := range eq {
            if _, ok := idx[a]; !ok {
                idx[a] = n
                n += 1
            }
        }
    }
    
    m := make([][]float64, n)
    
    invalid := -101010.10101
    for i := 0; i < n; i++ {
        m[i] = make([]float64, n)
        for j := 0; j < n; j++ {
            m[i][j] = invalid
        }
    }
    
    for i, eq := range equations {
        a, b := eq[0], eq[1]
        m[idx[a]][idx[b]] = values[i]
        m[idx[b]][idx[a]] = 1 / values[i]
    }
    
    for k := 0; k < n; k++ {
        for i := 0; i < n; i++ {
            if i == k || m[i][k] == invalid {
                continue
            }
            for j := 0; j < n; j++ {
                if j == k ||  m[k][j] == invalid {
                    continue
                }
                if m[i][j] == invalid {
                    m[i][j] = m[i][k] * m[k][j]
                }
            }
        }
    }
    
    answers := make([]float64, 0, len(queries))
    for _, qu := range queries {
        a, b := qu[0], qu[1]
        var i, j int
        var ok bool
        if i, ok = idx[a]; !ok {
            answers = append(answers, -1)
            continue
        }
        if j, ok = idx[b]; !ok {
            answers = append(answers, -1)
            continue
        }
        if m[i][j] == invalid {
            answers = append(answers, -1)
            continue
        }
        answers = append(answers, m[i][j])
    }
    
    return answers
}
