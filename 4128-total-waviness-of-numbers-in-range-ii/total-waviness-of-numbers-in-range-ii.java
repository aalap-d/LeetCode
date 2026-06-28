import java.util.Arrays;

public class Solution {
    private long[][][][][] d;
    private long[][][][] c;

    public long totalWaviness(long n1, long n2) {
        return s(n2) - s(n1 - 1);
    }

    private long s(long n) {
        if (n < 100) return 0;
        String t = Long.toString(n);
        int l = t.length();
        
        d = new long[l][12][12][2][2];
        for (long[][][][] a : d)
            for (long[][][] b : a)
                for (long[][] r : b)
                    for (long[] o : r)
                        Arrays.fill(o, -1);

        c = new long[l][12][2][2];
        for (long[][][] a : c)
            for (long[][] b : a)
                for (long[] r : b)
                    Arrays.fill(r, -1);

        return g(0, 11, 11, 0, 0, t);
    }

    private long g(int i, int p, int p2, int k, int st, String t) {
        if (i == t.length()) return 0;
        if (d[i][p][p2][k][st] != -1) return d[i][p][p2][k][st];

        int lm = (k == 1) ? 9 : (t.charAt(i) - '0');
        long ans = 0;

        for (int v = 0; v <= lm; v++) {
            int nk = (k == 1 || v < lm) ? 1 : 0;
            int nst = (st == 1 || v > 0) ? 1 : 0;
            int w = 0;

            if (st == 1 && p != 11 && p2 != 11) {
                if ((p > p2 && p > v) || (p < p2 && p < v)) {
                    w = 1;
                }
            }

            if (w == 1) {
                ans += f(i + 1, nst == 1 ? v : 11, nk, nst, t);
            }
            ans += g(i + 1, nst == 1 ? v : 11, p, nk, nst, t);
        }

        return d[i][p][p2][k][st] = ans;
    }

    private long f(int i, int p, int k, int st, String t) {
        if (i == t.length()) return st == 1 ? 1 : 0;
        if (c[i][p][k][st] != -1) return c[i][p][k][st];

        int lm = (k == 1) ? 9 : (t.charAt(i) - '0');
        long ans = 0;

        for (int v = 0; v <= lm; v++) {
            int nk = (k == 1 || v < lm) ? 1 : 0;
            int nst = (st == 1 || v > 0) ? 1 : 0;
            ans += f(i + 1, nst == 1 ? v : 11, nk, nst, t);
        }

        return c[i][p][k][st] = ans;
    }
}