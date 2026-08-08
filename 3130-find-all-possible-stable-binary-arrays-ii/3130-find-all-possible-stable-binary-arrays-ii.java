class Solution {
    public int numberOfStableArrays(int z, int o, int lim) {
        long[][][] dp = new long[z + 1][o + 1][2];
        int mod = 1_000_000_007;

        for (int i = 1; i <= Math.min(z, lim); i++) dp[i][0][0] = 1;
        for (int j = 1; j <= Math.min(o, lim); j++) dp[0][j][1] = 1;

        for (int i = 1; i <= z; i++) {
            for (int j = 1; j <= o; j++) {
                dp[i][j][0] = (dp[i - 1][j][0] + dp[i - 1][j][1]) % mod;
                if (i > lim) {
                    dp[i][j][0] = (dp[i][j][0] - dp[i - lim - 1][j][1] + mod) % mod;
                }

                dp[i][j][1] = (dp[i][j - 1][0] + dp[i][j - 1][1]) % mod;
                if (j > lim) {
                    dp[i][j][1] = (dp[i][j][1] - dp[i][j - lim - 1][0] + mod) % mod;
                }
            }
        }

        return (int) ((dp[z][o][0] + dp[z][o][1]) % mod);
    }
}

