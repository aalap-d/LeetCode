import java.util.PriorityQueue;
class Solution {
    public int lastStoneWeight(int[] s) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int w : s) {
            pq.offer(w);
        }
        
        while (pq.size() > 1) {
            int y = pq.poll();
            int x = pq.poll();
            
            if (y > x) {
                pq.offer(y - x);
            }
        }
        
        return pq.isEmpty() ? 0 : pq.poll();
    }
}