
class Solution {
    Set<Double> visited;
    Queue<Item> queue;
    int x, y, z;
    
    /// BFS TLE
    public boolean canMeasureWater(int x, int y, int z) {
        visited = new HashSet<>();
        queue = new LinkedList<>();
        this.x = x;
        this.y = y;
        this.z = z;
        
        if(visit(0, 0)) return true;
        
        while(queue.size() > 0) {
            Item item = queue.remove();
            
            if (item.p == z || item.q == z || item.p+item.q == z) return true;
            
            if (visit(item.p, 0)) return true;
            if (visit(0, item.q)) return true;
            
            if (visit(item.p, y)) return true;
            if (visit(x, item.q)) return true;
            
            int delta = pour(item.p, item.q, y);
            if (visit(item.p - delta, item.q + delta)) return true;
            
            delta = pour(item.q, item.p, x);
            if (visit(item.p + delta, item.q - delta)) return true;
        }
        
        return false;
    }
    
    private int pour(int s, int t, int cap) {
        int remain = cap - t;
        return Math.min(s, remain);
    }
    
    private boolean visit(int p, int q) {
        Item e = new Item(p, q);
        // System.out.printf("visit %d %d, %b\n", e.p, e.q, visited.contains(e.code()));
        if (e.p == z || e.q == z || e.p+e.q == z) return true;
        if (visited.contains(e.code())) return false;
        
        queue.add(e);
        visited.add(e.code());
        return false;
    }
    
    class Item {
        int p, q;
        Item(int p, int q) {
            this.p = p; this.q = q;
        }
        
        public double code() {
            if (y < x)
                return p * (y + 1.0) + q;
            else 
                return p + q * (x + 1.0);
        }
        
        // public String code() {
        //     return p + ";" + q;
        // }
    }
}