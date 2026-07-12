class Solution {
    public int[] pathExistenceQueries(int n, int[] a, int md, int[][] q) {
        long[] pk = new long[n];
        for (int i = 0; i < n; i++) {
            pk[i] = ((long) a[i] << 32) | i;
        }
        java.util.Arrays.sort(pk);
        
        int[] sv = new int[n];
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            sv[i] = (int) (pk[i] >> 32);
            p[(int) pk[i]] = i;
        }
        
        int lg = 18;
        int[][] st = new int[n][lg];
        int rt = 0;
        for (int i = 0; i < n; i++) {
            while (rt < n && sv[rt] <= sv[i] + md) {
                rt++;
            }
            st[i][0] = rt - 1;
        }
        
        for (int j = 1; j < lg; j++) {
            for (int i = 0; i < n; i++) {
                st[i][j] = st[st[i][j - 1]][j - 1];
            }
        }
        
        int[] r = new int[q.length];
        for (int i = 0; i < q.length; i++) {
            int u = q[i][0];
            int v = q[i][1];
            
            if (u == v) {
                r[i] = 0;
                continue;
            }
            
            int x = p[u];
            int y = p[v];
            if (x > y) {
                int t = x;
                x = y;
                y = t;
            }
            
            int c = x;
            int s = 0;
            
            for (int j = lg - 1; j >= 0; j--) {
                if (st[c][j] < y) {
                    c = st[c][j];
                    s += (1 << j);
                }
            }
            
            if (st[c][0] >= y) {
                r[i] = s + 1;
            } else {
                r[i] = -1;
            }
        }
        
        return r;
    }
}