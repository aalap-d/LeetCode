class Solution {
    public int numberOfSets(int n, int k) {
        int m = 1_000_000_007;
        int[][] dp = new int[n + k][2 * k + 1];
        for (int i = 0; i < n + k; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= Math.min(i, 2 * k); j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % m;
            }
        }
        return dp[n + k - 1][2 * k];
    }
}