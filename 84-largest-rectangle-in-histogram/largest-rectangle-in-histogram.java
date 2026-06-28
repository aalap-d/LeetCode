import java.util.*;

class Solution {
    public int largestRectangleArea(int[] h) {
        int n = h.length, res = 0;
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i <= n; i++) {
            int v = (i == n) ? 0 : h[i];
            while (!s.isEmpty() && v < h[s.peek()]) {
                int ht = h[s.pop()];
                int w = s.isEmpty() ? i : i - s.peek() - 1;
                res = Math.max(res, ht * w);
            }
            s.push(i);
        }
        return res;
    }
}