
class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        
        PriorityQueue<Item> pq = new PriorityQueue<>((a, b) -> (a.val - b.val));
        
        int minVal = Integer.MAX_VALUE, maxVal = Integer.MIN_VALUE;
        int rangeMin, rangeMax;
        
        // init
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> list = nums.get(i);
            int val = list.get(0);
            minVal = Math.min(minVal, val);
            maxVal = Math.max(maxVal, val);
            
            pq.add(new Item(val, i, 0));
        }
        
        rangeMin = minVal;
        rangeMax = maxVal;
        
        // solve
        while (pq.size() > 0) {
            Item item = pq.poll();
            minVal = item.val;
            if (maxVal - minVal < rangeMax - rangeMin || (
            maxVal - minVal == rangeMax - rangeMin && minVal < rangeMin)) {
                rangeMin = minVal;
                rangeMax = maxVal;
            }
            
            int listId = item.listId;
            List<Integer> list = nums.get(item.listId);
            int index = item.index + 1;
            if (list.size() <= index) break;
            
            int next = list.get(index);
            maxVal = Math.max(maxVal, next);
            item = new Item(next, listId, index);
            
            pq.add(item);
        }
        
        return new int[]{rangeMin, rangeMax};
    }
    
    class Item {
        int val;
        int listId, index;
        Item(int v, int l, int idx) {
            val = v; listId = l; index = idx;
        }
    }
}