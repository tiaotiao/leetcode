
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int placed = 0;
        
        for (int i = -1; i <= flowerbed.length; i++) {
            if (i < 0 || i >= flowerbed.length || flowerbed[i] == 0) {
                count++;
            } else {
                if (count > 2) {
                    placed += (count-1)/2;
                }
                count = 0;
            }
        }
        
        if (count >= 2) {
            placed += (count-1)/2;
        }
        
        return placed >= n;
    }
}