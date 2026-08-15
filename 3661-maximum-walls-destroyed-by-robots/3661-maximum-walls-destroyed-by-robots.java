import java.util.*;

class Solution {
    public int maxWalls(int[] rp, int[] d, int[] wp) {
        int n = rp.length;
        int[][] r = new int[n][2];
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            r[i][0] = rp[i];
            r[i][1] = d[i];
            set.add(rp[i]);
        }
        
        Arrays.sort(r, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(wp);
        
        int m = wp.length;
        int[] temp = new int[m];
        int wc = 0;
        int base = 0;
        
        for (int i = 0; i < m; i++) {
            if (i > 0 && wp[i] == wp[i-1]) continue;
            if (set.contains(wp[i])) {
                base++;
            } else {
                temp[wc++] = wp[i];
            }
        }
        
        int[] w = Arrays.copyOf(temp, wc);
        int[][] dp = new int[n + 1][2];
        
        int cl1 = cnt(w, r[0][0] - r[0][1], r[0][0] - 1);
        dp[1][0] = cl1;
        dp[1][1] = 0;
        
        for (int i = 2; i <= n; i++) {
            int xp = r[i-2][0];
            int dpv = r[i-2][1];
            int xc = r[i-1][0];
            int dc = r[i-1][1];
            
            int A = Math.min(xc - 1, xp + dpv);
            int B = Math.max(xp + 1, xc - dc);
            
            int crp = cnt(w, xp + 1, A);
            int clc = cnt(w, B, xc - 1);
            
            int cb = 0;
            if (A >= B - 1) {
                cb = cnt(w, xp + 1, xc - 1);
            } else {
                cb = crp + clc;
            }
            
            dp[i][0] = Math.max(dp[i-1][0] + clc, dp[i-1][1] + cb);
            dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1] + crp);
        }
        
        int crn = cnt(w, r[n-1][0] + 1, r[n-1][0] + r[n-1][1]);
        
        return base + Math.max(dp[n][0], dp[n][1] + crn);
    }
    
    int cnt(int[] w, int L, int R) {
        if (L > R) return 0;
        int lidx = lb(w, L);
        int ridx = ub(w, R);
        return ridx - lidx;
    }
    
    int lb(int[] w, int v) {
        int l = 0, r = w.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (w[m] >= v) r = m;
            else l = m + 1;
        }
        return l;
    }
    
    int ub(int[] w, int v) {
        int l = 0, r = w.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (w[m] > v) r = m;
            else l = m + 1;
        }
        return l;
    }
}
