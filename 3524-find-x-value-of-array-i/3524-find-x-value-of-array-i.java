class Solution {
    public long[] resultArray(int[] nums, int k) {
        int n = nums.length;
        long[] res = new long[k];
        long[] dp = new long[k];

        for (int i = 0; i < n; i++) {
            long[] next = new long[k];
            int v = nums[i] % k;
            next[v]++;

            for (int r = 0; r < k; r++) {
                if (dp[r] > 0) {
                    int nr = (int) ((1L * r * v) % k);
                    next[nr] += dp[r];
                }
            }

            for (int r = 0; r < k; r++) {
                res[r] += next[r];
            }

            dp = next;
        }

        return res;
    }
}