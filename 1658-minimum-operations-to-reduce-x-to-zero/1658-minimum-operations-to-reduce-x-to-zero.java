class Solution {
    public int minOperations(int[] a, int x) {
        int t = 0;
        for (int v : a) {
            t += v;
        }

        int target = t - x;

        if (target == 0) {
            return a.length;
        }
        if (target < 0) {
            return -1;
        }

        int maxLen = -1;
        int cur = 0;
        int l = 0;

        for (int r = 0; r < a.length; r++) {
            cur += a[r];

            while (cur > target && l <= r) {
                cur -= a[l];
                l++;
            }

            if (cur == target) {
                int len = r - l + 1;
                if (len > maxLen) {
                    maxLen = len;
                }
            }
        }

        return maxLen == -1 ? -1 : a.length - maxLen;
    }
}