class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length(), ans = 0, p = 0;
        for (int i = k - 1; i < n; i++) {
            if (i - k + 1 >= p && isPal(s, i - k + 1, i)) {
                ans++;
                p = i + 1;
            } else if (i - k >= p && isPal(s, i - k, i)) {
                ans++;
                p = i + 1;
            }
        }
        return ans;
    }

    private boolean isPal(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}