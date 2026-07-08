class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        long md = 1000000007;
        long[] p = new long[n + 1];
        int[] c = new int[n + 1];
        long[] u = new long[n + 1];
        long[] pw = new long[n + 1];
        
        pw[0] = 1;
        for (int i = 0; i < n; i++) {
            pw[i + 1] = (pw[i] * 10) % md;
            int d = s.charAt(i) - '0';
            c[i + 1] = c[i];
            p[i + 1] = p[i];
            u[i + 1] = u[i];
            
            if (d > 0) {
                c[i + 1]++;
                p[i + 1] = (p[i] * 10 + d) % md;
                u[i + 1] = u[i] + d;
            }
        }
        
        int[] a = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            
            int ln = c[r + 1] - c[l];
            long x = (p[r + 1] - (p[l] * pw[ln]) % md + md) % md;
            long sm = u[r + 1] - u[l];
            
            a[i] = (int)((x * (sm % md)) % md);
        }
        
        return a;
    }
}