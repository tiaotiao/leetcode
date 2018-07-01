

class Solution:
    def lemonadeChange(self, bills):
        """
        :type bills: List[int]
        :rtype: bool
        """
        
        cash = {5:0, 10:0, 20:0}

        for bill in bills:
            ok = self.change(cash, bill)
            # print(bill, ok, cash)
            if not ok:
                return False
        return True

    def change(self, cash, bill):
        cash[bill] += 1

        if bill == 5:
            return True
        
        if bill == 10:
            if cash[5] <= 0:
                return False
            cash[5] -= 1
            return True

        # bill == 20
        if cash[10] > 0:
            if cash[5] <= 0:
                return False
            cash[10] -= 1
            cash[5] -= 1
            return True
        
        if cash[5] < 3:
            return False

        cash[5] -= 3
        return True

def main():
    s = Solution()

    bills = [5,5,5,10,20]
    print(s.lemonadeChange(bills))

if __name__ == '__main__':
    main()