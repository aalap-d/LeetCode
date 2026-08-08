class Solution {
    public int[] gcdValues(int[] u, long[] q) {
        int m = 0;
        for (int x : u) {
            if (x > m) m = x;
        }
        
        int[] c = new int[m + 1];
        for (int x : u) {
            c[x]++;
        }
        
        long[] g = new long[m + 1];
        for (int i = m; i >= 1; i--) {
            long s = 0;
            for (int j = i; j <= m; j += i) {
                s += c[j];
            }
            g[i] = s * (s - 1) / 2;
            for (int j = i * 2; j <= m; j += i) {
                g[i] -= g[j];
            }
        }
        
        long[] p = new long[m + 1];
        for (int i = 1; i <= m; i++) {
            p[i] = p[i - 1] + g[i];
        }
        
        int l = q.length;
        int[] a = new int[l];
        for (int i = 0; i < l; i++) {
            long v = q[i];
            int s = 1, e = m, r = m;
            while (s <= e) {
                int md = s + (e - s) / 2;
                if (p[md] > v) {
                    r = md;
                    e = md - 1;
                } else {
                    s = md + 1;
                }
            }
            a[i] = r;
        }
        
        return a;
    }
}