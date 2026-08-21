class Solution {
    public long findKthSmallest(int[] c, int k) {
        long l = 1, h = 0;
        int min = c[0];
        for (int x : c) {
            if (x < min) min = x;
        }
        h = (long) min * k;
        long ans = h;
        while (l <= h) {
            long m = l + (h - l) / 2;
            if (cnt(c, m) >= k) {
                ans = m;
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }

    private long cnt(int[] c, long m) {
        long t = 0;
        int n = c.length;
        for (int i = 1; i < (1 << n); i++) {
            long lcm = 1;
            int b = 0;
            boolean ovf = false;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    b++;
                    lcm = lcm(lcm, c[j]);
                    if (lcm > m) {
                        ovf = true;
                        break;
                    }
                }
            }
            if (!ovf) {
                if (b % 2 == 1) {
                    t += m / lcm;
                } else {
                    t -= m / lcm;
                }
            }
        }
        return t;
    }

    private long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}