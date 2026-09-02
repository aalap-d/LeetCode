class Solution {

    static final int[] dx = { 0, 1, 0, -1 };
    static final int[] dy = { 1, 0, -1, 0 };

    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        int[][] id = new int[m][n];
        int sx = 0,
            sy = 0,
            cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = classroom[i].charAt(j);
                if (c == 'S') {
                    sx = i;
                    sy = j;
                } else if (c == 'L') {
                    id[i][j] = 1 << cnt;
                    cnt++;
                }
            }
        }
        int full = 1 << cnt;
        int[][][] bestEnergy = new int[m][n][full];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(bestEnergy[i][j], -1);
            }
        }

        bestEnergy[sx][sy][0] = energy;

        class Info {

            int x, y, mask, e, steps;

            Info(int x, int y, int mask, int e, int steps) {
                this.x = x;
                this.y = y;
                this.mask = mask;
                this.e = e;
                this.steps = steps;
            }
        }
        Deque<Info> q = new ArrayDeque<>();
        q.addLast(new Info(sx, sy, 0, energy, 0));
        while (!q.isEmpty()) {
            Info t = q.removeFirst();
            if (t.mask == full - 1) {
                return t.steps;
            }
            if (t.e == 0) {
                continue;
            }
            for (int d = 0; d < 4; d++) {
                int nx = t.x + dx[d];
                int ny = t.y + dy[d];
                if (
                    nx < 0 ||
                    nx >= m ||
                    ny < 0 ||
                    ny >= n ||
                    classroom[nx].charAt(ny) == 'X'
                ) {
                    continue;
                }
                int ne = classroom[nx].charAt(ny) == 'R' ? energy : t.e - 1;
                int nmask = t.mask | id[nx][ny];
                if (ne > bestEnergy[nx][ny][nmask]) {
                    bestEnergy[nx][ny][nmask] = ne;
                    q.addLast(new Info(nx, ny, nmask, ne, t.steps + 1));
                }
            }
        }
        return -1;
    }
}