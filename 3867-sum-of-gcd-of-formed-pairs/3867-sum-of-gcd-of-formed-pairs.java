import java.util.*;

class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] v = nums;
        int[] pg = new int[n];
        int mx = v[0];

        for (int i = 0; i < n; i++) {
            mx = Math.max(mx, v[i]);
            pg[i] = g(v[i], mx);
        }

        Arrays.sort(pg);

        long s = 0;
        int l = 0;
        int r = n - 1;

        while (l < r) {
            s += (long) g(pg[l], pg[r]);
            l++;
            r--;
        }

        return s;
    }

    private int g(int a, int b) {
        while (b != 0) {
            a %= b;
            int t = a;
            a = b;
            b = t;
        }
        return a;
    }
}