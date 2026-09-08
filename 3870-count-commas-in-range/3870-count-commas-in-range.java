class Solution {
    public int countCommas(int n) {
        int ans = 0;
        int p = 1000;
        while (n >= p) {
            ans += (n - p + 1);
            if (p > Integer.MAX_VALUE / 1000) {
                break;
            }
            p *= 1000;
        }
        return ans;
    }
}