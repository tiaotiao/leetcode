
class Job:
    def __init__(self, diff, prof):
        self.diff = diff
        self.prof = prof

class Solution:
    def maxProfitAssignment(self, difficulty, profit, worker):
        """
        :type difficulty: List[int]
        :type profit: List[int]
        :type worker: List[int]
        :rtype: int
        """
        
        n = len(difficulty)
        if n <= 0:
            return 0
        if len(profit) != n:
            return None
        
        m = len(worker)
        if m <= 0:
            return 0

        jobs = []
        for i in range(n):
            d = difficulty[i]
            p = profit[i]
            job = Job(d, p)
            jobs.append(job)

        # sort jobs by difficulty
        jobs.sort(key=lambda job: job.diff)

        # sort workers by ablity
        worker.sort()

        total = 0

        j = 0
        profit = 0
        for w in worker:
            while j < n:
                job = jobs[j]
                if w < job.diff:
                    break
                
                if profit < job.prof:
                    profit = job.prof
                j += 1
            total += profit
        return total


def main():
    s = Solution()

    d = [2,4,6,8,10]
    p = [10,20,30,40,50]
    w = [4,5,6,7]

    print(s.maxProfitAssignment(d, p, w))

if __name__ == '__main__':
    main()
