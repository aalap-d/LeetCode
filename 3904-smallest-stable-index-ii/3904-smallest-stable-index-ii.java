class Solution {
    public int firstStableIndex(int[] a, int k) {
        int n = a.length;
        int[] p = new int[n];
        int[] s = new int[n];
        p[0] = a[0];
        for (int i = 1; i < n; i++) {
            p[i] = Math.max(p[i - 1], a[i]);
        }
        s[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            s[i] = Math.min(s[i + 1], a[i]);
        }
        for (int i = 0; i < n; i++) {
            if (p[i] - s[i] <= k) {
                return i;
            }
        }
        return -1;
    }
}