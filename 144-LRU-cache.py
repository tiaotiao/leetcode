
class ListNode:
    def __init__(self, key, val):
        self.val = val
        self.key = key
        self.prev = None
        self.next = None

    def __str__(self):
        prev, next = None, None
        if self.prev:
            prev = self.prev.val
        if self.next:
            next = self.next.val
        s = " {}<{}:{}>{} ".format(prev, self.key, self.val, next)
        return s

class List:
    def __init__(self):
        self.head = ListNode(-1,-1)
        self.tail = self.head
        self.size = 0

    def pop(self):
        if self.size <= 0:
            return None
        
        popped = self.tail
        # print("  pop", popped)
        # self.tail = self.tail.prev
        self._break(popped)

        self.size -= 1
        return popped

    def promote(self, node):
        
        self._break(node)
        
        self._insert(self.head, node)

    def insertHead(self, key, val):
        node = ListNode(key, val)
        self._insert(self.head, node)
        self.size += 1
        return node

    def _break(self, node):
        prev = node.prev
        next = node.next

        prev.next = next
        if next:
            next.prev = prev
        node.prev, node.next = None, None
        if node == self.tail:
            self.tail = prev

    def _insert(self, prev, node):
        node.next = prev.next
        if node.next:
            node.next.prev = node
        node.prev = prev
        prev.next = node
        if self.tail == self.head:
            self.tail = node

    def __str__(self):
        prev = self.head
        node = self.head.next
        s = ""
        while node:
            s += str(node)
            if node.prev != prev:
                s += "<-! "
            prev = node
            node = node.next
        s = "{} head[{}] tail[{}]".format(s, self.head, self.tail)
        return s


class LRUCache:

    def __init__(self, capacity):
        """
        :type capacity: int
        """
        self.cap = capacity
        self.m = {}      # m[key] = ListNode
        self.l = List()

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        if key not in self.m:
            return -1
        
        val = self._visit(key)

        # print("get", key, val, self)
        return val
        

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: void
        """
        if key not in self.m:
            # insert new value
            if len(self.m) >= self.cap:
                self._pop()
            self._insert(key, value)
            
            # print("put", key, value, self)
            return
        # update value
        node = self.m[key]
        node.val = value
        self._visit(key)

        # print("put", key, value, self)

    def _visit(self, key):
        # move the node to the front of list
        node = self.m[key]
        self.l.promote(node)
        return node.val

    def _insert(self, key, value):
        node = self.l.insertHead(key ,value)
        self.m[key] = node

    def _pop(self):
        popped = self.l.pop()
        del self.m[popped.key]

    def __str__(self):
        ms = ""
        for key in self.m:
            node = self.m[key]
            ms += "{}:{} ".format(key, node.val)

        return "[{}], [{}]".format(ms, self.l)
        


# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)


def main():
    cap = 1
    cache = LRUCache(cap)

    # cache.put(1, 1)
    # cache.put(2, 2)
    # cache.get(1)
    # cache.put(3, 3)
    # cache.get(2)
    # cache.put(4, 4)
    # cache.get(1)
    # cache.get(3)
    # cache.get(4)

    cache.put(2, 1)
    cache.get(2)
    cache.put(3, 2)
    cache.get(2)
    cache.get(3)


if __name__ == '__main__':
    main()