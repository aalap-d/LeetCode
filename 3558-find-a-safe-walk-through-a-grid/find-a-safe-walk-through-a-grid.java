import java.util.*;

class Solution 
{
    public boolean findSafeWalk(List<List<Integer>> grid, int health)
     {
        int m, n, r, c, h, nr, nc, nh, i;
        int[][] v;
        int[] d, cur, row;
        Deque<int[]> q;

        m = grid.size();
        n = grid.get(0).size();
        v = new int[m][n];
        d = new int[]{-1, 0, 1, 0, -1};
        q = new ArrayDeque<>();

        for (int[] a : v) Arrays.fill(a, -1);

        h = health - grid.get(0).get(0);
        if (h <= 0) 
        return false;

        q.offer(new int[]{0, 0, h});
        v[0][0] = h;

        while (!q.isEmpty()) 
        {
            cur = q.poll();
            r = cur[0];
            c = cur[1];
            h = cur[2];

            if (r == m - 1 && c == n - 1) 
            return true;

            for (i = 0; i < 4; i++) 
            {
                nr = r + d[i];
                nc = c + d[i + 1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n) 
                {
                    nh = h - grid.get(nr).get(nc);
                    if (nh > 0 && nh > v[nr][nc])
                     {
                        v[nr][nc] = nh;
                        if (grid.get(nr).get(nc) == 0) 
                        {
                            q.offerFirst(new int[]{nr, nc, nh});
                        } 
                        else 
                        {
                            q.offerLast(new int[]{nr, nc, nh});
                        }
                    }
                }
            }
        }
        return false;
    }
}