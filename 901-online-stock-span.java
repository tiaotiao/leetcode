
class StockSpanner {
    List<Item> stack;
    int counter;
    
    public StockSpanner() {
        stack = new ArrayList<>();
        counter = 0;
    }
    
    public int next(int price) {
        int index = counter ++;
        Item item = new Item(price, index);
        
        int prevIdx = -1;
        
        while (true && stack.size() > 0) {
            Item topItem = stack.get(stack.size() - 1);
            int top = topItem.val;
            
            if (top > price) {
                prevIdx = topItem.index;
                break;
            }
            
            stack.remove(stack.size() - 1);
        }
        
        stack.add(item);
        
        return index - prevIdx;
    }
    
    private class Item {
        int val;
        int index;
        Item(int val, int index) {
            this.val = val; this.index = index;
        }
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */