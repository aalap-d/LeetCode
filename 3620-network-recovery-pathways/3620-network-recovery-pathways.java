import java.util.*;

class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;
        int l = 0, r = 0, m, ans = -1;

        for (int[] e : edges) {
            r = Math.max(r, e[2]);
        }
        
        while (l <= r) {
            m = l + (r - l) / 2;
            if (check(n, edges, online, k, m)) {
                ans = m;      
                l = m + 1;
            } else {
                r = m - 1;     
            }
        }
        return ans;
    }

    private boolean check(int n, int[][] edges, boolean[] online, long k, int m) {
        List<List<int[]>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int c = e[2];

            if (c >= m && (v == n - 1 || online[v])) {
                g.get(u).add(new int[]{v, c});
            }
        }

        long[] d = new long[n];
        Arrays.fill(d, Long.MAX_VALUE);
        d[0] = 0L;

        PriorityQueue<long[]> q = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        q.offer(new long[]{0, 0});

        while (!q.isEmpty()) {
            long[] curr = q.poll();
            int u = (int) curr[0];
            long w = curr[1];

            if (w > d[u]) {
                continue;
            }
            
            if (u == n - 1) {
                return w <= k;
            }

            for (int[] e : g.get(u)) {
                int v = e[0];
                int c = e[1];
                if (d[u] + c < d[v]) {
                    d[v] = d[u] + c;
                    q.offer(new long[]{v, d[v]});
                }
            }
        }
        
        return d[n - 1] <= k;
    }
}