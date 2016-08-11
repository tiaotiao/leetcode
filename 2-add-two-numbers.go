/*
https://leetcode.com/problems/add-two-numbers/

2. Add Two Numbers

You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
*/

package leetcode

type ListNode struct {
	Val  int
	Next *ListNode
}

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {

	var carry int = 0
	var v = 0

	var head, tail *ListNode

	for true {
		if l1 == nil && l2 == nil {
			break
		}

		var v1, v2 int = 0, 0

		if l1 != nil {
			v1 = l1.Val
			l1 = l1.Next
		}
		if l2 != nil {
			v2 = l2.Val
			l2 = l2.Next
		}

		v = v1 + v2 + carry
		carry = v / 10
		digit := v % 10

		head, tail = appendDigit(head, tail, digit)
	}

	if carry > 0 {
		head, tail = appendDigit(head, tail, carry)
	}

	return head
}

func appendDigit(head, tail *ListNode, digit int) (*ListNode, *ListNode) {
	node := new(ListNode)
	node.Val = digit
	node.Next = nil

	if head == nil {
		head = node
		tail = node
		return head, tail
	}

	tail.Next = node
	tail = node
	return head, tail
}
