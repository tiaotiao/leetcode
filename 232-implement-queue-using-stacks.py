
class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.head = []
        self.tail = []

    def push(self, x):
        """
        Push element x to the back of queue.
        :type x: int
        :rtype: void
        """
        self.tail.append(x)

    def pop(self):
        """
        Removes the element from in front of queue and returns that element.
        :rtype: int
        """
        self._reload()
        if self.empty():
            return None
        return self.head.pop()
        

    def peek(self):
        """
        Get the front element.
        :rtype: int
        """
        self._reload()
        if self.empty():
            return None
        return self.head[-1]

    def empty(self):
        """
        Returns whether the queue is empty.
        :rtype: bool
        """
        size = len(self.head) + len(self.tail)
        return size == 0

    def _reload(self):
        if len(self.head) > 0:
            return
        while len(self.tail) > 0:
            v = self.tail.pop()
            self.head.append(v)


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()