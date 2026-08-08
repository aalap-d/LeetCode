import java.util.*;

class Solution {
    public int maximumSafenessFactor(List<List<Integer>> g) {
        int n = g.size();
        int[][] d = new int[n][n];
        for (int[] r : d) Arrays.fill(r, -1);
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (g.get(i).get(j) == 1) {
                    q.offer(new int[]{i, j});
                    d[i][j] = 0;
                }
            }
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            int[] p = q.poll();
            for (int i = 0; i < 4; i++) {
                int r = p[0] + dr[i];
                int c = p[1] + dc[i];
                if (r >= 0 && r < n && c >= 0 && c < n && d[r][c] == -1) {
                    d[r][c] = d[p[0]][p[1]] + 1;
                    q.offer(new int[]{r, c});
                }
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        pq.offer(new int[]{d[0][0], 0, 0});
        boolean[][] v = new boolean[n][n];
        v[0][0] = true;

        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int s = p[0], r = p[1], c = p[2];

            if (r == n - 1 && c == n - 1) return s;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !v[nr][nc]) {
                    v[nr][nc] = true;
                    pq.offer(new int[]{Math.min(s, d[nr][nc]), nr, nc});
                }
            }
        }
        return 0;
    }
}