class Solution {
    public int maxLength(int[] a) {
        int n = a.length;
        int ans = 1;
        long ml = 1;
        int mv = 0;

        for (int x : a) {
            ml = lcm(ml, x);
            mv = Math.max(mv, x);
        }

        long lim = ml * mv;

        for (int i = 0; i < n; i++) {
            long p = 1;
            long g = 0;
            long l = 1;

            for (int j = i; j < n; j++) {
                p *= a[j];
                g = gcd(g, a[j]);
                l = lcm(l, a[j]);

                if (p == l * g) {
                    ans = Math.max(ans, j - i + 1);
                }

                if (p > lim) {
                    break;
                }
            }
        }

        return ans;
    }

    private long gcd(long x, long y) {
        while (y != 0) {
            long t = y;
            y = x % y;
            x = t;
        }
        return x;
    }

    private long lcm(long x, long y) {
        return (x / gcd(x, y)) * y;
    }
}