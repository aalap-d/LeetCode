class Solution {
    private Boolean[][][] dp;

    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if ((m + n - 1) % 2 != 0 || grid[0][0] == ')' || grid[m - 1][n - 1] == '(') {
            return false;
        }

        int max = (m + n) / 2;
        dp = new Boolean[m][n][max + 1];

        return dfs(grid, 0, 0, 0, m, n, max);
    }

    private boolean dfs(char[][] g, int r, int c, int b, int m, int n, int max) {
        b += (g[r][c] == '(' ? 1 : -1);

        if (b < 0 || b > max) {
            return false;
        }

        if (r == m - 1 && c == n - 1) {
            return b == 0;
        }

        if (dp[r][c][b] != null) {
            return dp[r][c][b];
        }

        boolean res = false;
        if (r + 1 < m) {
            res = dfs(g, r + 1, c, b, m, n, max);
        }
        if (!res && c + 1 < n) {
            res = dfs(g, r, c + 1, b, m, n, max);
        }

        return dp[r][c][b] = res;
    }
}