
class Solution:
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """

        count = {}  # count[course] = #pre
        pre = {}    # pre[p] = {courses}
        for e in prerequisites:
            c = e[0]
            p = e[1]
            if c not in pre:
                pre[c] = set()
                count[c] = 0
            if p not in pre:
                pre[p] = set()
                count[p] = 0

            pre[p].add(c)
            count[c] += 1
        
        # print(count, pre)

        remain = len(count)
        while remain > 0:
            removed = 0
            for c in count:
                if count[c] == 0:
                    removed += 1
                    count[c] = -1
                    remain -= 1

                    posts = pre[c]
                    for p in posts:
                        count[p] -=1
            if removed == 0:
                return False

        return True

def main():
    s = Solution()
    n = 2
    pre = [[1,0]] 
    print(s.canFinish(n, pre))

if __name__ == '__main__':
    main()