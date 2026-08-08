import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> shiftGrid(int[][] g, int k) {
        int m = g.length;
        int n = g[0].length;
        int t = m * n;
        k = k % t;
        
        List<List<Integer>> a = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> r = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                r.add(0);
            }
            a.add(r);
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int p = (i * n + j + k) % t;
                a.get(p / n).set(p % n, g[i][j]);
            }
        }
        
        return a;
    }
}