



class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        return solution_binary_guess(matrix, k);
    }

    /////////////////////////////////////////////////////
    // binary guess
    // O((m+n)log(int))
    private int solution_binary_guess(int[][] matrix, int k) {
        int n = matrix.length;
        if (n == 0) return 0;
        int m = matrix[0].length;
        if (m == 0) return 0;

        int min = matrix[0][0];
        int max = matrix[n-1][m-1];

        while (min < max) {
            int mid = (min + max) / 2;
            int less = search_matrix(matrix, mid);
            boolean found = true;
            if (less < 0) {
                found = false;
                less = -less - 1;
            }
            if (less == k && found) return mid;
            if (less == k) max = mid - 1;
            if (less < k) min = mid + 1;
            if (k < less) max = mid;
        }
        return min;
    }

    private int search_matrix(int[][] matrix, int val) {
        int n = matrix.length;
        int m = matrix[0].length;

        int less = 0;
        boolean found = false;  

        int j = m-1;
        for (int i = 0; i < n; i++) {
            while (j > 0) {
                if (matrix[i][j] == val) {
                    found = true;
                    less += j + 1;
                    j -= 1;
                    break;
                }
                if (matrix[i][j] < val) {
                    less += j + 1;
                    break;
                }
                j -= 1;
            }
            if (j < 0) break;
        }

        if (!found) less = -less - 1;
        return less;
    }

    /////////////////////////////////////////////////////
    // Priority Queue
    // O(klog(k))
    private int solution_priority_queue(int[][] matrix, int k) {
        int n = matrix.length;
        if (n == 0) return 0;
        int m = matrix[0].length;
        if (m == 0) return 0;

        PriorityQueue<Item> pq = new PriorityQueue<Item>((a, b) -> (a.val - b.val));
        boolean[][] visited = new boolean[n][m];

        // init
        pq.add(new Item(matrix[0][0], 0, 0));
        visited[0][0] = true;

        Item item = null;
        while (k > 0) {
            item = pq.poll();
            // System.out.println("Pop " + item.val);
            int[][] dirs = {{0,1}, {1,0}};
            for (int[] d : dirs) {
                int x = item.x + d[0];
                int y = item.y + d[1];
                if (n <= x) continue;
                if (m <= y) continue;
                if (visited[x][y]) continue;
                pq.add(new Item(matrix[x][y], x, y));
                visited[x][y] = true;
                // System.out.println("Add " + matrix[x][y]);
            }
            k -= 1;
        }
        return item.val;
    }

    class Item {
        int val;
        int x, y;
        Item(int val, int x, int y) {
            this.val = val; this.x = x; this.y = y;
        }
    }
}