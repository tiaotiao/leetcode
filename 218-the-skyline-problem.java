

class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> results = new ArrayList<>();
        if (buildings.length == 0) return results;

        // creeate points
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < buildings.length; i++) {
            int[] b = buildings[i];
            points.add(new Point(i, b[0], b[2], true));
            points.add(new Point(i, b[1], b[2], false));
        }

        // sort
        Collections.sort(points, (a, b) -> (a.x != b.x ? a.x - b.x : 
            (a.start != b.start ? (a.start ? -1 : 1) : 
             (a.start ? b.y - a.y: a.y - b.y) )));

        PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> (b.y - a.y));
        Set<Integer> del = new HashSet<>(); 

        int currBuilding = -1;
        int currHeight = -1;
        int currPos = -1;
        for (Point p : points) {
            // System.out.printf(">> %d: %d %d %b\n", p.building, p.x, p.y, p.start);
            if (p.start) {
                // p is start point
                pq.add(p);
                if (p.y <= currHeight) {
                    continue;
                }

                // add a result
                if (!(results.size() > 0 && 
                (p.x == results.get(results.size()-1)[0] || 
                p.y == results.get(results.size()-1)[1]))) {
                    // results.remove(results.size() - 1);
                    results.add(new int[]{p.x, p.y});
                    // System.out.printf("----- [%d %d]\n", p.x, p.y);
                }
                
                currBuilding = p.building;
                currHeight = p.y;
                currPos = p.x;
            } else {
                // p is end point
                del.add(p.building);

                // remove from priority queue
                while (!del.isEmpty()) {
                    Point top = pq.peek();
                    if (del.contains(top.building)) {
                        del.remove(top.building);
                        pq.poll();
                    } else {
                        break;
                    }
                }
                
                // add a result
                if (p.building == currBuilding) {
                    Point top = pq.peek();
                    int y = 0;
                    if (top != null) {
                        y = top.y;
                    }


                    if (!(results.size() > 0 && 
                    (p.x == results.get(results.size()-1)[0] || 
                    y == results.get(results.size()-1)[1]))) {
                        // results.remove(results.size() - 1);
                        results.add(new int[]{p.x, y});
                        // System.out.printf("----- [%d %d]\n", p.x, y);
                    }

                }

                if (pq.isEmpty()) {
                    currBuilding = -1;
                    currHeight = 0;
                    currPos = -1;
                } else {
                    Point top = pq.peek();
                    currBuilding = top.building;
                    currHeight = top.y;
                    currPos = top.x;
                }

            }
        }
        return results;
    }

    class Point {
        int x, y;
        int building;
        boolean start;
        Point(int b, int x, int y, boolean s) {
            this.building = b;
            this.x = x; this.y = y;
            this.start = s;
        }
    }
}

