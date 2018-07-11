
from collections import deque

class Solution:
    def numBusesToDestination(self, routes, S, T):
        """
        :type routes: List[List[int]]
        :type S: int
        :type T: int
        :rtype: int
        """

        if S == T:
            return 0
        
        stops = {}
        trans = {}

        # build bus stops
        routeId = 0
        for r in routes:
            routeId += 1
            trans[routeId] = set() 
            for s in r:
                if s not in stops:
                    stops[s] = []
                stops[s].append(routeId)

        # connect routes
        for s in stops:
            rs = stops[s]
            for i in range(len(rs)):
                for j in range(i+1, len(rs)):
                    # connect two routes
                    r1 = rs[i]
                    r2 = rs[j]
                    trans[r1].add(r2)
                    trans[r2].add(r1)

        if S not in stops: return -1
        if T not in stops: return -1

        # add virtual start and target route
        vs, vt = 0, len(routes) + 1
        trans[vs], trans[vt] = set(), set()
        for r in stops[S]:
            trans[vs].add(r)
        for r in stops[T]:
            trans[r].add(vt)
        
        # do BFS to find a transfor
        queue = deque()
        queue.append(vs)
        visited = {vs:0}

        while len(queue) > 0:
            r = queue.popleft()
            distance = visited[r]

            for t in trans[r]:
                if t in visited:
                    continue
                if t == vt:
                    return distance
                visited[t] = distance + 1
                queue.append(t)
        
        return -1


def main():
    s = Solution()

    routes = [[1, 2, 7], [3, 6, 7]]
    S = 1
    T = 6

    print(s.numBusesToDestination(routes, S, T))

if __name__ == '__main__':
    main()



        



                    
        
        

