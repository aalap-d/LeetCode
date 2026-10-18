import java.util.ArrayList;
import java.util.List;

class Solution {
    private long[][] c;
    private long m = 1_000_000_007L;

    public int numOfWays(int[] nums) {
        int n = nums.length;
        c = new long[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            c[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                c[i][j] = (c[i - 1][j - 1] + c[i - 1][j]) % m;
            }
        }

        List<Integer> a = new ArrayList<>();
        for (int x : nums) {
            a.add(x);
        }

        return (int) ((dfs(a) - 1 + m) % m);
    }

    private long dfs(List<Integer> a) {
        if (a.size() <= 2) {
            return 1;
        }

        int r = a.get(0);
        List<Integer> l = new ArrayList<>();
        List<Integer> rt = new ArrayList<>();

        for (int i = 1; i < a.size(); i++) {
            int v = a.get(i);
            if (v < r) {
                l.add(v);
            } else {
                rt.add(v);
            }
        }

        long left = dfs(l);
        long right = dfs(rt);
        long ways = c[l.size() + rt.size()][l.size()];

        return (((ways * left) % m) * right) % m;
    }
}