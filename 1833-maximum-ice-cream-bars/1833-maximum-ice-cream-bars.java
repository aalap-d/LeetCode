class Solution {
    public int maxIceCream(int[] c, int n) {
        int m = 0;
        for (int x : c) {
            if (x > m) m = x;
        }
        
        int[] f = new int[m + 1];
        for (int x : c) {
            f[x]++;
        }
        
        int r = 0;
        for (int i = 1; i <= m; i++) {
            if (f[i] > 0) {
                if (n >= i) {
                    int b = Math.min(f[i], n / i);
                    r += b;
                    n -= b * i;
                } else {
                    break;
                }
            }
        }
        
        return r;
    }
}