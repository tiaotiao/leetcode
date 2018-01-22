
import java.util.*;

class MinStack {
    
        class Item {
            int value;
            int min;
            public Item(int v) {
                value = v;
                min = v;
            }
        }
        
        List<Item> s;
        
        /** initialize your data structure here. */
        public MinStack() {
            s = new ArrayList<Item>();
        }
        
        public void push(int x) {
            Item item = new Item(x);
            if (s.size() > 0) {
                item.min = Math.min(s.get(s.size()-1).min, x);
            }
            s.add(item);
        }
        
        public void pop() {
            if (s.size() <= 0) {
                return;
            }
            s.remove(s.size()-1);
        }
        
        public int top() {
            if (s.size() <= 0) {
                return 0;
            }
            Item item = s.get(s.size()-1);
            return item.value;
        }
        
        public int getMin() {
            if (s.size() <= 0) {
                return 0;
            }
            Item item = s.get(s.size()-1);
            return item.min;
        }
    }
    
    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */