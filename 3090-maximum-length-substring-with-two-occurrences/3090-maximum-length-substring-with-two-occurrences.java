class Solution {
    public int maximumLengthSubstring(String s) {
        int[] f = new int[256];
        int l = 0, m = 0, n = s.length();
        for (int r = 0; r < n; r++) {
            char c = s.charAt(r);
            f[c]++;
            while (f[c] > 2) {
                f[s.charAt(l)]--;
                l++;
            }
            m = Math.max(m, r - l + 1);
        }
        return m;
    }
}