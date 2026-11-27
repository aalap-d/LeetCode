class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] v = new int[n];
        int m = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            m = Math.min(m, items[i][1]);
            int c = 1;
            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % items[i][0] == 0) {
                    c++;
                }
            }
            v[i] = c;
        }
        if (m > budget) {
            return 0;
        }
        int[] dp = new int[budget + 1];
        for (int i = 0; i < n; i++) {
            int p = items[i][1];
            int val = v[i];
            for (int w = budget; w >= p; w--) {
                if (w == p || dp[w - p] > 0) {
                    dp[w] = Math.max(dp[w], dp[w - p] + val);
                }
            }
        }
        int ans = 0;
        for (int w = 1; w <= budget; w++) {
            if (dp[w] > 0) {
                ans = Math.max(ans, dp[w] + (budget - w) / m);
            }
        }
        return ans;
    }
}