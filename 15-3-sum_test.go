package leetcode

import "testing"
import "reflect"

func Test15_3Sum(t *testing.T) {
    cases := []struct{
       input []int
       output [][]int
    }{
        {
            []int{-1, 0, 1, 2, -1, -4},
            [][]int{
                {-1, 0, 1},
                {-1, -1, 2},
            },
        },
        {
            []int{0, 0, 0, 0},
            [][]int{
                {0, 0, 0},
            },
        },
        {
            []int{-2,0,1,1,2},
            [][]int{
                {-2, 1, 1},
                {-2, 0, 2},
            },
        },
    }
    
    for _, c := range cases {
        result := threeSum(c.input)
        if !reflect.DeepEqual(result, c.output) {
            t.Error(result, "!=", c.output)
        }
    }
}