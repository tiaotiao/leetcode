

class Solution:

    def calculateMinimumHP(self, dungeon):
        """
        :type dungeon: List[List[int]]
        :rtype: int
        """
        if dungeon == None:
            return None
        n = len(dungeon)
        if n == 0: return None
        m = len(dungeon[0])
        if m == 0: return None

        minHP = 1
        maxHP = 1
        for i in range(n):
            for j in range(m):
                if dungeon[i][j] < 0:
                    maxHP += -dungeon[i][j]
        
        while minHP < maxHP:
            HP = (maxHP + minHP) // 2
            ok = self.fight(dungeon, n, m, HP)
            # print(ok, "min", minHP, "max", maxHP, "HP", HP)
            if ok:
                maxHP = HP
            else:
                minHP = HP + 1

        return minHP
        

    def fight(self, dungeon, n, m, HP):
        """
        try to go through dungeon with HP
        return whether the find grid is reachable
        """
        # dp[i][j] is the max hp when reaching the grid[i][j].
        dp = [[None for j in range(m)] for i in range(n)]  # init a 2d-array with n rows and m columns

        for i in range(n):
            for j in range(m):
                if i == 0 and j == 0:
                    dp[i][j] = dungeon[i][j]
                    if dp[i][j] + HP <= 0:
                        return False
                    continue

                fromLeft, fromTop = None, None
                if i > 0 and dp[i-1][j] != None:
                    fromTop = dp[i-1][j] + dungeon[i][j]
                if j > 0 and dp[i][j-1] != None:
                    fromLeft = dp[i][j-1] + dungeon[i][j]
                
                value = self.max(fromLeft, fromTop)
                
                if value != None and value + HP > 0:
                    dp[i][j] = value
        
        # print("DP", dp)
        if dp[n-1][m-1] == None:
            return False

        return True


    def max(self, left, top):
        if left == None:
            return top
        if top == None:
            return left
        if left < top:
            return top
        return left
        

def main():
    s = Solution()
    d = [[-2,-3,3],[-5,-10,1],[10,30,-5]]
    print(s.calculateMinimumHP(d))

if __name__ == '__main__':
    main()