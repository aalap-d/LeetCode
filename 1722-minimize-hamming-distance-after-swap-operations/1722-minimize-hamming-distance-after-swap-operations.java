import java.util.*;

class Solution {
    int[] p;

    int f(int x) {
        if (p[x] == x) {
            return x;
        }
        return p[x] = f(p[x]);
    }

    void u(int x, int y) {
        int r1 = f(x);
        int r2 = f(y);
        if (r1 != r2) {
            p[r1] = r2;
        }
    }

    public int minimumHammingDistance(int[] s, int[] t, int[][] a) {
        int n = s.length;
        p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }

        for (int[] w : a) {
            u(w[0], w[1]);
        }

        Map<Integer, Map<Integer, Integer>> m = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int r = f(i);
            m.putIfAbsent(r, new HashMap<>());
            Map<Integer, Integer> c = m.get(r);
            c.put(s[i], c.getOrDefault(s[i], 0) + 1);
        }

        int d = 0;
        for (int i = 0; i < n; i++) {
            int r = f(i);
            Map<Integer, Integer> c = m.get(r);
            if (c.getOrDefault(t[i], 0) > 0) {
                c.put(t[i], c.get(t[i]) - 1);
            } else {
                d++;
            }
        }

        return d;
    }
}