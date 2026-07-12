class Solution {
    public long sumAndMultiply(int n) {
        long a = Math.abs((long) n);
        long x = 0;
        long s = 0;
        long m = 1;

        while (a > 0) {
            long d = a % 10;
            if (d != 0) {
                x = d * m + x;
                s += d;
                m *= 10;
            }
            a /= 10;
        }
        if (n < 0) {
            x = -x;
        }

        return x * s;
    }
}