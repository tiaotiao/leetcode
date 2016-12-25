package leetcode 

import "testing"

func Test42TrappingRainWater(t *testing.T) {
    heights := [][]int{
        {0,1,0,2,1,0,1,3,2,1,2,1},
        {5,2,1,2,1,5},
        
        {1},
        {3, 2, 1},
        {1, 2, 3},
        {1, 3, 2},
        {1, 1, 1},
        {3, 2},
        {3, 1, 2},
    }
    
    results := []int{
        6,
        14,
        
        0,
        0,
        0,
        0,
        0,
        0,
        1,
    }
    
    for i, height := range heights {
        a := trap(height)
        if a != results[i] {
            t.Error(i, a, results[i])
        }
    }
}