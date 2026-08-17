class Solution {
    int[][] d;
    int[] s;

    public int stoneGameV(int[] a) {
        int n = a.length;
        d = new int[n][n];
        s = new int[n + 1];
        for (int i = 0; i < n; i++) {
            s[i + 1] = s[i] + a[i];
        }
        return c(0, n - 1);
    }

    int c(int i, int j) {
        if (i == j) return 0;
        if (d[i][j] > 0) return d[i][j];
        
        int m = 0;
        for (int k = i; k < j; k++) {
            int l = s[k + 1] - s[i];
            int r = s[j + 1] - s[k + 1];
            
            if (l < r) {
                m = Math.max(m, l + c(i, k));
            } else if (l > r) {
                m = Math.max(m, r + c(k + 1, j));
            } else {
                m = Math.max(m, l + Math.max(c(i, k), c(k + 1, j)));
            }
        }
        return d[i][j] = m;
    }
}