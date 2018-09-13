

class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> results = new ArrayList<>();
        
        int n = nums1.length;
        int m = nums2.length;
        if (n == 0 || m == 0) return results;
        
        boolean[][] visited = new boolean[n][m];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.val - b.val));
        pq.add(new Pair(0, 0, nums1[0] + nums2[0]));
        visited[0][0] = true;

        // BFS
        while (pq.size() > 0 && k > 0) {
            Pair p = pq.remove();
            int i = p.i, j = p.j;
            
            results.add(new int[]{nums1[i], nums2[j]});
            
            // extend i, j
            if (i+1 < n && !visited[i+1][j]) {
                pq.add(new Pair(i+1, j, nums1[i+1] + nums2[j]));
                visited[i+1][j] = true;
            }
            if (j+1 < m && !visited[i][j+1]) {
                pq.add(new Pair(i, j+1, nums1[i] + nums2[j+1]));
                visited[i][j+1] = true;
            }
            
            k -= 1;
        }

        return results;
    }
    
    class Pair {
        int val;
        int i, j;
        Pair(int i, int j, int val) {
            this.i = i; this.j = j; this.val = val;
        }
    }
}