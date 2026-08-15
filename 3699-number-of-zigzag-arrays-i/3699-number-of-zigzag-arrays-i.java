class Solution {
    public int zigZagArrays(int n, int l, int r) {
        int m = 1000000007;
        int k = r - l + 1;
        if (n == 1) {
            return k % m;
        }
        int[] d = new int[k];
        for (int i = 0; i < k; i++) {
            d[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            int p = 0;
            if ((i & 1) == 1) {
                for (int j = 0; j < k; j++) {
                    int t = (p + d[j]) % m;
                    d[j] = p;
                    p = t;
                }
            } else {
                for (int j = k - 1; j >= 0; j--) {
                    int t = (p + d[j]) % m;
                    d[j] = p;
                    p = t;
                }
            }
        }
        int s = 0;
        for (int i = 0; i < k; i++) {
            s = (s + d[i]) % m;
        }
        return (s * 2) % m;
    }
}