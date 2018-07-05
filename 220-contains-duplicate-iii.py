
class Solution:
    def containsNearbyAlmostDuplicate(self, nums, k, t):
        """
        :type nums: List[int]
        :type k: int
        :type t: int
        :rtype: bool
        """
        tree = RangeTree()

        for i in range(len(nums)):
            num = nums[i]
            j = i - k - 1
            if j >= 0:
                tree.delete(nums[j])
            

            low = num - t
            high = num + t
            if tree.search(low, high):
                return True

            tree.insert(num)

            print(i, num)
            print(tree.root)

        return False


# tree node for range search
class Node:
    def __init__(self, val):
        self.val = val
        self.low = val
        self.high = val
        self.count = 1
        self.left = None
        self.right = None

    def __str__(self):
        return "[val:{},{} ({}-{})] left:{} right:{}".format(self.val, self.count, self.low, self.high, self.left, self.right)

# range tree
class RangeTree:
    def __init__(self):
        self.root = None
    
    def insert(self, val):
        if not self.root:
            self.root = Node(val)
            return
        self.__insert(self.root, val)

    def __insert(self, node, val):
        if not node:
            return

        if node.val == val:
            node.count += 1
        
        if node.low == None or val < node.low:
            node.low = val
        if node.high == None or node.high < val:
            node.high = val

        if val < node.val:
            if not node.left:
                node.left = Node(val)
            else:
                self.__insert(node.left, val)
        if node.val < val:
            if not node.right:
                node.right = Node(val)
            else:
                self.__insert(node.right, val)

    # search if is there an element within the range of [low, high]
    def search(self, low, high):
        return self.__search(self.root, low, high)

    def __search(self, node, low, high):
        if not node or node.low == None or node.high == None:
            return False
        # print("------search", low, high, ":", node.val, node.low, node.high)
        if node.count > 0 and low <= node.val and node.val <= high:
            return True
        if low <= node.low and node.low <= high:
            return True
        if low <= node.high and node.high <= high:
            return True
        if high < node.low or node.high < low:
            return False
        
        left, right = False, False
        if low <= node.val:
            left = self.__search(node.left, low, high)
        if node.val <= high:
            right = self.__search(node.right, low, high)
        
        return left or right

    def delete(self, val):
        self.__delete(self.root, val)

    def __delete(self, node, val):
        if not node:
            return None
        if node.val == val:
            node.count -= 1
        if val < node.val:
            self.__delete(node.left, val)
        if node.val < val:
            self.__delete(node.right, val)

        low = None
        if node.left and node.left.low != None:
            low = node.left.low
        elif node.count > 0:
            low = node.val
        elif node.right and node.right.low != None:
            low = node.right.low

        high = None
        if node.right and node.right.high != None:
            high = node.right.high
        elif node.count > 0:
            high = node.val
        elif node.left and node.left.high != None:
            high = node.left.high

        node.low = low
        node.high = high

        return node



def main():
    s = Solution()
    
    nums = [1,5,9,1,5,9]
    k = 2
    t = 3

    print(s.containsNearbyAlmostDuplicate(nums, k, t))


if __name__ == '__main__':
    main()