

class Solution {
    
    private class Coord {
        int x, y;
        Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int n = image.length;
        int m = image[0].length;
        Coord[] dir = new Coord[]{
            new Coord(0, 1),
            new Coord(1, 0),
            new Coord(0, -1),
            new Coord(-1, 0)
        };
        
        Queue<Coord> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        
        int originColor = image[sr][sc];
        
        q.offer(new Coord(sr, sc));
        visited[sr][sc] = true;
        
        while(!q.isEmpty()) {
            Coord c = q.poll();
            image[c.x][c.y] = newColor;
            
            for (int k = 0; k < dir.length; k++) {
                int x = c.x + dir[k].x;
                int y = c.y + dir[k].y;
                
                if (x < 0 || n <= x || y < 0 || m <= y) {
                    continue;
                }
                if (visited[x][y]) {
                    continue;
                }
                if (image[x][y] != originColor) {
                    continue;
                }
                
                q.offer(new Coord(x, y));
                visited[x][y] = true;
            }
        }
        
        return image;
    }
}
