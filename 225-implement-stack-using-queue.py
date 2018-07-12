
from collections import deque 

class MyStack:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.input = deque()
        self.output = deque() 

    def push(self, x):
        """
        Push element x onto stack.
        :type x: int
        :rtype: void
        """
        self.input.appendleft(x)

    def pop(self):
        """
        Removes the element on top of the stack and returns that element.
        :rtype: int
        """
        if self.empty():
            return None
        self._reload()

        x = self.input.pop()
        
        self.input, self.output = self.output, self.input

        return x

    def top(self):
        """
        Get the top element.
        :rtype: int
        """
        self._reload()
        if self.empty():
            return None
        return self.input[0]


    def empty(self):
        """
        Returns whether the stack is empty.
        :rtype: bool
        """
        size = len(self.input) + len(self.output)
        return size == 0
        
    def _reload(self):
        while len(self.input) > 1:
            x = self.input.pop()
            self.output.appendleft(x)


# Your MyStack object will be instantiated and called as such:
# obj = MyStack()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.top()
# param_4 = obj.empty()