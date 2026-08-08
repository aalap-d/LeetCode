import java.util.*;

class Solution {
    public int minScore(int n, int[][] r) {
        List<List<int[]>> a = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            a.add(new ArrayList<>());
        }
        for (int[] x : r) {
            a.get(x[0]).add(new int[]{x[1], x[2]});
            a.get(x[1]).add(new int[]{x[0], x[2]});
        }
        
        Queue<Integer> q = new LinkedList<>();
        boolean[] v = new boolean[n + 1];
        q.offer(1);
        v[1] = true;
        int m = Integer.MAX_VALUE;
        
        while (!q.isEmpty()) {
            int c = q.poll();
            for (int[] e : a.get(c)) {
                m = Math.min(m, e[1]);
                if (!v[e[0]]) {
                    v[e[0]] = true;
                    q.offer(e[0]);
                }
            }
        }
        
        return m;
    }
}