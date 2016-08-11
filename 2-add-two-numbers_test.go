package leetcode

import (
	"fmt"
	"reflect"
	"testing"
)

func (l *ListNode) String() string {
	s := ""
	for l != nil {
		if s != "" {
			s += " -> "
		}
		s += fmt.Sprintf("%v", l.Val)
		l = l.Next
	}
	return s
}

func TestAddTwoNumber(t *testing.T) {

	initLink := func(l []int) *ListNode {
		var head, tail *ListNode
		for _, v := range l {
			head, tail = appendDigit(head, tail, v)
		}
		return head
	}

	l1 := initLink([]int{2, 4, 3})
	l2 := initLink([]int{5, 6, 4})
	a := initLink([]int{7, 0, 8})

	r := addTwoNumbers(l1, l2)

	if !reflect.DeepEqual(r, a) {
		t.Errorf("%s %s", l1, l2)
	}
}
