
class Solution:
    def maxDistToClosest(self, seats):
        n = len(seats)
        
        left_closest = [0] * n
        right_closest = [0] * n

        left, right = -1, -1
        for i in range(n):
            j = n - i - 1
            if seats[i] == 1: left = i
            if seats[j] == 1: right = j
            left_closest[i] = left
            right_closest[j] = right

        max_dist = -1
        for i in range(n):
            if seats[i] == 1:
                continue
            left = left_closest[i]
            right = right_closest[i]
            dist = min(i - left, right - i)
            if left < 0:
                dist = right - i
            if right < 0:
                dist = i - left
            if max_dist < dist:
                max_dist = dist
        return max_dist


def main():
    s = Solution()
    # seats = [1,0,0,0,1,0,1]
    seats = [1,0,0,0]
    print(s.maxDistToClosest(seats))

if __name__ == '__main__':
    main()