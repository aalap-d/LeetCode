class Solution {
    int[][][] dp;
    int md = 1000000007;
    int n;
    int[] a;

    int gcd(int u, int v) {
        if (v == 0) return u;
        return gcd(v, u % v);
    }

    int f(int i, int x, int y) {
        if (i == n) {
            if (x > 0 && x == y) {
                return 1;
            }
            return 0;
        }
        if (dp[i][x][y] != -1) {
            return dp[i][x][y];
        }
        
        long r = 0;
        r = (r + f(i + 1, x, y)) % md;
        r = (r + f(i + 1, x == 0 ? a[i] : gcd(x, a[i]), y)) % md;
        r = (r + f(i + 1, x, y == 0 ? a[i] : gcd(y, a[i]))) % md;
        
        return dp[i][x][y] = (int) r;
    }

    public int subsequencePairCount(int[] nums) {
        n = nums.length;
        a = nums;
        int m = 0;
        
        for (int v : nums) {
            m = Math.max(m, v);
        }
        
        dp = new int[n][m + 1][m + 1];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= m; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        
        return f(0, 0, 0);
    }
}