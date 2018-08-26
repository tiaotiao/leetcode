

class FreqStack {

    PriorityQueue<Item> pq;
    Map<Integer, Integer> map;
    int order;

    public FreqStack() {
        order = 0;
        pq = new PriorityQueue<>((a, b) -> (a.freq == b.freq ? b.order - a.order : b.freq - a.freq));
        map = new HashMap<>();
    }
    
    public void push(int x) {
        int freq = 1 + map.getOrDefault(x, 0);
        map.put(x, freq);
        
        pq.add(new Item(x, freq, order++));
    }
    
    public int pop() {
        Item item = pq.poll();
        int freq = map.get(item.x);
        map.put(item.x, freq - 1);
        return item.x;
    }

    ////////////////////
    class Item {
        int x;
        int freq;
        int order;
        Item(int x, int freq, int order) {
            this.x = x; this.freq = freq; this.order = order;
        }
    }
}

