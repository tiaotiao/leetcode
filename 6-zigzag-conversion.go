/*
https://leetcode.com/problems/zigzag-conversion/

6. ZigZag Conversion 

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R

And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);

convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

DISCUSS: If you are confused with zigzag pattern,come and see!
https://discuss.leetcode.com/topic/22925/if-you-are-confused-with-zigzag-pattern-come-and-see
*/


package leetcode

func convert(s string, numRows int) string {
    length := len(s)
    
    z := 0
    if numRows >= 3 {
        z = numRows - 2
    }
    
    m := numRows + z
    
    columns := (length / m) * (z + 1)
    if (length % m) > 0 {
        columns += 1
    }
    if (length % m) > numRows {
        columns += (length % m) - numRows
    }
    
    // println(m, columns, z)
    
    var result = ""
    var idx int
    
    for i := 0; i < numRows; i++ {
        for j := 0; j < columns; j++ { 
            x := j % (z+1)
            
            if (x == 0) { // vertical line
                idx = i + ((j/(z+1)) * m)
                if idx >= length {
                    continue
                }
                //println(".", idx, s[idx:idx+1], i, j)
                result += s[idx:idx+1]
                
            } else { // zigzag line
                h := numRows - 1 - x
                if numRows == 1 {
                    h = 0
                }
                if (i != h) {
                    continue
                }
                idx = x + ((j/(z+1)) * m) + numRows - 1
                if idx >= length {
                    continue
                }
                //println("-", idx, s[idx:idx+1], i, j, x, h)
                result += s[idx:idx+1]
            }
        }
    }
    
    return result
}
