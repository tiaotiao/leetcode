

class Solution:
    def canCompleteCircuit(self, gas, cost):
        """
        :type gas: List[int]
        :type cost: List[int]
        :rtype: int
        """
        
        n = len(gas)
        total = 0
        diff = []
        for i in range(n):
            d = gas[i] - cost[i]
            diff.append(d)
            total += d
        
        if total < 0:
            return -1

        start = 0
        while start < n:
            tank = 0
            i = 0
            while i < n:
                idx = (start + i) % n
                tank += diff[idx]
                if tank < 0:
                    break
                i += 1
            if tank < 0:
                start += i + 1
                continue
            return start
        return -1


def main():
    s = Solution()

    gas  = [1,2,3,4,5]
    cost = [3,4,5,1,2]

    print(s.canCompleteCircuit(gas, cost))

if __name__ == '__main__':
    main()