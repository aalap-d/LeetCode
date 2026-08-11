class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][] d = new int[n][n + 1];
        int[] s = new int[n + 1];
        
        for (int i = n - 1; i >= 0; i--) {
            s[i] = s[i + 1] + piles[i];
        }
        
        return f(piles, 0, 1, d, s, n);
    }

    private int f(int[] piles, int i, int m, int[][] d, int[] s, int n) {
        if (i == n) return 0;
        if (2 * m >= n - i) return s[i];
        if (d[i][m] != 0) return d[i][m];
        
        int r = 0;
        for (int x = 1; x <= 2 * m; x++) {
            r = Math.max(r, s[i] - f(piles, i + x, Math.max(m, x), d, s, n));
        }
        
        d[i][m] = r;
        return r;
    }
}