package leetcode

import (
    "testing"
    "reflect"
)

func TestEvaluateDivision(t *testing.T) {
    e := [][]string{{"a","b"},{"b","c"}}
    v := []float64{2.0, 3.0}
    q := [][]string{{"a","c"},{"b","a"},{"a","e"},{"a","a"}, {"x","x"}}
    
    r := []float64{6.0, 0.5, -1.0, 1.0, -1.0}
    
    a := calcEquation(e, v, q)
    
    if !reflect.DeepEqual(a, r) {
        t.Errorf("%v", a)
    }
}