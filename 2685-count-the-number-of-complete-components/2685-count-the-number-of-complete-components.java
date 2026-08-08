import java.util.ArrayList;
import java.util.List;

class Solution {
    public int countCompleteComponents(int n, int[][] e) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        for (int[] x : e) {
            g.get(x[0]).add(x[1]);
            g.get(x[1]).add(x[0]);
        }

        boolean[] v = new boolean[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (!v[i]) {
                List<Integer> l = new ArrayList<>();
                dfs(i, g, v, l);

                int vc = l.size();
                int ec = 0;
                for (int u : l) {
                    ec += g.get(u).size();
                }

                if (ec == vc * (vc - 1)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private void dfs(int u, List<List<Integer>> g, boolean[] v, List<Integer> l) {
        v[u] = true;
        l.add(u);
        for (int w : g.get(u)) {
            if (!v[w]) {
                dfs(w, g, v, l);
            }
        }
    }
}