class Solution {
    int m;
    int n;
    int[] d = {-1, 0, 1, 0, -1};

    public boolean containsCycle(char[][] g) {
        m = g.length;
        n = g[0].length;
        boolean[][] v = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!v[i][j]) {
                    if (dfs(g, v, i, j, -1, -1, g[i][j])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    boolean dfs(char[][] g, boolean[][] v, int r, int c, int pr, int pc, char ch) {
        if (v[r][c]) {
            return true;
        }
        v[r][c] = true;

        for (int k = 0; k < 4; k++) {
            int nr = r + d[k];
            int nc = c + d[k + 1];

            if (nr >= 0 && nr < m && nc >= 0 && nc < n && g[nr][nc] == ch) {
                if (nr != pr || nc != pc) {
                    if (dfs(g, v, nr, nc, r, c, ch)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}