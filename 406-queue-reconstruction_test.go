package leetcode

import "testing"
import "reflect"

func Test406QueueReconstruction(t *testing.T) {
    queue := [][]int{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}}
    r := [][]int{{5, 0}, {7, 0}, {5, 2}, {6, 1}, {4, 4}, {7, 1}}
    
    a := reconstructQueue(queue)

    if !reflect.DeepEqual(r, a) {
        t.Error(a)
    }
}