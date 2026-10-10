class Solution {
    public long minSumSquareDiff(int[] a, int[] b, int k1, int k2) {
        int n = a.length;
        int[] d = new int[n];
        int mx = 0;
        long k = (long) k1 + k2;

        for (int i = 0; i < n; i++) {
            d[i] = Math.abs(a[i] - b[i]);
            if (d[i] > mx) {
                mx = d[i];
            }
        }

        int[] cnt = new int[mx + 1];
        for (int v : d) {
            cnt[v]++;
        }

        for (int v = mx; v > 0 && k > 0; v--) {
            if (cnt[v] == 0) {
                continue;
            }

            long c = cnt[v];
            long red = Math.min(k, c);

            cnt[v] -= red;
            cnt[v - 1] += red;
            k -= red;

            if (k > 0 && cnt[v] > 0) {
                break;
            }
        }

        long ans = 0;
        for (int v = 1; v <= mx; v++) {
            if (cnt[v] > 0) {
                ans += (long) cnt[v] * v * v;
            }
        }

        return ans;
    }
}