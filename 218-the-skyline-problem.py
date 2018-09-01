
import heapq

class PriorityQueue:
    def __init__(self):
        self._queue = []
        self._index


class Solution:
    def getSkyline(self, buildings):
        pass

        lines = []      #List[(pos, height, id, isStart)]
        for i in range(len(buildings)):
            left, right, height = buildings[i]
            lines.append((left, height, i, True))
            lines.append((right, height, i, False))

        lines.sort(key=lambda l:l[0])
        
        skylines = []
        platform = 0
        platform_id = None
        heap = []
        deleted = set()
        for line in lines:
            pos, height, line_id, start = line
            if not start:
                if platform_id == line_id:
                    # TODO remove
                    # remove marked buildings
                    pass
                else:
                    deleted.add(line_id)
                    # mark as deleted
                    pass
                continue

            # TODO heap.insert(height)

            if height <= platform:
                continue

            platform = height
            platform_id = line_id

            skylines.append((pos, platform))


    # -----------------------------------------------

    def _wrong_answer(self, buildings):
        """
        :type buildings: List[List[int]]
        :rtype: List[List[int]]
        """

        lines = []  # List[(pos, low, high)]

        buildings.sort(key=lambda b: b[1])

        for b in buildings:
            left, right, height = b
            self.insert(lines, left, right, height)

        return self.to_answer(lines)

    def to_answer(self, lines):
        platform = 0
        results = []
        for line in lines:
            x, l, h = line
            if l < 0 or h < 0: continue
            platform = self.next_platform(platform, l, h)
            results.append((x, platform))
        return results

    def insert(self, lines, left, right, height):
        idx = 0
        low = 0
        high = height
        visible = True
        current_platform = 0
        overlap_left = False
        overlap_right = False
        delete_idx = []

        if len(lines) > 0 and lines[-1][0] == right:
            overlap_right = True
            if lines[-1][2] >= height:
                visible = False

        # modify
        for i in range(len(lines) - 1, -1, -1):
            x, l, h = lines[i]

            if x < left:
                # print("insert idx: ", i + 1, x, left)
                idx = i + 1
                break

            if l < 0 or h < 0:
                continue

            current_platform = self.next_platform(current_platform, l, h)

            if h <= height:             # above a building
                lines[i] = (x, -1, -1)  # mark the building to be deleted
                delete_idx.append(i)
                low = current_platform
                visible = True          # go visible
                continue
            if height <= l:         # below a building
                low = -1
                visible = False     # go invisible
                continue        

            # l < height < h            # cross a building
            if visible or x > left:
                lines[i] = (x, height, h)   # cut off the line
            
            visible = not visible       # change inviaible
            if visible:
                low = current_platform

            if x == left:
                overlap_left = True

        # delete lines
        for i in delete_idx:
            del lines[i]

        # insert
        if not visible:
            return
        lines.insert(idx, (left, low, high))
        # print("insert -------------------", idx, ":", left, ",", low, high)
        # print(lines)
        

        
    def next_platform(self, curr, low, high):
        if curr == low:
            return high
        if curr == high:
            return low
        return None # exception


def main():
    s = Solution()

    buildings = [ [2, 9, 10], [3, 7, 15], [5, 12, 12], [15, 20, 10], [19, 24, 8] ]

    # buildings = [ [2, 12, 10], [3, 7, 15], [3, 12, 12], [15, 20, 10], [15, 24, 8] ]

    # buildings = [[2,4,7],[2,4,5],[2,4,6]]

    print(s.getSkyline(buildings))


if __name__ == '__main__':
    main()
