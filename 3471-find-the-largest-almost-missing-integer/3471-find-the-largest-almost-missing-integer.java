class Solution {
    public int largestInteger(int[] a, int k) {
        int m = -1;
        for (int v : a) {
            if (v > m) m = v;
        }
        int[] c = new int[m + 1];
        int n = a.length;
        for (int i = 0; i <= n - k; i++) {
            boolean[] s = new boolean[m + 1];
            for (int j = i; j < i + k; j++) {
                if (!s[a[j]]) {
                    s[a[j]] = true;
                    c[a[j]]++;
                }
            }
        }
        int r = -1;
        for (int i = 0; i <= m; i++) {
            if (c[i] == 1) {
                r = i;
            }
        }
        return r;
    }
}